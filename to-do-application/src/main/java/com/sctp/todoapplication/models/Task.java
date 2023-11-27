package com.sctp.todoapplication.models;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Task {
    @Column(name = "id")
    @SequenceGenerator(name="yourSequenceGenerator", allocationSize=1)
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE,
            generator="yourSequenceGenerator")
    private Long id;

    @Column(name = "task", nullable = false)
    @NotBlank(message = "Task name cannot be blank")
    private String task;

    @Column(name = "completed", nullable = false)
    @Valid
    @NotNull
    private Boolean completed;

    public Task(){
    }

    public Task(String task, boolean completed){
        this.task = task;
        this.completed = completed;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getTask(){
        return task;
    }

    public void setTask(String task){
        this.task = task;
    }

    public Boolean isCompleted(){
        return completed;
    }

    public void setCompleted(Boolean completed){
        this.completed = completed;
    }
}
