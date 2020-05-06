package org.system.payment.service;

import org.springframework.data.jpa.repository.Query;
import org.system.admin.model.User;
import org.system.payment.model.Order;
import org.system.shoppingcart.model.Line;

import java.util.List;

/**
 * OrderService Interface
 *
 * Bugs: none known
 *
 * @author       Shiraz Shrestha (987052) - Team II APR2020
 * @version      1.0
 *
 */

public interface OrderService {
    Order saveOrder(Order order, Long cartId, String email);
    Order getOrderById(Long id);
    void save(Order order);
    Order findById(Long id);
    void updateStatus(Long orderId, int status);
}
