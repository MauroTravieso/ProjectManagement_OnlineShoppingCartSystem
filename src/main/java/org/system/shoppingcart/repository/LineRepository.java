package org.system.shoppingcart.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.system.shoppingcart.model.Line;

@Repository
public interface LineRepository extends CrudRepository<Line, Long> {

}
