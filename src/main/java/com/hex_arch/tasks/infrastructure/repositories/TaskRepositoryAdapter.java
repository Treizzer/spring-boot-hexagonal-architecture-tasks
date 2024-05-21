package com.hex_arch.tasks.infrastructure.repositories;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.hex_arch.tasks.domain.models.Task;
import com.hex_arch.tasks.domain.ports.out.TaskRepositoryPort;
import com.hex_arch.tasks.infrastructure.entities.TaskEntity;

public class TaskRepositoryAdapter implements TaskRepositoryPort {

    private final TaskRepository repository;

    public TaskRepositoryAdapter(TaskRepository repository) {
        this.repository = repository;
    }

    @Override
    public Task save(Task task) {
        TaskEntity taskEntity = TaskEntity.fromDomainModel(task);
        TaskEntity savedTask = repository.save(taskEntity);

        return savedTask.toDomainModel();
    }

    @Override
    public Optional<Task> findById(Long id) {
        return repository.findById(id).map(TaskEntity::toDomainModel);
    }

    @Override
    public List<Task> findAll() {
        return repository.findAll().stream()
                .map(TaskEntity::toDomainModel)
                .collect(Collectors.toList());
        // return repository.findAll().stream().map(TaskEntity::toDomainModel).toList();
    }

    @Override
    public Optional<Task> update(Task task) {
        if (repository.existsById(task.getId())) {
            TaskEntity taskEntity = TaskEntity.fromDomainModel(task);
            TaskEntity savedTask = repository.save(taskEntity);

            return Optional.of(savedTask.toDomainModel());
        }

        return Optional.empty();
    }

    @Override
    public Boolean deleteById(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }

        return false;
    }

}
