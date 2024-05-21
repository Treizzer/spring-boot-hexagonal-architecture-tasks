package com.hex_arch.tasks.infrastructure.entities;

import java.time.LocalDateTime;

import com.hex_arch.tasks.domain.models.Task;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private LocalDateTime creationDate;

    @Getter(AccessLevel.NONE)
    private Boolean completed;

    public Boolean isCompleted() {
        return completed;
    }

    public static TaskEntity fromDomainModel(Task task) {
        return new TaskEntity(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getCreationDate(),
                task.isCompleted());
    }

    public Task toDomainModel() {
        return new Task(id, title, description, creationDate, completed);
    }

}
