package org.system.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.system.admin.model.User;
import org.system.permission.service.PermissionService;
import org.system.task.service.TaskService;
import org.system.admin.service.UserService;

import javax.servlet.http.HttpSession;
import java.security.Principal;

@Controller
public class ProfileController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private UserService userService;

    @Autowired
    private PermissionService permissionService;

    @GetMapping("/profile")
    public String showProfilePage(Model model, Principal principal, HttpSession session) {

        String email = principal.getName();
        User user = userService.findOne(email);
        session.setAttribute("email",email);
        // Using the model to pass the List<Task> to the view
        model.addAttribute("name", user.getName());
        model.addAttribute("tasks", taskService.findUserTask(user));
       // model.addAttribute("permissions", permissionService.findUserPermission(user));
        model.addAttribute("permissions", permissionService.findUser());

        return "views/profile";

    }

}
