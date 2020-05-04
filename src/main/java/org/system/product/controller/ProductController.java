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

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.List;

/**
 * Duosi Zhang Team2
 */
@Controller
public class ProductController {

    private String userId = null;

    @Autowired
    private ProductService productService;

    @GetMapping("/searchProductBySeller")
    public String searchProduct(Model model, Principal principal, HttpSession session) {
        String email = principal.getName();
        session.setAttribute("email", email);
        model.addAttribute("userId", email);
        return "views/searchProductBySeller";
    }

    @GetMapping("/listProductByKeyword")
    public String listProductByKeyword(Model model, @RequestParam(defaultValue = "") String keyword, Principal principal, HttpSession session) {
        String email = principal.getName();
        session.setAttribute("email", email);
        List<Product> productList = productService.getProductListByKeyWord(keyword, email);
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
        productService.updateProduct(product);
        return "views/editProduct";
    }

    @PostMapping("/updateProductStatus")
    public String updateProductStatus(@ModelAttribute ProductListContainer productListContainer, Model model) {
        return "views/searchProductBySeller";
    }

    @GetMapping("/addProduct")
    public String addProduct(Model model, Principal principal, HttpSession session) {
        String email = principal.getName();
        session.setAttribute("email", email);
        Product product = new Product();
        product.setVendor_id(email);
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
