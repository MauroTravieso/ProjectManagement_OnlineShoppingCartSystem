package org.system.payment.service;

import org.system.admin.model.User;
import org.system.payment.model.Order;

import java.util.List;

public interface OrderService {
    Order saveOrder(Order order, Long cartId, String email);
    Order getOrderById(Long id);
    //List<Order> findAllByUser(User user);
   // List<Order> findAllByUserAndStatusEquals(User user, int status);
    void save(Order order);
    Order findById(Long id);
    //List<Order> findAll();
    //List<Order> findAllByStatus(int status);
    void updateStatus(Long orderId, int status);
}
