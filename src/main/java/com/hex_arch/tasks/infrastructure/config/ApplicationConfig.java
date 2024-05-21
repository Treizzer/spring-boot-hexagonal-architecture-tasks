package com.hex_arch.tasks.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hex_arch.tasks.application.services.TaskService;
import com.hex_arch.tasks.application.usecases.CreateTaskUseCaseManager;
import com.hex_arch.tasks.application.usecases.DeleteTaskUseCaseManager;
import com.hex_arch.tasks.application.usecases.GetAdditionalTaskInfoUseCaseManager;
import com.hex_arch.tasks.application.usecases.RetrieveTaskUseCaseManager;
import com.hex_arch.tasks.application.usecases.UpdateTaskUseCaseManager;
import com.hex_arch.tasks.domain.ports.in.GetAdditionalTaskInfoUseCase;
import com.hex_arch.tasks.domain.ports.out.ExternalServicePort;
import com.hex_arch.tasks.domain.ports.out.TaskRepositoryPort;
import com.hex_arch.tasks.infrastructure.adapters.ExternalServiceAdapter;
import com.hex_arch.tasks.infrastructure.repositories.TaskRepositoryAdapter;

@Configuration
public class ApplicationConfig {

    @Bean
    public TaskService taskService(TaskRepositoryPort taskRepositoryPort,
            GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase) {
        return new TaskService(
                new CreateTaskUseCaseManager(taskRepositoryPort),
                new RetrieveTaskUseCaseManager(taskRepositoryPort),
                new UpdateTaskUseCaseManager(taskRepositoryPort),
                new DeleteTaskUseCaseManager(taskRepositoryPort),
                getAdditionalTaskInfoUseCase);
    }

    @Bean
    public TaskRepositoryPort taskRepositoryPort(TaskRepositoryAdapter taskRepositoryAdapter) {
        return taskRepositoryAdapter;
    }

    @Bean
    public GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase(
            ExternalServicePort externalServicePort) {
        return new GetAdditionalTaskInfoUseCaseManager(externalServicePort);
    }

    @Bean
    public ExternalServicePort externalServicePort() {
        return new ExternalServiceAdapter();
    }

}
