package com.hex_arch.tasks.domain.ports.in;

import java.util.List;
import java.util.Optional;

import com.hex_arch.tasks.domain.models.Task;

public interface RetrieveTaskUseCase {

    Optional<Task> getTask(Long id);

    List<Task> getAllTasks();

}
