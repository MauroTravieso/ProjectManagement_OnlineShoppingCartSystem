package org.system.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.system.product.model.Product;
import org.system.product.model.ProductListContainer;
import org.system.product.model.ProductProcessStatus;
import org.system.product.model.ProductStatus;
import org.system.product.service.ProductService;

import java.util.List;

@Controller
public class ProductController {

    private String userId = null;

    @Autowired
    private ProductService productService;

    @GetMapping("/searchProductBySeller/{userId}")
    public String searchProduct(@PathVariable String userId, Model model) {
        model.addAttribute("userId", userId);
        return "views/searchProductBySeller";
    }

    @GetMapping("/listProductByKeyword")
    public String listProductByKeyword(Model model, @RequestParam(defaultValue = "") String keyword, @RequestParam(defaultValue = "") String userId) {
        List<Product> productList = productService.getProductListByKeyWord(keyword, userId);
        ProductListContainer productListContainer = new ProductListContainer();
        productListContainer.setProductList(productList);
        model.addAttribute("productListContainer", productListContainer);
        return "views/searchProductBySeller";
    }

    @GetMapping("/productEdit")
    public String productEdit(String product_id, Model model) {
        Product product = productService.findProductById(product_id);
        model.addAttribute("product", product);
        return "views/editProduct";
    }

    @PostMapping("/saveProduct")
    public String doUpdateProduct(Product product) {
        product.setImage("image001");
        productService.updateProduct(product);
        return "views/editProduct";
    }

    @PostMapping("/updateProductStatus")
    public String updateProductStatus(@ModelAttribute ProductListContainer productListContainer, Model model) {
        return "views/searchProductBySeller";
    }

    @GetMapping("/addProduct")
    public String addProduct(Model model, @RequestParam(defaultValue = "") String userId) {
        Product product = new Product();
        product.setVendor_id(userId);
        model.addAttribute("product", product);
        return "views/addProductBySeller";
    }

    @PostMapping("/addProductToDB")
    public String addProductToDB(@ModelAttribute Product product, @ModelAttribute String userId) {
        product.setImage("image");
        product.setVendor_id(userId);
        product.setProduct_status(ProductStatus.AVAILABLE);
        product.setProduct_process_status(ProductProcessStatus.PENDING);
        productService.addProduct(product);
        return "/views/success";
    }

}
