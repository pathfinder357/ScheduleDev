package com.example.schedule.controller;

import com.example.schedule.dto.request.ScheduleSaveRequestDto;
import com.example.schedule.dto.response.ScheduleResponseDto;
import com.example.schedule.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping("/schedules")
    public ResponseEntity<ScheduleResponseDto> save(@RequestBody ScheduleSaveRequestDto requestDto) {
        return ResponseEntity.ok(scheduleService.save(requestDto));
    }

    @GetMapping("/schedules")
    public ResponseEntity<List<ScheduleResponseDto>> findAll(
            @RequestParam(required = false) String updatedDate,
            @RequestParam(required = false) String memberName) {
        return ResponseEntity.ok(scheduleService.findAll(updatedDate, memberName));
    }

    @GetMapping("/schedules/{id}")
    public ResponseEntity<ScheduleResponseDto> findScheduleById(@PathVariable Long id) {
        return ResponseEntity.ok(scheduleService.findScheduleById(id));
    }
}
