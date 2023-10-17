package com.ozan.myticketingproject.service.impl;

import com.ozan.myticketingproject.dto.RoleDTO;
import com.ozan.myticketingproject.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImpl extends AbstractMapService<RoleDTO,Long> implements RoleService {

    @Override
    public RoleDTO save(RoleDTO object) {
        return super.save(object.getId(), object);
        //How I can call a parent method from the child class?? super keyword!!

    }

    @Override
    public List<RoleDTO> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);

    }

    @Override
    public RoleDTO findById(Long id) {
        return super.findById(id);
    }
    //if interfaces extends another interface you don't have to implement those methods in the interface,
    // but first concrete class must implement

}
