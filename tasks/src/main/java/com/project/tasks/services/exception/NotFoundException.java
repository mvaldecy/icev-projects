package com.project.tasks.services.exception;

public abstract class NotFoundException extends RuntimeException{
    public NotFoundException(String message) {
        super(message);
    }
}
