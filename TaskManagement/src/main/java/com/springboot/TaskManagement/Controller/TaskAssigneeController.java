package com.springboot.TaskManagement.Controller;

import com.springboot.TaskManagement.Entity.TaskAssignee;
import com.springboot.TaskManagement.Service.TaskAssigneeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assignee")
public class TaskAssigneeController {
    @Autowired
    private TaskAssigneeService assigneeService;
    @GetMapping
    public List<TaskAssignee> getAllAssignee(){
        return assigneeService.getAllAssignee();
    }
    @GetMapping("/{id}")
    public ResponseEntity<TaskAssignee> getAssigneeById(@PathVariable Long id){
        TaskAssignee assignee = assigneeService.getAssigneeById(id).orElseThrow(()->new RuntimeException());
        return ResponseEntity.ok(assignee);
    }
    @PostMapping
    public TaskAssignee addAssignee(@RequestBody TaskAssignee assignee) {
        return assigneeService.addAssignee(assignee);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskAssignee> updateAssignee(@PathVariable Long id, @RequestBody TaskAssignee assigneeDetails) {
        TaskAssignee updatedAssignee = assigneeService.updateAssignee(id, assigneeDetails);
        return ResponseEntity.ok(updatedAssignee);
    }

    @DeleteMapping("/{id}")
    public void deleteAssignee(@PathVariable Long id) {
        assigneeService.deleteAssignee(id);
    }
}
