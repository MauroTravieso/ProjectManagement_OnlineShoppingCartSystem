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

//    @Autowired
//    private PermissionService permissionService;

//    @GetMapping("/register")
//    public String registerForm(Model model) {
//
//        model.addAttribute("user", new User());
//        return "views/registerForm";
//
//    }

//    @GetMapping(value = "/register")
//    public String registration(@ModelAttribute("user") User user) {
//        return "views/registerForm";
//    }

    @GetMapping(value = "/register")
    public String registration(@ModelAttribute("user") User user, Model model) {
//        System.out.println("RegisterController ******ExceptADMIN*********");
//        model.addAttribute("exceptADMIN","ADMIN");
        return "views/registerForm";
    }

    @ModelAttribute("roleList")
    public List<Role> getRoles(Model model) {

        //return roleService.findAll();
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

//        String role = user.getRoles().get(0).toString();
//        System.out.println(role);
//
//        System.out.println("1");

//        System.out.println("RegisterController ******ExceptADMIN*********");
//        model.addAttribute("exceptADMIN","ADMIN");

        if (!user.getPassword().equals(user.getRetypePassword())) {
            //model.addAttribute("retypePassword","The passwords don't match!!!");
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
