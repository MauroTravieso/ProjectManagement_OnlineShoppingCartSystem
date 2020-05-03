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

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    //private User userApproved = null;

//    @Autowired
//    EmailService emailService;

    @Autowired
    RoleService roleService;

    @GetMapping("/users")
    public String listUsers(Model model, @RequestParam(defaultValue = "") String name) {

        //model.addAttribute("users", userService.findAll());
        model.addAttribute("users", userService.findByName(name));
        return "views/list";
    }

//    @GetMapping("/usersRole")
//    public String listRoles(Model model, @RequestParam(defaultValue = "") String name) {
//        model.addAttribute("users", roleService.findByRole(name));
//        return "views/list";
//    }

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
        //userService.approveUser(user.getEmail());
        //userService.save(user);



        userService.save(user);
        //emailService.sendPendingAcceptanceEmail(user);

        //userApproved=user;
        return "views/list";
        //return "redirect:/sendMail";
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
        //userService.approveUser(user.getEmail());
        userService.save(user);
        return "views/list";
    }

    //    @GetMapping("/addTask")
//    public String taskForm(String email, Model model, HttpSession session) {
//
//        session.setAttribute("email", email);
//        model.addAttribute("task", new Task());
//        return "views/taskForm";
//
//    }

//    @GetMapping(value="/sendMail")
//    public String home() {
//        try {
//            sendEmail();
//            userApproved=null;
//            return "sendEMail";
//        } catch (Exception ex) {
//            return "Error in sending email: " + ex;
//        }
//    }
//
//    private void sendEmail() throws Exception {
//        String host = "smtp.gmail.com";
//        String from = "team2.shoppingcart@gmail.com";
//        String pass = "team2.shopping";
//        Properties props = System.getProperties();
//        props.put("mail.smtp.starttls.enable", "true");
//        props.put("mail.smtp.host", host);
//        props.put("mail.smtp.user", from);
//        props.put("mail.smtp.password", pass);
//        props.put("mail.smtp.port", "587");
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.debug", "true");
//        Session session = Session.getInstance(props, new GMailAuthenticator(from, pass));
//
//        MimeMessage message = new MimeMessage(session);
//        InternetAddress fromAddress = new InternetAddress(from);
//
//        InternetAddress toAddress = new InternetAddress(from);
//        if(userApproved!=null)
//            toAddress = new InternetAddress(userApproved.getEmail());
//
//        message.setFrom(fromAddress);
//        message.setRecipient(Message.RecipientType.TO, toAddress);
//
//        message.setSubject("Approval");
//        message.setText("Welcome to Team II - OnlineShoppingCartSystem! \n Your are approved!");
//        Transport transport = session.getTransport("smtp");
//        transport.connect(host, from, pass);
//        message.saveChanges();
//        Transport.send(message);
//        transport.close();
//
//    }

}
