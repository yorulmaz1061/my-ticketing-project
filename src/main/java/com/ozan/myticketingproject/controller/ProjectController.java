package com.ozan.myticketingproject.controller;
import com.ozan.myticketingproject.dto.ProjectDTO;
import com.ozan.myticketingproject.service.ProjectService;
import com.ozan.myticketingproject.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
        //model.addAttribute("managers", userService.findAll()); we created new logic and changed as below
        model.addAttribute("managers", userService.findManagers());

        return "/project/create";
    }
    @PostMapping("/create")
    public String insertProject(ProjectDTO project){
        //attribute. I will redirect to create end point and
        //attributes above methods will be executed again...
        projectService.save(project);

    return "redirect:/project/create";
    //When I click on save button I need to display the same page so, I should return the same endpoint.


    }

}
