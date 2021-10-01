package springboot.repository;

import springboot.domain.Organization;
import springboot.domain.Schedule;

import java.util.List;
import java.util.Optional;

public interface ScheduleRepositoryInterface {

    Optional<Schedule> getScheduleById(int id);
    List<Schedule> getSchedulesByUserId(int userId);
    Optional<Schedule> addSchedule(Schedule schedule);
    Optional<Schedule> deleteSchedule(int id);

}
