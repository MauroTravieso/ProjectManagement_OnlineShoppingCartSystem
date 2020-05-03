package org.system.enduser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.system.enduser.service.ProductListService;

@Controller
public class ProductListController {
    @Autowired
    private ProductListService productListService;

    @GetMapping("/home")
    public String home(Model model, @RequestParam(defaultValue = "") String title, @RequestParam(defaultValue = "0") int page) {
        if (title.isEmpty()) {
            model.addAttribute("datas", productListService.getProductListByPage(page));
        } else {
            model.addAttribute("datas", productListService.getProductListByKeyWord(title, page));
        }

        return "views/home_product_list";
    }
}