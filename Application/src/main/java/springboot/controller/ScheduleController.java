package springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @CrossOrigin
    @GetMapping("/schedule")
    public ResponseEntity<?> getAll(){
        List<Schedule> list = scheduleService.getAll();
        if(list.size()==0){
            return new ResponseEntity<>(list, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping("/schedule")
    public ResponseEntity<?> save(@RequestBody Schedule schedule){
        Optional<Schedule> opt = scheduleService.save(schedule);
        if(!opt.isPresent()){
            return new ResponseEntity<>(opt, HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>(opt, HttpStatus.CREATED);
    }

    @CrossOrigin
    @GetMapping("/schedule/{id}")
    public ResponseEntity<?> get(@PathVariable int id){
        Optional<Schedule> opt = scheduleService.getScheduleById(id);
        if(!opt.isPresent()){
            return new ResponseEntity<>(opt, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(opt, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/schedule/user/{userId}")
    public ResponseEntity<?> getSchedules(@PathVariable int userId){
        List<Schedule> list = scheduleService.getSchedulesByUserId(userId);
        if(list==null){
            return new ResponseEntity<>(list, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/schedule/user/{userId}/closest")
    public ResponseEntity<?> getScheduleClosest(@PathVariable int userId){
        Optional<Schedule> opt = scheduleService.getUsersMostRecentSchedule(userId);
        if(!opt.isPresent()){
            return new ResponseEntity<>(opt, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(opt, HttpStatus.OK);
    }

    @CrossOrigin
    @PatchMapping("/schedule/{id}")
    public ResponseEntity<?> update(@RequestBody Schedule schedule){
        Optional<Schedule> opt = scheduleService.updateSchedule(schedule);
        if(!opt.isPresent()){
            return new ResponseEntity<>(opt, HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>(opt, HttpStatus.ACCEPTED);
    }

    @CrossOrigin
    @DeleteMapping("/schedule/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        Optional<Schedule> opt = scheduleService.deleteSchedule(id);
        if(!opt.isPresent()){
            return new ResponseEntity<>(opt, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(opt, HttpStatus.ACCEPTED);
    }


}
