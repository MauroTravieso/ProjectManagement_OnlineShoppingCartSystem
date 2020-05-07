package org.system.search.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.system.admin.model.User;
import org.system.admin.service.UserService;
import org.system.product.model.Product;
import org.system.role.model.Role;
import org.system.search.service.SearchService;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;
/**
 * SearchService
 *
 * Bugs: none known
 *
 * @author       Dinh Nguyen (986520) - Team II APR2020
 * @version      1.0
 *
 */

@Controller
public class SearchController {
    @Autowired
    private SearchService searchService;

    @Autowired
    private UserService userService;

    @RequestMapping("/searchByClient")
    public String SearchByClient(Model model, @RequestParam("searchString") String keyword, @RequestParam(defaultValue = "0") Integer pageNo,
                                 @RequestParam(defaultValue = "10") Integer pageSize,
                                 @RequestParam(defaultValue = "id") String sortBy) {

        if (keyword != null) {
            model.addAttribute("searchResult", searchService.searchProductByEndUser(keyword, pageNo, pageSize, sortBy));

        }

        return "";

    }

    @RequestMapping("/searchByVendor")
    public String SearchProductByVendor(Model model, @RequestParam("searchString") String keyword, Principal principal, @RequestParam(defaultValue = "0") Integer pageNo,
                                 @RequestParam(defaultValue = "10") Integer pageSize,
                                 @RequestParam(defaultValue = "id") String sortBy) {

        if (keyword != null) {
            String email = principal.getName();
            model.addAttribute("searchResult", searchService.searchProductByVendor(keyword,email, pageNo, pageSize, sortBy));
        }
        return "";

    }
}
