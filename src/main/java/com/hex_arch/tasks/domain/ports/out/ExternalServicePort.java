package com.hex_arch.tasks.domain.ports.out;

import com.hex_arch.tasks.domain.models.AdditionalTaskInfo;

public interface ExternalServicePort {

    AdditionalTaskInfo getAdditionalTaskInfo(Long id);

}
