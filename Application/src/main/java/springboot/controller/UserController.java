package springboot.controller;

import springboot.domain.Organization;
import springboot.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springboot.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

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
    public Organization getOrganization(@PathVariable int id){
        Optional<User> optionalUser = userService.findById(id);
        User user = optionalUser.isPresent() ? optionalUser.get() : null;
        Optional<Organization> optionalOrganization = userService.getOrganizationByUserId(user.getId());
        return optionalOrganization.isPresent() ? optionalOrganization.get() : null;
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

    @PutMapping("/user/{id}")
    public User update(@RequestBody User userUpdate) {
        Optional<User> optionalUser = userService.findById(userUpdate.getId());
        if (optionalUser.isPresent()) {
            userService.save(userUpdate);
        }
        return userUpdate;
    }

    @PutMapping("/user/{userId}/add/subordinate/{subordinateId}")
    public void addSubordinate(@PathVariable int userId, @PathVariable int subordinateId) {
        Optional<User> optionalUser = userService.findById(userId);
        User user = optionalUser.isPresent() ? optionalUser.get() : null;
        Optional<User> optionalSubordinate = userService.findById(subordinateId);
        User subordinate = optionalSubordinate.isPresent() ? optionalSubordinate.get() : null;
        userService.addSubordinate(user.getId(), subordinate.getId());
    }

    @PutMapping("/user/{userId}/add/supervisor/{supervisorId}")
    public void addSupervisor(@PathVariable int userId, @PathVariable int supervisorId) {
        Optional<User> optionalUser = userService.findById(userId);
        User user = optionalUser.isPresent() ? optionalUser.get() : null;
        Optional<User> optionalSupervisor = userService.findById(supervisorId);
        User subordinate = optionalSupervisor.isPresent() ? optionalSupervisor.get() : null;
        userService.addSupervisor(user.getId(), subordinate.getId());
    }

    @DeleteMapping("/user/{id}")
    public void delete(@PathVariable int id) {
        userService.deleteById(id);
    }

    @DeleteMapping("/user/{userId}/remove/subordinate/{subordinateId}")
    public void deleteSubordinate(@PathVariable int userId, @PathVariable int subordinateId) {
        userService.deleteSubordinate(userId, subordinateId);
    }

    @DeleteMapping("/user/{userId}/remove/supervisor/{supervisorId}")
    public void deleteSupervisor(@PathVariable int userId, @PathVariable int supervisorId) {
        userService.deleteSupervisor(userId, supervisorId);
    }




}

