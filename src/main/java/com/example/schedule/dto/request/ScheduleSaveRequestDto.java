package com.example.schedule.dto.request;

import lombok.Getter;

@Getter
public class ScheduleSaveRequestDto {

    private String task;
    private String memberEmail;
    private String password;
}
