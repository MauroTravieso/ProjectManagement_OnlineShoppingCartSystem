package org.system.search.service;

import org.springframework.data.domain.Pageable;
import org.system.product.model.Product;
import org.system.shoppingcart.model.Cart;

import java.util.List;

public interface SearchService {
    List<Product> searchProductByEndUser(String searchKey, Integer pageNo, Integer pageSize, String sortBy);
    List<Product> searchProductByVendor(String searchKey, String vendorId, Integer pageNo, Integer pageSize, String sortBy);

}
