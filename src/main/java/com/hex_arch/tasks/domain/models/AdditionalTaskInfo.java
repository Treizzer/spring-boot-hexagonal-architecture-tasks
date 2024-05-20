package com.hex_arch.tasks.domain.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AdditionalTaskInfo {

    private final Long userId;

    private final String username;

    private final String userEmail;

}
