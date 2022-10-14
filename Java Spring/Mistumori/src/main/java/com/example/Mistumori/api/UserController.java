package com.example.Mistumori.api;

import com.example.Mistumori.model.Role;
import com.example.Mistumori.model.User;
import com.example.Mistumori.service.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RequestMapping("api")
@RestController @RequiredArgsConstructor
public class UserController {
    @Autowired
    private final UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok().body(userService.getUsers());
    }

    @PostMapping("/user/save")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("api/user/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveUser(user));
    }

    @PostMapping("/role/save")
    public ResponseEntity<Role> saveRole(@RequestBody Role role) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("api/role/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveRole(role));
    }

    @PostMapping("/role/addtouser")
    public ResponseEntity<?> addRoleToUser(@RequestBody RoleToUserForm form) {
        userService.addRoleToUser(form.getSurname(), form.getRoleName());
        return ResponseEntity.ok().build();
    }
}
@Data
class RoleToUserForm {
    private String surname;
    private String roleName;
}
    /*private final UserServiceImpl userServiceImpl;

    @Autowired
    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }
    @PostMapping
    public void addUser(@RequestBody User user){
        userServiceImpl.addUser(user);
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody HashMap<String, Object> userMap){
        String name = (String) userMap.get("name");
        String surname = (String) userMap.get("username");
        String mdp = (String) userMap.get("mdp");
        return mdp + surname + name ;

    }

    @GetMapping
    public List<User> getAllPeople(){
        return userServiceImpl.getAllPeople();
    }

    @GetMapping(path = "{id}")
    public User getPersonbyId(@PathVariable("id")Integer id){
        return userServiceImpl.getPersonbyId(id).orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deletePersonById(@PathVariable("id")Integer id){
        userServiceImpl.deletePerson(id);
    }

    @PutMapping(path = "{id}")
    public void updatePerson(@PathVariable("id")Integer id, @RequestBody User userToUpdate){
        userServiceImpl.updatePerson(id, userToUpdate);
    }
}*/
