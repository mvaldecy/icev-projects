package com.project.tasks.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.tasks.entities.Tasks;

public interface TaskRepository extends JpaRepository<Tasks, Long> {
    
}
