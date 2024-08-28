package com.project.tasks.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.tasks.dto.TaskCreationDto;
import com.project.tasks.entities.Tasks;
import com.project.tasks.repositories.TaskRepository;

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
}
