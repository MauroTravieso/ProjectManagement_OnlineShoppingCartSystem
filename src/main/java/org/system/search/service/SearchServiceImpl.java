package org.system.search.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.system.product.model.Product;
import org.system.search.repository.SearchRepository;
/**
 * Search Service
 *
 * Bugs: none known
 *
 * @author       Dinh Nguyen (986520) - Team II APR2020
 * @version      1.0
 *
 */
import java.util.List;
@Service
public class SearchServiceImpl implements SearchService{

    @Autowired
    SearchRepository searchRepository;
    @Override
    public List<Product> searchProductByEndUser(String searchKey, Integer pageNo, Integer pageSize, String sortBy) {
        return searchRepository.searchProductByEndUser(searchKey, PageRequest.of(pageNo, pageSize, Sort.by(sortBy)));
    }

    @Override
    public List<Product> searchProductByVendor(String searchKey, String vendorId, Integer pageNo, Integer pageSize, String sortBy) {
        return searchRepository.searchProductByVendor(searchKey, vendorId, PageRequest.of(pageNo, pageSize, Sort.by(sortBy)));
    }
}
