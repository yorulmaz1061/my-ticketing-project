package com.ozan.myticketingproject.controller;
import com.ozan.myticketingproject.dto.ProjectDTO;
import com.ozan.myticketingproject.dto.UserDTO;
import com.ozan.myticketingproject.service.ProjectService;
import com.ozan.myticketingproject.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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
    @GetMapping("/delete/{projectcode}")
    //end point for unique identifier
    public String deleteProject(@PathVariable("projectcode") String projectcode){
        projectService.deleteById(projectcode);
        return "redirect:/project/create";
    }
    @GetMapping("/complete/{projectcode}")
    public String completeProject(@PathVariable("projectcode") String projectcode){
        //this is not crud operator. This is different business logic.
        projectService.complete(projectService.findById(projectcode));
        return "redirect:/project/create";
    }

    @GetMapping("/update/{projectcode}")
    public String editProject(@PathVariable("projectcode") String projectcode, Model model){

        model.addAttribute("project", projectService.findById(projectcode));
        model.addAttribute("projects", projectService.findAll());
        model.addAttribute("managers", userService.findManagers());

        //It should return new view but the same view element so copy
        //create.html and paste it to update.html
        return"/project/update";
    }

    @PostMapping("/update")
    //We don't need to use @PathVariable
    public String updateProject(ProjectDTO project){
        projectService.update(project);
        return"redirect:/project/create";
    }
    @GetMapping("/manager/project-status")
    public String getProjectByManager(Model model){
        UserDTO manager=userService.findById("john@cydeo.com");

        List<ProjectDTO> projects = projectService.getCountedListOfProjectDTO(manager);

        model.addAttribute("projects", projects);

        return "/manager/project-status";

    }




}
