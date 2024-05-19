package com.hex_arch.tasks.application.usecases;

import com.hex_arch.tasks.domain.models.AdditionalTaskInfo;
import com.hex_arch.tasks.domain.ports.in.GetAdditionalTaskInfoUseCase;
import com.hex_arch.tasks.domain.ports.out.ExternalServicePort;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GetAdditionalTaskInfoUseCaseManager implements GetAdditionalTaskInfoUseCase {

    private final ExternalServicePort externalServicePort;

    @Override
    public AdditionalTaskInfo getAdditionalTaskInfo(Long id) {
        return externalServicePort.getAdditionalTaskInfo(id);
    }

}
