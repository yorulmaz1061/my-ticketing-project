package com.ozan.myticketingproject.service;

import com.ozan.myticketingproject.dto.UserDTO;

import java.util.List;

public interface UserService extends CrudService<UserDTO,String> {
    List<UserDTO> findManagers();
    List<UserDTO> findEmployees();
}
