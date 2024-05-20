package com.hex_arch.tasks.domain.models;

import java.time.LocalDateTime;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Task {

    private Long id;

    private String title;

    private String description;

    private LocalDateTime creationDate;

    @Getter(value = AccessLevel.NONE)
    private Boolean completed;

    public Boolean isCompleted() {
        return completed;
    }

}
