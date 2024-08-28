package com.project.taksCrud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.taksCrud.entities.Task;

public interface taksRepository extends JpaRepository<Task, Long> {
    
}
