package com.springboot.TaskManagement.Controller;

import com.springboot.TaskManagement.Entity.Task;
import com.springboot.TaskManagement.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;
    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskService.addTask(task);
    }
    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
        Task task = taskService.getTaskById(id).orElseThrow(() -> new RuntimeException("Task not found!"));
        return ResponseEntity.ok(task);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task taskDetails) {
        Task updatedTask = taskService.updateTask(taskDetails, id);
        return ResponseEntity.ok(updatedTask);
    }
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }
    @PutMapping("/{taskId}/assign/{assigneeId}")
    public ResponseEntity<Task> assignTask(@PathVariable Long taskId, @PathVariable Long assigneeId) {
        Task updatedTask = taskService.assignTask(taskId, assigneeId);
        return ResponseEntity.ok(updatedTask);
    }
}
