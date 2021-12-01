package springboot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import springboot.domain.Credentials;
import springboot.domain.Organization;
import springboot.domain.Supervisor_Subordinate;
import springboot.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springboot.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
//@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @CrossOrigin
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Credentials creds) {
        boolean valid = userService.validateLogin(creds);
        if(valid){
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

    @PostMapping("/user")
    public ResponseEntity<?> saveUser(@RequestBody User user) {
//        List<User> list = new ArrayList<>();
//        userService.findAll().iterator().forEachRemaining(list::add);
//        return list;
        return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
    }


    @GetMapping("/user")
    public List<User> listUsers() {
        List<User> list = new ArrayList<>();
        userService.findAll().iterator().forEachRemaining(list::add);
        return list;
    }



    @GetMapping("/user/{id}")
    public User getOne(@PathVariable int id) {
        Optional<User> optionalUser = userService.findById(id);
        return optionalUser.isPresent() ? optionalUser.get() : null;
    }

    @GetMapping("/user/{username}")
    public User getUser(@PathVariable String username) {
        Optional<User> optionalUser = userService.findByUsername(username);
        return optionalUser.isPresent() ? optionalUser.get() : null;
    }

    @GetMapping("/user/{id}/organization")
    public List<Organization> getOrganization(@PathVariable int id){
        Optional<User> optionalUser = userService.findById(id);
        User user = optionalUser.isPresent() ? optionalUser.get() : null;
        List<Organization> org = userService.getOrganizationByUserId(user.getId());
        return org;
    }

    @GetMapping("/user/{id}/supervisor")
    public User getSupervisor(@PathVariable int id){
        Optional<User> optionalUser = userService.findById(id);
        User user = optionalUser.isPresent() ? optionalUser.get() : null;
        Optional<User> optionalSupervisor = userService.getSupervisorOfId(user.getId());
        return optionalSupervisor.isPresent() ? optionalSupervisor.get() : null;
    }

    @GetMapping("/user/{id}/subordinates")
    public List<User> getSubordinates(@PathVariable int id){
        Optional<User> optionalUser = userService.findById(id);
        User user = optionalUser.isPresent() ? optionalUser.get() : null;
        List<User> subordinates = new ArrayList<>();
        userService.getSubordinatesOfId(user.getId()).iterator().forEachRemaining(subordinates::add);
        return subordinates;
    }

    @PostMapping("/user/{id}")
    public User update(@RequestBody User userUpdate) {
        Optional<User> optionalUser = userService.findById(userUpdate.getId());
        if (optionalUser.isPresent()) {
            userService.save(userUpdate);
        }
        return userUpdate;
    }

    @PostMapping("/subordinate")
    public void addSubordinate(@RequestBody Supervisor_Subordinate supervisorSubordinate) {
        userService.addSubordinate(supervisorSubordinate);
    }

    @PutMapping("/supervisor")
    public void addSupervisor(@RequestBody Supervisor_Subordinate supervisorSubordinate) {
        userService.addSupervisor(supervisorSubordinate);
    }

    @DeleteMapping("/user/{id}")
    public void delete(@PathVariable int id) {
        userService.deleteById(id);
    }

    @DeleteMapping("/subordinate")
    public void deleteSubordinate(@RequestBody Supervisor_Subordinate supervisorSubordinate) {
        userService.deleteSubordinate(supervisorSubordinate);
    }

    @DeleteMapping("/supervisor")
    public void deleteSupervisor(@RequestBody Supervisor_Subordinate supervisorSubordinate) {
        userService.deleteSupervisor(supervisorSubordinate);
    }




}

