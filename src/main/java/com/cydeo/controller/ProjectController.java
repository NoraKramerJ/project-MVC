package com.cydeo.controller;


import com.cydeo.Service.ProjectService;
import com.cydeo.Service.UserService;
import com.cydeo.dto.ProjectDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/create")

    public String insertProject( @ModelAttribute("project") ProjectDTO project){
        projectService.save(project);
        return "redirect:/project/create";
    }

    @GetMapping("/update/{projectCode}")
    public String editProject(@PathVariable ("projectCode") String projectCode,Model model){
        model.addAttribute("project",projectService.findById(projectCode));
        model.addAttribute("managers",userservice.findManagers());
        model.addAttribute("projects",projectService.findAll());
        return "/project/update";
    }

    @GetMapping("/delete/{projectCode}")

    public String deleteProject(@PathVariable("projectCode") String projectCode){

        projectService.deleteById(projectCode);

        return "redirect:/project/create";
    }
    @GetMapping("/complete/{projectCode}")

    public String completeProject(@PathVariable("projectCode") String projectCode){

       projectService.complete(projectService.findById(projectCode));

        return "redirect:/project/create";
    }
    @PostMapping("/update")
    public String updateProject(ProjectDTO project){
        projectService.update(project);
        return "redirect:/project/create";
    }
}
