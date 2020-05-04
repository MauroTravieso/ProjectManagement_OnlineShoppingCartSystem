package org.system.shoppingcart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.system.admin.service.UserService;
import org.system.product.service.ProductService;
import org.system.shoppingcart.model.Cart;
import org.system.shoppingcart.model.Line;
import org.system.shoppingcart.repository.CartRepository;
import org.system.shoppingcart.repository.LineRepository;

import javax.transaction.Transactional;

@Service
@Transactional
public class CartServiceImpl implements CartService{


    @Autowired
    CartRepository cartRepository;

    @Autowired
    LineRepository lineRepository;

    @Autowired
    LineService lineService;

    @Autowired
    UserService userService;

    @Autowired
    ProductService productService;

    @Override
    public Cart addToCart(Integer productId, String email, Integer quantity) {
        Line line = new Line();
        line.setQuantity(quantity);
        line.setProduct(productService.findProductById(productId));

        Cart cart = userService.findOne(email).getCart();
        if (cart == null)
            cart = new Cart();
        cart.addLine(line);

        lineRepository.save(line);

        return cartRepository.save(cart);
    }

    @Override
    public void removeLine(String email, Long lineId) {
        Cart cart = userService.findOne(email).getCart();

        System.out.println("*************** line id = " + lineId);

        cart.getLines().remove(lineService.getLineById(lineId));
        saveCart(cart);
    }

    @Override
    public void saveCart(Cart cart) {
        cartRepository.save(cart);
    }

    @Override
    public Cart getById(Long cartId) {
        return cartRepository.findById(cartId).get();
    }

    @Override
    public void updateLine(String email, Long lineId, Integer quantity) {
        Cart cart = userService.findOne(email).getCart();
        int index = cart.getLines().indexOf(lineService.getLineById(lineId));
        cart.getLines().get(index).setQuantity(quantity);
        cart.getLines().get(index).getPrice();
        cartRepository.save(cart);
    }
}
