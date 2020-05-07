package org.system.search.service;

import org.springframework.data.domain.Pageable;
import org.system.product.model.Product;
import org.system.shoppingcart.model.Cart;

import java.util.List;
/**
 * Search Service
 *
 * Bugs: none known
 *
 * @author       Dinh Nguyen (986520) - Team II APR2020
 * @version      1.0
 *
 */

public interface SearchService {
    List<Product> searchProductByEndUser(String searchKey, Integer pageNo, Integer pageSize, String sortBy);
    List<Product> searchProductByVendor(String searchKey, String vendorId, Integer pageNo, Integer pageSize, String sortBy);

}
