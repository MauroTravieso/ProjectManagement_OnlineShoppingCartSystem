package org.system.shoppingcart.service;

import org.system.shoppingcart.model.Line;

/**
 * LineService Interface
 *
 * Bugs: none known
 *
 * @author       Shiraz Shrestha (987052) - Team II APR2020
 * @version      1.0
 *
 */

public interface LineService {
    Line getLineById(Long id);
    void updateQuantity(int quantity, Long lineId);
}
