package org.system.shoppingcart.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.system.shoppingcart.model.Cart;

/**
 * Cart Repository
 *
 * Bugs: none known
 *
 * @author       Shiraz Shrestha (987052) - Team II APR2020
 * @version      1.0
 *
 */

@Repository
public interface CartRepository extends CrudRepository<Cart, Long> {
}
