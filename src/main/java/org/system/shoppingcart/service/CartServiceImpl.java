package org.system.shoppingcart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.system.admin.service.UserService;
import org.system.shoppingcart.model.Cart;
import org.system.shoppingcart.repository.CartRepository;

import javax.transaction.Transactional;

@Service
@Transactional
public class CartServiceImpl implements CartService{


    @Autowired
    CartRepository cartRepository;

    @Autowired
    LineService lineService;

    @Autowired
    UserService userService;

    @Override
    public Cart addToCart(int productId, String username, int quantity) {
        return null;
    }

    @Override
    public void removeLine(String username, Long lineId) {

    }

    @Override
    public void saveCart(Cart cart) {

    }

    @Override
    public Cart getById(Long cartId) {
        return null;
    }

    @Override
    public void updateLine(String username, Long lineId, Integer quantity) {

    }
}
