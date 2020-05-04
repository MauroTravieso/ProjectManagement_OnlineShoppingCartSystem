package org.system.enduser.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.system.product.model.Product;
import org.system.product.repository.ProductRepository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.sql.rowset.Predicate;

//Mingyu Zhou(986674)
@Service
public class ProductListService {
    @Autowired
    private ProductRepository productRepository;

    public Page<Product> getProductListByPage(int page) {
        Pageable pageable = PageRequest.of(page, 16);
        Page<Product> productPage = productRepository.findAll(pageable);
        return productPage;
    }

    public Page<Product> getProductListByKeyWord(String title, int page) {
        Pageable pageable = PageRequest.of(page, 16);
        Page<Product> productPage = productRepository.findByTitleLike(title, pageable);
        return productPage;
    }
}
