package com.hex_arch.tasks.domain.ports.in;

import java.util.Optional;

import com.hex_arch.tasks.domain.models.Task;

// S of SOLID: Applying single responsibility principle
public interface UpdateTaskUseCase {

    // Is responsible for handling the reception of data, if object exists
    // it can be assigned, otherwise no and it will be null
    Optional<Task> updateTask(Long id, Task task);

}
