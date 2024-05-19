package com.hex_arch.tasks.application.usecases;

import java.util.Optional;

import com.hex_arch.tasks.domain.models.Task;
import com.hex_arch.tasks.domain.ports.in.UpdateTaskUseCase;
import com.hex_arch.tasks.domain.ports.out.TaskRepositoryPort;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UpdateTaskUseCaseManager implements UpdateTaskUseCase {

    private final TaskRepositoryPort repository;

    @Override
    public Optional<Task> updateTask(Long id, Task task) {
        return repository.update(task);
    }

}
