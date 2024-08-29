package com.project.tasks.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.project.tasks.dto.TaskCreationDto;
import com.project.tasks.entities.Tasks;
import com.project.tasks.repositories.TaskRepository;
import com.project.tasks.services.exception.TaskNotFound;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Tasks createTask(TaskCreationDto task) {
        Tasks newTask = new Tasks(task.title(), task.description());
        Tasks createdTask = this.taskRepository.save(newTask);
        return createdTask;
    }

    public List<Tasks> getAllTasks() {
        return this.taskRepository.findAll();
    }

    public Tasks getById(Long id) {
        Tasks task = this.taskRepository.findById(id).orElseThrow(TaskNotFound::new);
        return task;
    }

    public Tasks completeTasks(Long id) {
        Tasks task = this.getById(id);
        task.setCompletedAt(LocalDateTime.now());
        return this.taskRepository.save(task);
    }

    public void deleteTaskById(Long id) {
        Tasks task = this.getById(id);
        this.taskRepository.deleteById(id);
    }
}
