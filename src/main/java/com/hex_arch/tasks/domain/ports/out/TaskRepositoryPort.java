package com.hex_arch.tasks.domain.ports.out;

import java.util.List;
import java.util.Optional;

import com.hex_arch.tasks.domain.models.Task;

public interface TaskRepositoryPort {

    Task save(Task task);

    Optional<Task> findById(Long id);

    List<Task> findAll();

    Optional<Task> update(Task task);

    Boolean deleteById(Long id);

}
