package org.system.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.system.product.model.Product;
import org.system.product.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getProductListByKeyWord(String keyword) {
        return productRepository.findByKeyword(keyword);
    }

}
