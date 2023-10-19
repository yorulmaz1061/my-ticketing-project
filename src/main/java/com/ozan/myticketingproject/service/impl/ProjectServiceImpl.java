package com.ozan.myticketingproject.service.impl;

import com.ozan.myticketingproject.dto.ProjectDTO;
import com.ozan.myticketingproject.enums.Status;
import com.ozan.myticketingproject.service.ProjectService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProjectServiceImpl extends AbstractMapService<ProjectDTO,String> implements ProjectService {
    // you need to use unique var which is project code
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
}
