package com.example.schedule.dto.response;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ScheduleResponseDto {

    private final Long id;
    private final String task;
    private final String memberName;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;

    public ScheduleResponseDto(Long id, String task, String memberName, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.task = task;
        this.memberName = memberName;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
