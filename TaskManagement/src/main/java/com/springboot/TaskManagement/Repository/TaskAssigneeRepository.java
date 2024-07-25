package com.springboot.TaskManagement.Repository;

import com.springboot.TaskManagement.Entity.TaskAssignee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskAssigneeRepository extends JpaRepository<TaskAssignee, Long> {
}
