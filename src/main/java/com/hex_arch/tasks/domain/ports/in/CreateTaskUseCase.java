package com.hex_arch.tasks.domain.ports.in;

import com.hex_arch.tasks.domain.models.Task;

public interface CreateTaskUseCase {

    Task createTask(Task task);

}
