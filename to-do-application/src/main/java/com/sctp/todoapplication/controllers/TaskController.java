package com.sctp.todoapplication.controllers;

import com.sctp.todoapplication.exception.EmptyTaskListException;
import com.sctp.todoapplication.exception.ResourceNotFoundException;
import com.sctp.todoapplication.models.Task;
import com.sctp.todoapplication.services.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.HandlerMethodValidationException;

import java.util.List;

@Controller
@RequestMapping("/api/v1/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/")
    public ResponseEntity<List<Task>> getAllTasks(@RequestParam(required = false) String task) throws EmptyTaskListException{
        List<Task> allTasks = taskService.getAllTask();
        if(allTasks.isEmpty()){
            throw new EmptyTaskListException("Task list is empty. Please add in new tasks.");
        } return ResponseEntity.ok(allTasks);
    }

    @GetMapping("/completed")
    public ResponseEntity<List<Task>> getAllCompletedTasks() throws EmptyTaskListException{
        List<Task> allCompletedTasks = taskService.findAllCompletedTask();
        if (allCompletedTasks.isEmpty()){
            throw new EmptyTaskListException("No complete task is available.");
        } return ResponseEntity.ok(allCompletedTasks);
    }

    @GetMapping("/incomplete")
    public ResponseEntity<List<Task>> getAllIncompleteTasks() throws EmptyTaskListException{
        List<Task> allIncompleteTasks = taskService.findAllIncompleteTask();
        if (allIncompleteTasks.isEmpty()){
            throw new EmptyTaskListException("No incomplete task is found.");
        } return ResponseEntity.ok(allIncompleteTasks);
    }

    @PostMapping("/")
    public ResponseEntity<Task> createTask(@Valid @RequestBody Task task){
        return ResponseEntity.ok(taskService.createNewTask(task));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @Valid @RequestBody Task task){
        Task existingTask = taskService.findTaskById(id);
        if (existingTask == null){
            return ResponseEntity.notFound().build();
        }

        existingTask.setTask(task.getTask());
        existingTask.setCompleted(task.isCompleted());

        try{
            existingTask = taskService.updateTask(existingTask);
            return ResponseEntity.ok(existingTask);
        } catch (HandlerMethodValidationException e){
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteTask(@Valid @PathVariable Long id){
        Task deletedTask = taskService.findTaskById(id);
        if(deletedTask == null){
            return ResponseEntity.notFound().build();
        }
        taskService.deleteTask(id);
        return ResponseEntity.ok(true);
    }
}
