package com.ozan.myticketingproject.controller;

import com.ozan.myticketingproject.service.RoleService;
import com.ozan.myticketingproject.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/task")
public class TaskController {
    RoleService roleService;
    UserService userService;

    public TaskController(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }
    @GetMapping("/create")
    public String createTask(Model model){

        return "task/create";
    }

}

