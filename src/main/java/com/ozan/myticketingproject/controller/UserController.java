package com.ozan.myticketingproject.controller;

import com.ozan.myticketingproject.dto.UserDTO;
import com.ozan.myticketingproject.service.RoleService;
import com.ozan.myticketingproject.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    RoleService roleService;
    UserService userService;

    public UserController(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @GetMapping("/create")
    public String createUser(Model model){
        model.addAttribute("user", new UserDTO());
        //UserDTO will communicate, go to end-point html(create.html)
        model.addAttribute("roles", roleService.findAll());
        //RoleDTO role1=new RoleDTO....you cannot do this in the controller
        // also this data will come from dB. We have no dB but we will hook it to
        //data generator. Now it is time to talk about service again.
        //bring me all roles from dB. This is our business logic.
        model.addAttribute("users", userService.findAll());

        return "/user/create";
    }
    @PostMapping("/create")
    public String insertUser(@ModelAttribute("user")UserDTO user, Model model){
        //Since "user" attribute is holding values, I should use it to pass.
        //This is the necessity for @ModelAttribute
        //model.addAttribute("user", new UserDTO());
       // model.addAttribute("roles", roleService.findAll());
        //Below is for saving your form:
        userService.save(user);
       // model.addAttribute("users", userService.findAll());
        //Same page should be displayed. return the same html.
        // but with empty form. It must be returned with empty object.
        // That's why we need code above.


        return "redirect:/user/create";
    }

}
