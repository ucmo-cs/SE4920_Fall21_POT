package springboot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import springboot.domain.*;
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
        if(!userService.validateLogin(creds)){
            return new ResponseEntity<>(false, HttpStatus.NOT_ACCEPTABLE);
        }
        int id = userService.findByEmail(creds.getEmail()).get().getId();
        return new ResponseEntity<>(id, HttpStatus.ACCEPTED);
    }

    @CrossOrigin
    @GetMapping("/user")
    public ResponseEntity<?> listUsers() {
        List<User> list = userService.findAll();
        if(list.size()==0){
            return new ResponseEntity<>(list, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    ////////////////VVVVVV

    @CrossOrigin
    @PostMapping("/user")
    public ResponseEntity<?> saveUser(@RequestBody User user) {
        Optional<User> opt = userService.save(user);
        if(!opt.isPresent()){
            return new ResponseEntity<>(opt, HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>(opt, HttpStatus.CREATED);
    }

    @CrossOrigin
    @GetMapping("/user/{id}")
    public User getOne(@PathVariable int id) {
        Optional<User> optionalUser = userService.findById(id);
        return optionalUser.isPresent() ? optionalUser.get() : null;
    }

    @CrossOrigin
    @GetMapping("/user/{username}")
    public User getUser(@PathVariable String username) {
        Optional<User> optionalUser = userService.findByUsername(username);
        return optionalUser.isPresent() ? optionalUser.get() : null;
    }

    @CrossOrigin
    @GetMapping("/user/{id}/organization")
    public List<Organization> getOrganization(@PathVariable int id){
        Optional<User> optionalUser = userService.findById(id);
        User user = optionalUser.isPresent() ? optionalUser.get() : null;
        List<Organization> org = userService.getOrganizationByUserId(user.getId());
        return org;
    }

    @CrossOrigin
    @GetMapping("/user/{id}/supervisor")
    public User getSupervisor(@PathVariable int id){
        Optional<User> optionalUser = userService.findById(id);
        User user = optionalUser.isPresent() ? optionalUser.get() : null;
        Optional<User> optionalSupervisor = userService.getSupervisorOfId(user.getId());
        return optionalSupervisor.isPresent() ? optionalSupervisor.get() : null;
    }

    @CrossOrigin
    @GetMapping("/user/{id}/subordinates")
    public List<User> getSubordinates(@PathVariable int id){
        Optional<User> optionalUser = userService.findById(id);
        User user = optionalUser.isPresent() ? optionalUser.get() : null;
        List<User> subordinates = new ArrayList<>();
        userService.getSubordinatesOfId(user.getId()).iterator().forEachRemaining(subordinates::add);
        return subordinates;
    }

    @CrossOrigin
    @PostMapping("/user/{id}")
    public User update(@RequestBody User userUpdate) {
        Optional<User> optionalUser = userService.findById(userUpdate.getId());
        if (optionalUser.isPresent()) {
            userService.save(userUpdate);
        }
        return userUpdate;
    }

    @CrossOrigin
    @PostMapping("/subordinate")
    public void addSubordinate(@RequestBody Supervisor_Subordinate supervisorSubordinate) {
        userService.addSubordinate(supervisorSubordinate);
    }

    @CrossOrigin
    @PutMapping("/supervisor")
    public void addSupervisor(@RequestBody Supervisor_Subordinate supervisorSubordinate) {
        userService.addSupervisor(supervisorSubordinate);
    }

    @CrossOrigin
    @DeleteMapping("/user/{id}")
    public void delete(@PathVariable int id) {
        userService.deleteById(id);
    }

    @CrossOrigin
    @DeleteMapping("/subordinate")
    public void deleteSubordinate(@RequestBody Supervisor_Subordinate supervisorSubordinate) {
        userService.deleteSubordinate(supervisorSubordinate);
    }

    @CrossOrigin
    @DeleteMapping("/supervisor")
    public void deleteSupervisor(@RequestBody Supervisor_Subordinate supervisorSubordinate) {
        userService.deleteSupervisor(supervisorSubordinate);
    }




}

