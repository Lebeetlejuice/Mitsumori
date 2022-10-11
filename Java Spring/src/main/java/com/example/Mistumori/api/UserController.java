package com.example.Mistumori.api;

import com.example.Mistumori.model.User;
import com.example.Mistumori.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/user")
@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }

    @GetMapping
    public List<User> getAllPeople(){
        return userService.getAllPeople();
    }

    @GetMapping(path = "{id}")
    public User getPersonbyId(@PathVariable("id")Integer id){
        return userService.getPersonbyId(id).orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deletePersonById(@PathVariable("id")Integer id){
        userService.deletePerson(id);
    }

    @PutMapping(path = "{id}")
    public void updatePerson(@PathVariable("id")Integer id, @RequestBody User userToUpdate){
        userService.updatePerson(id, userToUpdate);
    }
}
