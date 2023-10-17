package com.ozan.myticketingproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @RequestMapping(value = {"/login","/"})
    //it means that, localhost:8080/ or localhost:8080/login is going to navigate
    //the same page
    public String login(){

        return "login";
    }

    @RequestMapping("/welcome")
    public String welcome(){
        return "welcome";
    }

}