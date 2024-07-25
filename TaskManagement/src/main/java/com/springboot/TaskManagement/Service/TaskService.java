package com.springboot.TaskManagement.Service;

import com.springboot.TaskManagement.Entity.Task;
import com.springboot.TaskManagement.Entity.TaskAssignee;
import com.springboot.TaskManagement.Repository.TaskAssigneeRepository;
import com.springboot.TaskManagement.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private TaskAssigneeRepository assigneeRepository;
    public Task addTask(Task task) {
        return taskRepository.save(task);
    }
    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
    public Task updateTask(Task taskDetails, Long id){
        Task task = taskRepository.findById(id).orElseThrow(()-> new RuntimeException("Task not found!"));
        task.setTaskName(taskDetails.getTaskName());
        task.setAssignee(taskDetails.getAssignee());
        task.setDescription(taskDetails.getDescription());
        return taskRepository.save(task);
    }

    public Task assignTask(Long taskId, Long userId){
        Task task = taskRepository.findById(taskId).orElseThrow(()->new RuntimeException("Task not found!"));
        TaskAssignee assignee = assigneeRepository.findById(userId).
                                orElseThrow(()->new RuntimeException("Task Assignee not exits"));
        task.setAssignee(assignee);
        return taskRepository.save(task);

    }

}
