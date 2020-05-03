package org.system.product.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.system.product.model.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, String> {
    List<Product> findByTitleLike(String title);
    @Query("SELECT p FROM Product p WHERE p.title LIKE ?1%")
    Page<Product> findByTitleLike(String title, Pageable pageable);
}
