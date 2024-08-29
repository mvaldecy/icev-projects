package com.project.tasks.services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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

    public Tasks editTasksById(Long id, TaskCreationDto body) {
        Tasks task = this.getById(id);
        if (body.title() != null) {
            task.setTitle(body.title());
        }
        if (body.description() != null) {
            task.setDescription(body.description());
        }
        return this.taskRepository.save(task);
    }

    public void saveCsv(MultipartFile file) throws IOException {

        try(BufferedReader reader = new BufferedReader(
            new InputStreamReader(file.getInputStream(), StandardCharsets.UTF_8));
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader())) {
                for (CSVRecord record :csvParser) {
                    Tasks task = new Tasks();
                    task.setTitle(record.get("title"));
                    task.setDescription(record.get("description"));
                    //task.setCompletedAt(LocalDateTime.parse(record.get("completed_at")));
                    task.setCreatedAt(LocalDateTime.parse(record.get("created_at")));
                    task.setUpdatedAt(LocalDateTime.parse(record.get("updated_at")));
                    this.taskRepository.save(task);
                }
            }
    }
}
