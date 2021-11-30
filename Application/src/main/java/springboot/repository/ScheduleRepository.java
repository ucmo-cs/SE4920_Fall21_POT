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
        Optional<Schedule> opt = Optional.of(em.createQuery("select x from Schedule x where x.id = :id", Schedule.class)
                .setParameter("id", id).getSingleResult());

        return opt;
    }

    @Override
    public List<Schedule> getSchedulesByUserId(int userId) {
        List<Schedule> sch = em.createQuery("select x from Schedule x where x.user_id = :userId", Schedule.class)
                .setParameter("userId", userId).getResultList();

        return sch;
    }

    @Override
    public Optional<Schedule> addSchedule(Schedule schedule) {
        em.persist(schedule);
        return Optional.of(schedule);
    }

    @Override
    public Optional<Schedule> deleteSchedule(int id) {
        Optional<Schedule> opt = Optional.of(em.createQuery("select x from Schedule x where x.id = :id", Schedule.class)
                .setParameter("id", id).getSingleResult());
        if(opt.isPresent()){
            em.createQuery("delete from Schedule x where x.id = :id", Schedule.class)
                    .setParameter("id", id);
        }
        return opt;
    }
}
