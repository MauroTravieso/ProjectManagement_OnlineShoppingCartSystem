package org.system.product.model;

import java.util.List;

/**
 * Application ProductListContainer Model.
 *
 * Bugs: none known
 *
 * @author       Team II APR2020 - Duosi Zhang (987000)
 * @version      1.0
 *
 */
public class ProductListContainer {

    private List<Product> productList;

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
