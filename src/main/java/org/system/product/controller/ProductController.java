package org.system.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.system.product.model.Product;
import org.system.product.service.ProductService;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/searchProductBySeller/{userId}")
    public String searchProduct(@PathVariable String userId) {
        return "views/searchProductBySeller";
    }

    @GetMapping("/addProductBySeller/{userId}")
    public String addProduct(@PathVariable String userId, Model model) {
        model.addAttribute("product", new Product());
        return "views/addProductBySeller";
    }

    @PostMapping("/addProductToDB")
    public String addProductToDB(@ModelAttribute Product product) {
        product.setImage("image");
        product.setVendor_id("aaa@gmail.com");
        productService.addProduct(product);
        return "/views/success";
    }

}
