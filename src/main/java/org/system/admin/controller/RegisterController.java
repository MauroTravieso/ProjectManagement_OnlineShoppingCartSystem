package org.system.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.system.admin.model.User;
import org.system.admin.service.UserService;
import org.system.permission.model.Permission;
import org.system.permission.service.PermissionService;
import org.system.role.service.RoleService;
import org.system.role.model.Role;

import javax.validation.Valid;
import java.util.List;

/**
 * Application Register Controller.
 *
 * Bugs: none known
 *
 * @author       Team II APR2020 - Mauro Travieso (986965)
 * @version      1.0
 *
 */

@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @GetMapping(value = "/register")
    public String registration(@ModelAttribute("user") User user, Model model) {
        return "views/registerForm";
    }

    @ModelAttribute("roleList")
    public List<Role> getRoles(Model model) {

        return roleService.findUser();
    }

    @PostMapping("/register")
    public String registerUser(@Valid User user, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {

            return "views/registerForm";

        }

        if (userService.isUserPresent(user.getEmail())){
            model.addAttribute("exist", true);
            return "views/registerForm";
        }


        if (!user.getPassword().equals(user.getRetypePassword())) {
            System.out.println("**********************");
            bindingResult.rejectValue("retypePassword", "Retype.password",
                    "The passwords don't match!!!");


            return "views/registerForm";
        }

        userService.createUser(user);
        System.out.println("2");

        return "views/success";

    }

}
