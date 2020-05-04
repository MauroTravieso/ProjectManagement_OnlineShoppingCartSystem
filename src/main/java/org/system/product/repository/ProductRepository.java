package org.system.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.system.product.model.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findByTitleLike(String title);

    @Query(value = "SELECT p FROM Product p WHERE p.vendor_id = ?1 AND p.title LIKE %?2%")
    List<Product> findByTitleLikeAndUserId(String userId, String title);

}
