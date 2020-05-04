package org.system.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.system.admin.model.User;
import org.system.admin.model.UserStatus;
import org.system.permission.model.Permission;
import org.system.permission.service.PermissionService;
import org.system.role.model.Role;
import org.system.role.service.RoleService;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    RoleService roleService;

    @Autowired
    private PermissionService permissionService;


//    @GetMapping("/")
//    public String showIndexPage() {
//
//        return "index";
//
//    }

//    @ModelAttribute("roleList")
//    public List<Role> getRoles(Model model) {
//        return roleService.findAll();
//    }

    @GetMapping("/login")
    public String showLoginForm() {

        return "views/loginForm";

    }

//    @PostMapping("/login")
//    public String showForm(User user) {
//        System.out.println("************ ******** ********");
//        UserStatus ue = user.getStatus();
//        if (ue!=UserStatus.ACTIVE)
//            return "views/loginForm";
//        return "views/profile";
//
//    }



}
