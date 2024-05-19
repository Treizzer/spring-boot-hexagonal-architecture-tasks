package com.hex_arch.tasks.application.usecases;

import java.util.List;
import java.util.Optional;

import com.hex_arch.tasks.domain.models.Task;
import com.hex_arch.tasks.domain.ports.in.RetrieveTaskUseCase;
import com.hex_arch.tasks.domain.ports.out.TaskRepositoryPort;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RetrieveTaskUseCaseManager implements RetrieveTaskUseCase {

    private final TaskRepositoryPort repository;

    @Override
    public Optional<Task> getTask(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Task> getAllTasks() {
        return repository.findAll();
    }

}
