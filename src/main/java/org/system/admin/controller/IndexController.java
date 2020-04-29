package org.system.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.system.role.model.Role;
import org.system.role.service.RoleService;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    RoleService roleService;

    @GetMapping("/")
    public String showIndexPage() {

        return "index";

    }


    @ModelAttribute("roleList")
    public List<Role> getRoles(Model model) {
        return roleService.findAll();
    }

    @GetMapping("/login")
    public String showLoginForm() {

        return "views/loginForm";

    }



}
