package org.system.payment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.system.admin.model.User;
import org.system.admin.service.UserService;
import org.system.payment.model.Order;
import org.system.payment.repository.OrderRepository;
import org.system.shoppingcart.model.Cart;
import org.system.shoppingcart.model.Line;
import org.system.shoppingcart.service.CartService;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * OrderService Implementation
 *
 * Bugs: none known
 *
 * @author       Shiraz Shrestha (987052) - Team II APR2020
 * @version      1.0
 *
 */

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CartService cartService;

    @Autowired
    private UserService userService;

    @Override
    public Order saveOrder(Order order, Long cartId, String email) {
        order.setLocalDateTime(LocalDateTime.now());
        Cart cart = cartService.getById(cartId);
        order.setLines(getCopyOfLines(cart.getLines()));
        order.setUser(userService.getUserByEmail(email));
        Order newOrder = orderRepository.save(order);

        return newOrder;
    }

    @Override
    public Order getOrderById(Long id) {
        return orderRepository.findById(id).get();
    }

    @Override
    public void save(Order order) {
        this.orderRepository.save(order);
    }

    @Override
    public Order findById(Long id) {
        return orderRepository.findById(id).get();
    }

    @Override
    public void updateStatus(Long orderId, int status) {
        Order order = findById(orderId);
        order.setStatus(status);
        save(order);
    }

    private List<Line> getCopyOfLines(List<Line> lines){
        List<Line> newLines = new ArrayList<>();

        for (Line line: lines){
            Line newLine = new Line();
            newLine.setProduct(line.getProduct());
            newLine.setQuantity(line.getQuantity());
            newLines.add(newLine);
        }
        return newLines;
    }
}
