package com.hex_arch.tasks.application.usecases;

import com.hex_arch.tasks.domain.ports.in.DeleteTaskUseCase;
import com.hex_arch.tasks.domain.ports.out.TaskRepositoryPort;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DeleteTaskUseCaseManager implements DeleteTaskUseCase {

    private final TaskRepositoryPort repository;

    @Override
    public Boolean deleteTask(Long id) {
        return repository.deleteById(id);
    }

}
