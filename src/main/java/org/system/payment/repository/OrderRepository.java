package org.system.payment.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.system.admin.model.User;
import org.system.payment.model.Order;

import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
    @Query("select o from Order o join o.user u where u.email=?1 ")
    List<Order> findByEmail(String email);
   /* List<Order> findAllByUserOrderByLocalDateTimeDesc(User user);
    List<Order> findAllByUserAAndStatusEqualsOrderByLocalDateTimeDesc(User user, int status);
    List<Order> findAllByOrderByLocalDateTimeDesc();
    List<Order> findAllByStatusEqualsOrderByLocalDateTimeDesc(int status);*/
}
