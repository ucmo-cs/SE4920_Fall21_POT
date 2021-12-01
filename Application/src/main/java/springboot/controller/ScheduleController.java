package springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springboot.domain.Organization;
import springboot.domain.Schedule;
import springboot.service.OrganizationService;
import springboot.service.ScheduleService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
//@RequestMapping("schedule")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;


    @GetMapping("/schedule")
    public List<Schedule> getAll(){
        System.out.println("Schedule test, GET");
        //not a usable function.
        return null;
    }

    @PostMapping("/schedule")
    public Schedule save(@RequestBody Schedule schedule){
        System.out.println("Schedule test");
        Optional<Schedule> optionalSchedule = scheduleService.save(schedule);
        return optionalSchedule.isPresent() ? optionalSchedule.get() : null;
    }

    @GetMapping("/schedule/{id}")
    public Schedule get(@PathVariable int id){
        Optional<Schedule> optionalSchedule = scheduleService.getScheduleById(id);
        return optionalSchedule.isPresent() ? optionalSchedule.get() : null;
    }

    @GetMapping("/schedule/user/{userId}")
    public List<Schedule> getSchedules(@PathVariable int userId){
        List<Schedule> list = new ArrayList<>();
        scheduleService.getSchedulesByUserId(userId).iterator().forEachRemaining(list::add);
        return list;
    }

    @DeleteMapping("/schedule/{id}")
    public void delete(@PathVariable int id){
        scheduleService.deleteSchedule(id);
    }
}
