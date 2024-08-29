package com.project.tasks.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.config.Task;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @PostMapping(value = "/tasks")
    public ResponseEntity<Tasks> createTask(@RequestBody TaskCreationDto task) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.taskService.createTask(task));
    }

    @GetMapping(value = "/tasks")
    public ResponseEntity<List<Tasks>> getAllTasks() {
        return ResponseEntity.status(HttpStatus.OK).body(this.taskService.getAllTasks());
    }

    @GetMapping(value = "tasks/{id}")
    public ResponseEntity<Tasks> getById(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(this.taskService.getById(id));
    }

    @PatchMapping(value = "/tasks/{id}/complete")
    public ResponseEntity<Tasks> completeTask(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(this.taskService.completeTasks(id));
    }

    @DeleteMapping(value = "/tasks/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable("id") Long id) {
        this.taskService.deleteTaskById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Task excluída");
    }
}
