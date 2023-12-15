package com.ozan.myticketingproject.service.impl;

import com.ozan.myticketingproject.dto.UserDTO;
import com.ozan.myticketingproject.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl extends AbstractMapService<UserDTO,String> implements UserService {

    @Override
    public UserDTO save(UserDTO object) {
        return super.save(object.getUserName(),object);
    }

    @Override
    public List<UserDTO> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(String id) {
        super.deleteById(id);

    }

    @Override
    public void update(UserDTO object) {
        super.update(object.getUserName(),object);
    }

    @Override
    public UserDTO findById(String id) {
        return super.findById(id);
    }

    @Override
    public List<UserDTO> findManagers() {
        //Below 2 is used for managerId unique stuff
        // for filtering manager we use stream structure
        return super.findAll().stream().filter(p->p.getRole().getId()==2)
                .collect(Collectors.toList());
    }

    public List<UserDTO> findEmployees(){
        return super.findAll().stream().filter(p->p.getRole().getId()==3)
                .collect(Collectors.toList());
    }
}
