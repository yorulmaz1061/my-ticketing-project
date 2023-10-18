package com.ozan.myticketingproject.controller;
import com.ozan.myticketingproject.dto.ProjectDTO;
import com.ozan.myticketingproject.service.ProjectService;
import com.ozan.myticketingproject.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/project")
public class ProjectController {
    ProjectService projectService;
    UserService userService;

    public ProjectController(ProjectService projectService, UserService userService) {
        this.projectService = projectService;
        this.userService = userService;
    }

    @GetMapping("/create")
    public String createProject(Model model){
         model.addAttribute("project", new ProjectDTO());
         //Why I passed above, Because I want to get an empty project form
         model.addAttribute("projects", projectService.findAll());
         //for passing projectService we need to create projectService object and constructor.
        model.addAttribute("managers", userService.findAll());

        return "/project/create";
    }

}
