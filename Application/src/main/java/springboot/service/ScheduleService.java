package springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springboot.domain.Schedule;
import springboot.repository.ScheduleRepositoryInterface;

import java.util.List;
import java.util.Optional;

@Service
public class ScheduleService {

    @Autowired
    private ScheduleRepositoryInterface scheduleRepository;


    public ScheduleService(ScheduleRepositoryInterface scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }
    @Transactional
    public Optional<Schedule> save(Schedule schedule) {
        return scheduleRepository.addSchedule(schedule);
    }

    @Transactional
    public Optional<Schedule> getScheduleById(int id) {
        return scheduleRepository.getScheduleById(id);
    }

    @Transactional
    public List<Schedule> getSchedulesByUserId(int userId) {
        return scheduleRepository.getSchedulesByUserId(userId);
    }

    @Transactional
    public Optional<Schedule> deleteSchedule(int id){
        return scheduleRepository.deleteSchedule(id);
    }
}
