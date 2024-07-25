package com.springboot.TaskManagement.Entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskId;
    private String TaskName;
    private String Description;

    @ManyToOne
    private TaskAssignee assignee;
}
