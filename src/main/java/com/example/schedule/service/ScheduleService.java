package com.example.schedule.service;

import com.example.schedule.dto.request.ScheduleSaveRequestDto;
import com.example.schedule.dto.response.ScheduleResponseDto;
import com.example.schedule.entity.Schedule;
import com.example.schedule.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    @Transactional
    public ScheduleResponseDto save(ScheduleSaveRequestDto requestDto) {
        Schedule schedule = new Schedule(
                requestDto.getTask(),
                requestDto.getPassword(),
                requestDto.getMemberName()
        );

        Schedule savedSchedule = scheduleRepository.save(schedule);

        return new ScheduleResponseDto(
                savedSchedule.getId(),
                savedSchedule.getTask(),
                savedSchedule.getMemberName(),
                savedSchedule.getCreatedAt(),
                savedSchedule.getUpdatedAt()
        );
    }

    @Transactional(readOnly = true)
    public ScheduleResponseDto findScheduleById(Long id) {
        Schedule schedule = scheduleRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 id의 스케줄이 존재하지 않습니다.")
        );

        return new ScheduleResponseDto(
                schedule.getId(),
                schedule.getTask(),
                schedule.getMemberName(),
                schedule.getCreatedAt(),
                schedule.getUpdatedAt()
        );
    }

    @Transactional(readOnly = true)
    public List<ScheduleResponseDto> findAll(String updatedDate, String memberName) {
        List<Schedule> schedules = scheduleRepository.findAll(updatedDate, memberName);

        return schedules.stream().map(schedule -> new ScheduleResponseDto(
                schedule.getId(),
                schedule.getTask(),
                schedule.getMemberName(),
                schedule.getCreatedAt(),
                schedule.getUpdatedAt()
        )).toList();
    }
}
