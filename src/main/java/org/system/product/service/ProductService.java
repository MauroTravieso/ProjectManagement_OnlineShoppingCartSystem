package org.system.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.system.product.model.Product;
import org.system.product.repository.ProductRepository;

import java.util.List;

/**
 * Application ProductService.
 *
 * Bugs: none known
 *
 * @author       Team II APR2020 - Duosi Zhang (987000)
 * @version      1.0
 *
 */
@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getProductListByKeyWord(String title, String userId) {
        return productRepository.findByTitleLikeAndUserId(userId, title);
    }

    public void addProduct(Product product) {
        productRepository.save(product);
    }

    public void deleteProduct(Product product) {
        productRepository.delete(product);
    }

    public void updateProduct(Product product) {
        productRepository.save(product);
    }

    public Product findProductById(String id) {
        return productRepository.findById(Integer.valueOf(id)).get();
    }

    public Product findProductById(Integer id) {
        return productRepository.findById(id).get();
    }

}
