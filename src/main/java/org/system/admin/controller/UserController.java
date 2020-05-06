package org.system.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.system.admin.model.User;
import org.system.admin.model.UserStatus;
import org.system.admin.service.UserService;
import org.system.email.EmailService;
//import org.system.email.GMailAuthenticator;
import org.system.payment.model.Order;
import org.system.payment.service.OrderService;
import org.system.permission.model.Permission;
import org.system.role.service.RoleService;
import org.system.task.model.Task;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.Properties;

//
import java.io.*;
//import javax.mail.*;
//import javax.mail.internet.*;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.HashMap;
import java.util.Map;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.web.bind.annotation.RequestMapping;
//import freemarker.template.Configuration;
////


/**
 * Application User Controller.
 *
 * Bugs: none known
 *
 * @author       Team II APR2020 - Mauro Travieso (986965)
 * @version      1.0
 *
 */

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    OrderService orderService;

    @Autowired
    RoleService roleService;

    @GetMapping("/users")
    public String listUsers(Model model, @RequestParam(defaultValue = "") String name) {

        model.addAttribute("users", userService.findByName(name));
        return "views/list";
    }


    @GetMapping("/approve")
    public String approveUser(String email, Model model) {
        System.out.println("*****************************");
        User user = userService.findOne(email);
        model.addAttribute("user", user);
        return "views/approveUser";
    }

    @PostMapping("/approve")
    public String approvedUser(String email, Model model) {
        System.out.println("*****************************");
        User user = userService.findOne(email);
        user.setStatus(UserStatus.ACTIVE);
        user.setStatusChangedDate(LocalDate.now());

        userService.save(user);
        return "views/list";
    }

    @PostMapping("/update")
    public String updateUser(String email, @ModelAttribute("user") User newUser) {
        System.out.println("*****************************");
        User user = userService.findOne(email);
        user.setStatusChangedDate(LocalDate.now());
        user.setFirstName(newUser.getFirstName());
        user.setLastName(newUser.getLastName());
        user.setPhoneNumber(newUser.getPhoneNumber());

        System.out.println("********************* New LastName ***************" + user.getLastName());
        userService.save(user);
        return "views/updateSuccess";
    }

    @GetMapping("/reject")
    public String rejectUser(String email, Model model) {
        System.out.println("*****************************");
        User user = userService.findOne(email);
        model.addAttribute("user", user);
        return "views/rejectUser";
    }

    @PostMapping("/reject")
    public String rejectedUser(String email, Model model) {
        System.out.println("*****************************");
        User user = userService.findOne(email);
        user.setStatus(UserStatus.REJECTED);
        user.setStatusChangedDate(LocalDate.now());
        userService.save(user);
        return "views/list";
    }


    @GetMapping("/user/orders/{id}")
    public String orderDetails(@PathVariable Long id,Model model){
        model.addAttribute("order",orderService.getOrderById(id));
        return "views/details";
    }

}
