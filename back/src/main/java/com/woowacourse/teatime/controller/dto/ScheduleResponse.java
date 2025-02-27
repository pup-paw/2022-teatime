package com.woowacourse.teatime.controller.dto;

import com.woowacourse.teatime.domain.Schedule;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ScheduleResponse {

    private Integer day;
    private List<ScheduleDto> schedules;

    public static List<ScheduleResponse> from(List<Schedule> schedules) {
        List<Integer> days = findDays(schedules);
        List<ScheduleResponse> scheduleResponses = new ArrayList<>();
        for (Integer day : days) {
            List<Schedule> scheduleByDay = findByDay(day, schedules);
            scheduleResponses.add(ScheduleResponse.of(day, scheduleByDay));
        }
        return scheduleResponses;
    }

    private static List<Integer> findDays(List<Schedule> schedules) {
        return schedules.stream()
                .map(Schedule::getLocalDateTime)
                .map(LocalDateTime::getDayOfMonth)
                .distinct()
                .collect(Collectors.toList());
    }

    private static List<Schedule> findByDay(int day, List<Schedule> schedules) {
        return schedules.stream()
                .filter(schedule -> schedule.isSameDay(day))
                .collect(Collectors.toList());
    }

    private static ScheduleResponse of(int day, List<Schedule> schedules) {
        List<ScheduleDto> scheduleDtos = schedules.stream()
                .map(ScheduleDto::new)
                .collect(Collectors.toList());
        return new ScheduleResponse(day, scheduleDtos);
    }
}
