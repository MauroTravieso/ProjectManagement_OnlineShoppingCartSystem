package org.system.shoppingcart.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.system.shoppingcart.model.Line;

/**
 * Line Repository
 *
 * Bugs: none known
 *
 * @author       Shiraz Shrestha (987052) - Team II APR2020
 * @version      1.0
 *
 */

@Repository
public interface LineRepository extends CrudRepository<Line, Long> {

}
