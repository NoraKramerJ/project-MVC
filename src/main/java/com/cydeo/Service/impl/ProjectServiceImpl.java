package com.cydeo.Service.impl;

import com.cydeo.Service.ProjectService;
import com.cydeo.dto.ProjectDTO;
import com.cydeo.dto.UserDTO;
import com.cydeo.enums.Status;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl extends AbstractMapService<ProjectDTO, String> implements ProjectService {


    @Override
    public ProjectDTO save(ProjectDTO project) {

        return super.save(project.getProjectCode(), project);
    }


    @Override
    public ProjectDTO findById(String projectCode) {
        return super.findById(projectCode);
    }

    @Override
    public List<ProjectDTO> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(String projectCode) {
        super.deleteById(projectCode);
    }


    @Override
    public void update(ProjectDTO object) {
super.update(object.getProjectCode(), object);
    }

    @Override
    public void complete(ProjectDTO project) {
        project.setProjectStatus(Status.COMPLETE);
    }

    @Override
    public List<ProjectDTO> getCountedListOfProjectDTO(UserDTO manager) {
        List<ProjectDTO> projectList =
                findAll()
                        .stream()
                        .filter(project -> project.getAssignedManager().equals(manager))  //John
                        .map(project ->{


                            List<TaskDTO> taskList = taskService.findTasksByManager(manager);

                            int completeTaskCounts = (int) taskList.stream().filter(t -> t.getProject().equals(project) && t.getTaskStatus() == Status.COMPLETE).count();
                            int unfinishedTaskCounts = (int) taskList.stream().filter(t -> t.getProject().equals(project) && t.getTaskStatus() != Status.COMPLETE).count();

                            project.setCompleteTaskCounts(completeTaskCounts);
                            project.setUnfinishedTaskCounts(unfinishedTaskCounts);


                            return project;

                        })


                        .collect(Collectors.toList());
        return projectList;
    }
}
