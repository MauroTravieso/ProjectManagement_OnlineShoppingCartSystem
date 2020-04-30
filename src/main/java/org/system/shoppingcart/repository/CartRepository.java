package org.system.shoppingcart.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.system.shoppingcart.model.Cart;

@Repository
public interface CartRepository extends CrudRepository<Cart, Long> {
}
