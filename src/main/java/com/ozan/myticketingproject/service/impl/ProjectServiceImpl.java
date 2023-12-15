package com.ozan.myticketingproject.service.impl;

import com.ozan.myticketingproject.dto.ProjectDTO;
import com.ozan.myticketingproject.dto.TaskDTO;
import com.ozan.myticketingproject.dto.UserDTO;
import com.ozan.myticketingproject.enums.Status;
import com.ozan.myticketingproject.service.ProjectService;
import com.ozan.myticketingproject.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl extends AbstractMapService<ProjectDTO,String> implements ProjectService {
    // you need to use unique var which is project code
    private final TaskService taskService;

    public ProjectServiceImpl(TaskService taskService) {
        this.taskService = taskService;
    }


    @Override
    public ProjectDTO save(ProjectDTO object) {
        if (object.getProjectStatus()==null){
            object.setProjectStatus(Status.OPEN);
        }
        return super.save(object.getProjectCode(), object);
    }

    @Override
    public List<ProjectDTO> findAll() {
        return super.findAll();
    }

    @Override
    public void update(ProjectDTO object) {
        if (object.getProjectStatus()==null)
            object.setProjectStatus(findById(object.getProjectCode()).getProjectStatus());
        super.update(object.getProjectCode(),object);

    }

    @Override
    public void deleteById(String id) {
        super.deleteById(id);
    }
    @Override
    public ProjectDTO findById(String id) {
        return super.findById(id);
    }

    @Override
    public void complete(ProjectDTO project) {
        project.setProjectStatus(Status.COMPLETE);
        //you changed the status complete and you need to save it with below:
        super.save(project.getProjectCode(),project);

    }
    @Override
    public List<ProjectDTO> findAllNonCompletedProjects() {
        return findAll().stream().filter(project -> !project.getProjectStatus().equals(Status.COMPLETE)).collect(Collectors.toList());
    }

    @Override
    public List<ProjectDTO> getCountedListOfProjectDTO(UserDTO manager) {

        //my goal is build that ProjectDTO with AllArg Constructor.

//I need to get all projects belongs to this manager
        List<ProjectDTO> projectList =
                findAll()
                        .stream()
                        .filter(project -> project.getAssignedManager().equals(manager))
                        .map( project -> {  //explain why we used map. We need to handle one by one. { for multiple lines

                            List<TaskDTO> taskList = taskService.findTaskByManager(manager);

                            int completeTaskCounts = (int)taskList.stream().filter(t ->  t.getProject().equals(project) && t.getTaskStatus() == Status.COMPLETE).count();

                            int unfinishedTaskCounts = (int)taskList.stream().filter(t ->  t.getProject().equals(project) && t.getTaskStatus() != Status.COMPLETE).count();

                            project.setCompleteTaskCounts(completeTaskCounts);
                            project.setUnfinishedTaskCounts(unfinishedTaskCounts);

                            return project;

                        }).collect(Collectors.toList());


        return projectList;
    }



}
