package springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springboot.repository.*;
import springboot.service.OrganizationService;
import springboot.service.ScheduleService;
import springboot.service.UserService;

import javax.persistence.EntityManager;

@Configuration
public class SpringConfig {

    private EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em){
        this.em = em;
    }

//    @Bean
//    public UserService userService(){
//        return new UserService(userRepository(), org_userRepository(), supervisor_subordinateRepository());
//    }

    @Bean
    public UserRepositoryInterface userRepository(){
        return new UserRepository(em);
    }

//    @Bean
//    public OrganizationService organizationService(){
//        return new OrganizationService(organizationRepository(), org_userRepository());
//    }
    @Bean
    public OrganizationRepositoryInterface organizationRepository(){
        return new OrganizationRepository(em);
    }

    @Bean
    public Org_UserRepositoryInterface org_userRepository(){
        return new Org_UserRepository(em);
    }

    @Bean
    public Supervisor_SubordinateRepositoryInterface supervisor_subordinateRepository(){
        return new Supervisor_SubordinateRepository(em);
    }

    @Bean
    public ScheduleRepositoryInterface scheduleRepository(){
        return new ScheduleRepository(em);
    }

//    @Bean
//    public ScheduleService scheduleService(){
//        return new ScheduleService(scheduleRepository());
//    }


}