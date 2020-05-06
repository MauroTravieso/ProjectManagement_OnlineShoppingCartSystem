package org.system.shoppingcart.service;

import org.system.shoppingcart.model.Cart;

/**
 * Cart Service Interface
 *
 * Bugs: none known
 *
 * @author       Shiraz Shrestha (987052) - Team II APR2020
 * @version      1.0
 *
 */

public interface CartService {
    Cart addToCart(Integer productId, String email, Integer quantity);
    void removeLine(String email, Long lineId);
    void saveCart(Cart cart);
    Cart getById(Long cartId);
    void updateLine(String email, Long lineId, Integer quantity);
}
