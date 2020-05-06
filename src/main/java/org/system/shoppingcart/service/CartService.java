package org.system.shoppingcart.service;

import org.system.shoppingcart.model.Cart;

public interface CartService {
    Cart addToCart(Integer productId, String email, Integer quantity);
    void removeLine(String email, Long lineId);
    void saveCart(Cart cart);
    Cart getById(Long cartId);
    void updateLine(String email, Long lineId, Integer quantity);

}
