package com.cydeo.controller;


import com.cydeo.Service.ProjectService;
import com.cydeo.Service.UserService;
import com.cydeo.dto.ProjectDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/project")
public class ProjectController {
private final ProjectService projectService;
private final UserService userservice;

    public ProjectController(ProjectService projectService, UserService userservice) {
        this.projectService = projectService;
        this.userservice = userservice;
    }

    @GetMapping("/create")
    public String projectCreate(ProjectDTO project,Model model){

        model.addAttribute("project",new ProjectDTO());
        model.addAttribute("managers",userservice.findManagers());
        model.addAttribute("projects",projectService.findAll());
        return "/project/create";
    }
}
