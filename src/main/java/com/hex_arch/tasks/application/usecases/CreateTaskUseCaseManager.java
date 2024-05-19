package com.hex_arch.tasks.application.usecases;

import com.hex_arch.tasks.domain.models.Task;
import com.hex_arch.tasks.domain.ports.in.CreateTaskUseCase;
import com.hex_arch.tasks.domain.ports.out.TaskRepositoryPort;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateTaskUseCaseManager implements CreateTaskUseCase {

    private final TaskRepositoryPort repository;

    @Override
    public Task createTask(Task task) {
        return repository.save(task);
    }

}
