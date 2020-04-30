package org.system.shoppingcart.service;

import org.system.shoppingcart.model.Cart;

public interface CartService {
    Cart addToCart(int productId, String username, int quantity);
    void removeLine(String username, Long lineId);
    void saveCart(Cart cart);
    Cart getById(Long cartId);
    void updateLine(String username, Long lineId, Integer quantity);
}
