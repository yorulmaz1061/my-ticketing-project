package com.ozan.myticketingproject.service;

import com.ozan.myticketingproject.dto.TaskDTO;
import com.ozan.myticketingproject.dto.UserDTO;
import com.ozan.myticketingproject.enums.Status;

import java.util.List;

public interface TaskService extends CrudService<TaskDTO, Long> {
    List<TaskDTO> findTaskByManager(UserDTO manager);
    List<TaskDTO> findAllTaskByStatus(Status status);
    List<TaskDTO> findAllTaskByStatusIsNot(Status status);
    void updateStatus(TaskDTO task);

}
