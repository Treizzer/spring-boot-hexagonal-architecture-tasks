package com.hex_arch.tasks.application.services;

import java.util.List;
import java.util.Optional;

import com.hex_arch.tasks.domain.models.AdditionalTaskInfo;
import com.hex_arch.tasks.domain.models.Task;
import com.hex_arch.tasks.domain.ports.in.CreateTaskUseCase;
import com.hex_arch.tasks.domain.ports.in.DeleteTaskUseCase;
import com.hex_arch.tasks.domain.ports.in.GetAdditionalTaskInfoUseCase;
import com.hex_arch.tasks.domain.ports.in.RetrieveTaskUseCase;
import com.hex_arch.tasks.domain.ports.in.UpdateTaskUseCase;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TaskService implements CreateTaskUseCase, RetrieveTaskUseCase, UpdateTaskUseCase,
        DeleteTaskUseCase, GetAdditionalTaskInfoUseCase {

    private final CreateTaskUseCase create;
    private final RetrieveTaskUseCase retrieve;
    private final UpdateTaskUseCase update;
    private final DeleteTaskUseCase delete;
    private final GetAdditionalTaskInfoUseCase additionalTaskInfo;

    @Override
    public Task createTask(Task task) {
        return create.createTask(task);
    }

    @Override
    public Optional<Task> getTask(Long id) {
        return retrieve.getTask(id);
    }

    @Override
    public List<Task> getAllTasks() {
        return retrieve.getAllTasks();
    }

    @Override
    public Optional<Task> updateTask(Long id, Task task) {
        return update.updateTask(id, task);
    }

    @Override
    public Boolean deleteTask(Long id) {
        return delete.deleteTask(id);
    }

    @Override
    public AdditionalTaskInfo getAdditionalTaskInfo(Long id) {
        return additionalTaskInfo.getAdditionalTaskInfo(id);
    }

}
