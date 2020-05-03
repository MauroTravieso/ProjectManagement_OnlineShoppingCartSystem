package org.system.search.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.system.product.model.Product;

import java.util.List;


public interface SearchRepository extends JpaRepository<Product, Integer> {
    @Query("select p from Product p where p.title = :productName")
    List<Product> searchProductByEndUser(String productName, Pageable pageRequest);

    @Query("select p from Product p where p.title = :productName and p.vendor_id = :vendorId")
    List<Product> searchProductByVendor(String productName, String vendorId, Pageable pageRequest);
}