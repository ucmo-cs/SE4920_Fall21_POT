package springboot.repository;

import springboot.domain.Organization;
import springboot.domain.Schedule;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ScheduleRepository extends RepositoryGeneric implements ScheduleRepositoryInterface{

    public ScheduleRepository(EntityManager em) {
        super(em);
    }

    @Override
    public List<Schedule> getAll(){
        List<Schedule> list = em.createQuery("select x from Schedule x", Schedule.class)
                .getResultList();
        return list;
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

    @Override
    public Optional<Schedule> update(Schedule schedule) {
        Optional<Schedule> opt =
                em.createQuery("select x from Schedule x where x.id = :id", Schedule.class)
                        .setParameter("id", schedule.getId())
                        .getResultStream()
                        .findFirst();
        if(opt.isPresent()){
            em.persist(schedule);
        }
        return opt;
    }

    @Override
    public Optional<Schedule> getUsersMostRecentSchedule(int userId) {
        List<Schedule> list = this.getSchedulesByUserId(userId);
        List<Schedule> sorted = list.stream().sorted().collect(Collectors.toList());
        if(sorted.size()==0){
            return Optional.of(null);
        }
        return Optional.of(sorted.get(0));
    }
}
