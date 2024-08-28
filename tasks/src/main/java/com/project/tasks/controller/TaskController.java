package com.project.tasks.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.config.Task;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.tasks.dto.TaskCreationDto;
import com.project.tasks.entities.Tasks;
import com.project.tasks.services.TaskService;

@RestController
@RequestMapping
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping(value = "/task")
    public ResponseEntity<Tasks> createTask(@RequestBody TaskCreationDto task) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.taskService.createTask(task));
    }

    @GetMapping(value = "/task")
    public ResponseEntity<List<Tasks>> getAllTasks() {
        return ResponseEntity.status(HttpStatus.OK).body(this.taskService.getAllTasks());
    }

    @GetMapping(value = "task/{id}")
    public ResponseEntity<Tasks> getById(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(this.taskService.getById(id));
    }
}
