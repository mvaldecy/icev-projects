package com.project.tasks.services.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class TaskNotFound extends NotFoundException{
    public TaskNotFound() {
        super("Task não encontrada");
    }
}
