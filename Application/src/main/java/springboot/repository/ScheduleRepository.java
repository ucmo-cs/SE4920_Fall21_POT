package springboot.repository;

import springboot.domain.Schedule;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class ScheduleRepository extends RepositoryGeneric implements ScheduleRepositoryInterface{

    public ScheduleRepository(EntityManager em) {
        super(em);
    }

    @Override
    public Optional<Schedule> getScheduleById(int id) {
        return Optional.empty();
    }

    @Override
    public List<Schedule> getSchedulesByUserId(int userId) {
        return null;
    }

    @Override
    public Optional<Schedule> addSchedule(Schedule schedule) {
        return Optional.empty();
    }

    @Override
    public Optional<Schedule> deleteSchedule(int id) {
        return Optional.empty();
    }
}
