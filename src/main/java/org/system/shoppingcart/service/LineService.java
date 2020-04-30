package org.system.shoppingcart.service;

import org.system.shoppingcart.model.Line;

public interface LineService {
    Line getLineById(Long id);
    void updateQuantity(int quantity, Long lineId);
}
