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
        Optional<Schedule> opt = Optional.of(
                em.createQuery("select x from Schedule x where x.id = :id", Schedule.class)
                .setParameter("id", id)
                .getSingleResult());
        return opt;
    }

    @Override
    public List<Schedule> getSchedulesByUserId(int user_id) {
        List<Schedule> list = em.createQuery("select x from Schedule x where x.user_id = :user_id", Schedule.class)
                .setParameter("user_id", user_id)
                .getResultList();
        return list;
    }

    @Override
    public Optional<Schedule> addSchedule(Schedule schedule) {
        em.persist(schedule);
        return Optional.of(schedule);
    }

    @Override
    public Optional<Schedule> deleteSchedule(int id) {
        Optional<Schedule> opt = Optional.of(
                em.createQuery("select x from Schedule x where x.id = :id", Schedule.class)
                .setParameter("id", id)
                .getSingleResult());
        if(opt.isPresent()){
            em.remove(opt.get());
        }
        return opt;
    }
}
