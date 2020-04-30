package org.system.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.system.product.model.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, String> {

    List<Product> findByTitleLike(String title);

}
