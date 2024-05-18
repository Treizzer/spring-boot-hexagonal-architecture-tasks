package com.hex_arch.tasks.domain.ports.in;

import com.hex_arch.tasks.domain.models.AdditionalTaskInfo;

public interface GetAdditionalTaskInfoUseCase {

    AdditionalTaskInfo getAdditionalTaskInfo(Long id);

}
