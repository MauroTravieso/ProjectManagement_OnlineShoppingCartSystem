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
import org.system.role.service.RoleService;
import org.system.role.model.Role;

import javax.validation.Valid;
import java.util.List;

@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

//    @GetMapping("/register")
//    public String registerForm(Model model) {
//
//        model.addAttribute("user", new User());
//        return "views/registerForm";
//
//    }

    @GetMapping(value = "/register")
    public String registration(@ModelAttribute("user") User user) {
        return "views/registerForm";
    }

    @ModelAttribute("roleList")
    public List<Role> getRoles(Model model) {
        return roleService.findAll();
    }

    @PostMapping("/register")
    public String registerUser(@Valid User user, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {

            return "views/registerForm";

        }
        System.out.println(user.getRoles().toString());


        if (userService.isUserPresent(user.getEmail())){

            model.addAttribute("exist", true);
            System.out.println("0");
            return "views/registerForm";
        }

        String role = user.getRoles().get(0).toString();
        System.out.println(role);

        System.out.println("1");

        userService.createUser(user);
        System.out.println("2");

        return "views/success";

    }

}
