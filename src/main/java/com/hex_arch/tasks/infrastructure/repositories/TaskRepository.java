package com.hex_arch.tasks.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hex_arch.tasks.infrastructure.entities.TaskEntity;

public interface TaskRepository extends JpaRepository<TaskEntity, Long> {
}
