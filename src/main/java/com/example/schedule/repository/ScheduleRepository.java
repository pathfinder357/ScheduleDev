package com.example.schedule.repository;

import com.example.schedule.entity.Schedule;

import java.util.List;
import java.util.Optional;

public interface ScheduleRepository {
    Schedule save(Schedule schedule);
    List<Schedule> findAll(String updatedDate, String memberName);
    Optional<Schedule> findById(Long id);
}
