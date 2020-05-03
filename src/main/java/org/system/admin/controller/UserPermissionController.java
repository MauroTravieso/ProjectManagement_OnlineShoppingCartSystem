package org.system.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.system.admin.model.User;
import org.system.admin.model.UserStatus;
import org.system.admin.service.UserService;
import org.system.email.EmailService;
import org.system.permission.model.Permission;
import org.system.permission.service.PermissionService;

import java.security.Permissions;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//

//

@Controller
public class UserPermissionController {

    @Autowired
    private UserService userService;

    @Autowired
    private PermissionService permissionService;

    //private User userApproved = null;

//    @Autowired
//    EmailService emailService;

    @GetMapping("/approvePermission")
    public String approveUserPermission(String email, Model model) {
        System.out.println("*****************************");
        User user = userService.findOne(email);
        model.addAttribute("user", user);
        return "views/approveUserPermission";
    }

    //**//
    @ModelAttribute("permissionList")
    public List<Permission> getPermissions(String email, Model model) {
//        System.out.println("***************************" + email);
//        List<Permission> permissionList = permissionService.findUser();
//        model.addAttribute("permissionList", permissionList);
        return permissionService.findUser();
    }

    @PostMapping("/approvePermission")
    public String approvedUserPermission(String email, Model model) {
        System.out.println("*****************************");
        User user = userService.findOne(email);
        user.setStatus(UserStatus.ACTIVE);
        user.setStatusChangedDate(LocalDate.now());

        Permission userPermission0 = new Permission("ACCESS_REPORT");
        Permission userPermission1 = new Permission("UPLOAD_PRODUCT");
        Permission userPermission2 = new Permission("UPDATE_PRODUCT");
        List<Permission> permissions = new ArrayList<>();
        permissions.add(userPermission0);
        permissions.add(userPermission1);
        permissions.add(userPermission2);
        user.setPermissions(permissions);

        //userService.approveUser(user.getEmail());
        userService.save(user);
        //emailService.sendPendingAcceptanceEmail(user);

        //userApproved=user;
        return "views/list";
        //return "redirect:/sendMail";
    }

    @GetMapping("/rejectPermission")
    public String rejectUser(String email, Model model) {
        System.out.println("*****************************");
        User user = userService.findOne(email);
        model.addAttribute("user", user);
        return "views/rejectUserPermission";
    }

    @PostMapping("/rejectPermission")
    public String rejectedUser(String email, Model model) {
        System.out.println("*****************************");
        User user = userService.findOne(email);
        //user.setStatus(UserStatus.REJECTED);
        user.setStatusChangedDate(LocalDate.now());
        //userService.approveUser(user.getEmail());

        Permission userPermission0 = new Permission("NO_ACCESS_REPORT");
        Permission userPermission1 = new Permission("NO_UPLOAD_PRODUCT");
        Permission userPermission2 = new Permission("NO_UPDATE_PRODUCT");
        List<Permission> permissions = new ArrayList<>();
        permissions.add(userPermission0);
        permissions.add(userPermission1);
        permissions.add(userPermission2);
        user.setPermissions(permissions);

        userService.save(user);
        return "views/list";
    }





}
