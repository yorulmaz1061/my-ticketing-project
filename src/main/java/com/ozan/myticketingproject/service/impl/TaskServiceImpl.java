package com.ozan.myticketingproject.service.impl;

import com.ozan.myticketingproject.dto.TaskDTO;
import com.ozan.myticketingproject.dto.UserDTO;
import com.ozan.myticketingproject.enums.Status;
import com.ozan.myticketingproject.service.TaskService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
@Service
public class TaskServiceImpl extends AbstractMapService<TaskDTO,Long> implements TaskService {

    @Override
    public TaskDTO save(TaskDTO object) {

        if (object.getTaskStatus() == null) {
            object.setTaskStatus(Status.OPEN);
        }

        if (object.getAssignedDate() == null) {
            object.setAssignedDate(LocalDate.now());
        }

        if (object.getId() == null) {
            object.setId(UUID.randomUUID().getMostSignificantBits());
        }

        return super.save(object.getId(), object);
    }

    @Override
    public List<TaskDTO> findAll() {
        return super.findAll();
    }

    @Override
    public void update(TaskDTO object) {
        TaskDTO foundTask = findById(object.getId());

        object.setTaskStatus(foundTask.getTaskStatus());
        object.setAssignedDate(foundTask.getAssignedDate());

        super.update(object.getId(), object);

    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);

    }

    @Override
    public TaskDTO findById(Long id) {
        return super.findById(id);
    }

    @Override
    public List<TaskDTO> findTaskByManager(UserDTO manager) {
        return findAll().stream().filter(p->p.getProject().getAssignedManager().equals(manager)).collect(Collectors.toList());
    }

    @Override
    public List<TaskDTO> findAllTaskByStatus(Status status) {
        return findAll().stream().filter(p->p.getTaskStatus().equals(Status.COMPLETE)).collect(Collectors.toList());
    }

    @Override
    public List<TaskDTO> findAllTaskByStatusIsNot(Status status) {
        return findAll().stream().filter(p->!p.getTaskStatus().equals(Status.COMPLETE)).collect(Collectors.toList());
    }

    @Override
    public void updateStatus(TaskDTO task) {
        findById(task.getId()).setTaskStatus(task.getTaskStatus());
        update(task);

    }
}
