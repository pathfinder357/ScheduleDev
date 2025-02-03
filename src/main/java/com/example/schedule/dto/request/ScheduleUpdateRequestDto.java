package com.example.schedule.dto.request;

import lombok.Getter;

@Getter
public class ScheduleUpdateRequestDto {

    private String task;
    private String memberEmail;
    private String password;
}
