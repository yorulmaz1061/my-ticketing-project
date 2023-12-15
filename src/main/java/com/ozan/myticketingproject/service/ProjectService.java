package com.ozan.myticketingproject.service;

import com.ozan.myticketingproject.dto.ProjectDTO;
import com.ozan.myticketingproject.dto.UserDTO;

import java.util.List;

public interface ProjectService extends CrudService<ProjectDTO, String > {
    //Unique thing is project code which is String
    void complete(ProjectDTO project);

    List<ProjectDTO> findAllNonCompletedProjects();

    List<ProjectDTO> getCountedListOfProjectDTO(UserDTO manager);


}
