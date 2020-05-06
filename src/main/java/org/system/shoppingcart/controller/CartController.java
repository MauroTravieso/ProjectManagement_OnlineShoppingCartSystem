package org.system.shoppingcart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.system.admin.model.User;
import org.system.admin.service.UserService;
import org.system.payment.model.Address;
import org.system.payment.model.Order;
import org.system.payment.service.OrderService;
import org.system.shoppingcart.model.Cart;
import org.system.shoppingcart.model.Line;
import org.system.shoppingcart.service.CartService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class CartController {

    @Autowired
    CartService cartService;

    @Autowired
    UserService userService;

    @Autowired
    OrderService orderService;

    @ModelAttribute("line_number")
    private int getLinesNumber(HttpSession session) {
        String email = (String) session.getAttribute("email");
        User user = userService.findOne(email);
        return userService.countLinesNumber(user.getEmail());
    }

    @ModelAttribute("cart")
    private Cart getCart(HttpSession session) {
        String email = (String) session.getAttribute("email");
        User user = userService.findOne(email);
        return user.getCart();
    }

    @GetMapping("/cart/add/{id}")
    public String addToCart(@PathVariable("id") Integer productId, @RequestParam(value = "quantity", required = false, defaultValue = "1") Integer quantity, HttpSession session, Model model) {
        String email = (String) session.getAttribute("email");
        User user = userService.findOne(email);
        model.addAttribute("user", user);
        cartService.addToCart(productId, user.getEmail(), quantity);
        return "redirect:/home";
    }

    @GetMapping("/user/cart")
    public String showCart(Model model, HttpSession session) {
        String email = (String) session.getAttribute("email");
        List<Line> lines = userService.getUserByEmail(email).getCart().getLines();
        model.addAttribute("lines", lines);
        return "views/cart";
    }

    @PostMapping("/user/cart/delete/{id}")
    public String deleteLine(@PathVariable("id") Long lineId, HttpSession session) {
        String email = (String) session.getAttribute("email");
        User user = userService.findOne(email);

        System.out.println("*************** line id = " + lineId);

        cartService.removeLine(user.getEmail(), lineId);
        return "redirect:/user/cart";
    }

    @GetMapping("/cart/checkout")
    public String checkout(@ModelAttribute Order order, HttpSession session) {
        if (getLinesNumber(session) == 0)
            throw new RuntimeException("You cannot purchase with an empty cart");
        return "views/checkout";
    }

    @PostMapping("/cart/purchase")
    public String saveOrder(@Valid @ModelAttribute("order") Order order, BindingResult result, @RequestParam(value = "sameadr", required = false) String sameAddress, HttpSession session) {
        if (sameAddress != null) {
            Address billingAddress = new Address();
            billingAddress.setName(order.getShippingAddress().getName());
            billingAddress.setStreet(order.getShippingAddress().getStreet());
            billingAddress.setState(order.getShippingAddress().getState());
            billingAddress.setZipCode(order.getShippingAddress().getZipCode());
            order.setBillingAddress(billingAddress);
            result = ignoreFieldsContaining("billingAddress", result, order);
        }

        if (result.hasErrors()) {
            return "views/checkout";
        }

        String email = (String) session.getAttribute("email");
        User user = userService.findOne(email);
        Order newOrder = orderService.saveOrder(order, getCart(session).getId(), user.getEmail());

        Cart newCart = new Cart();
        user.setCart(newCart);
        userService.save(user);

        return "redirect:/user/orders/" + newOrder.getId();
    }

    private BindingResult ignoreFieldsContaining(String ignoreString, BindingResult result, Order order) {
        List<FieldError> errorsToKeep = result.getFieldErrors().stream()
                .filter(fer -> !fer.getField().contains(ignoreString))
                .collect(Collectors.toList());

        BindingResult newResult = new BeanPropertyBindingResult(order, "order");

        for (FieldError fieldError : errorsToKeep) {
            newResult.addError(fieldError);
        }

        return newResult;
    }

    @GetMapping("/user/updateline/{id}/{qty}")
    @ResponseBody
    private void updateQty(@PathVariable Long id, @PathVariable int qty, HttpSession session) {
        String email = (String) session.getAttribute("email");
        User user = userService.findOne(email);
        cartService.updateLine(user.getEmail(), id, qty);
    }
}
