package com.springboot.TaskManagement.Service;

import com.springboot.TaskManagement.Entity.TaskAssignee;
import com.springboot.TaskManagement.Repository.TaskAssigneeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskAssigneeService {
    private TaskAssigneeRepository assigneeRepository;
    public TaskAssigneeService(TaskAssigneeRepository assigneeRepository) {
        this.assigneeRepository = assigneeRepository;
    }

    public List<TaskAssignee> getAllAssignee(){
        return assigneeRepository.findAll();
    }
    public TaskAssignee addAssignee(TaskAssignee user){
        return assigneeRepository.save(user);
    }
    public Optional<TaskAssignee> getAssigneeById(Long id){
        return assigneeRepository.findById(id);
    }
    public void deleteAssignee(Long id){
        assigneeRepository.deleteById(id);
    }

    public TaskAssignee updateAssignee(Long id, TaskAssignee newAssignee){
        TaskAssignee assignee = assigneeRepository.findById(id).orElseThrow(() -> new RuntimeException("Assignee Not Found"));
        assignee.setName(newAssignee.getName());
        assignee.setEmail(assignee.getEmail());
        return assigneeRepository.save(assignee);
    }
}
