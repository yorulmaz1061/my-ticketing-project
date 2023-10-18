package com.ozan.myticketingproject.service.impl;

import com.ozan.myticketingproject.dto.PtojectDTO;
import com.ozan.myticketingproject.service.ProjectService;

import java.util.List;

public class ProjectServiceImpl extends AbstractMapService<PtojectDTO,String> implements ProjectService {
    // you need to use unique var which is project code
    @Override
    public PtojectDTO save(PtojectDTO object) {
        return super.save(object.getProjectCode(), object);
    }

    @Override
    public List<PtojectDTO> findAll() {
        return super.findAll();
    }

    @Override
    public void update(PtojectDTO object) {
        super.update(object.getProjectCode(),object);
    }

    @Override
    public void deleteById(String id) {
        super.deleteById(id);
    }
    @Override
    public PtojectDTO findById(String id) {
        return super.findById(id);
    }
}
