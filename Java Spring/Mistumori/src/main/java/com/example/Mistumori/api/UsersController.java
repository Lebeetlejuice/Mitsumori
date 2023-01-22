package com.example.Mistumori.api;

import com.example.Mistumori.model.Estimation;
import com.example.Mistumori.model.User;
import com.example.Mistumori.payload.response.MessageResponse;
import com.example.Mistumori.security.service.UserDetailsImpl;
import com.example.Mistumori.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8081", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("/api/test")
public class UsersController {
    @Autowired
    UserService userService;

    @PostMapping("/post")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_MODERATOR') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> createUser(@RequestBody User user, HttpServletRequest request) {

        userService.saveUser(user);

        return new ResponseEntity<String>("Estimation is deleted successfully.!", HttpStatus.CREATED);
    }

    @PutMapping("/put/{id}")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_MODERATOR') or hasRole('ROLE_ADMIN')")
        public User put(@PathVariable("id") Long id,@RequestBody User user ) {
        return userService.getUser(id).map(
                        use -> {
                            use.setUsername(user.getUsername());
                            use.setEmail(user.getEmail());
                            use.setPassword(user.getPassword());
                            return userService.saveUser(use);
                        }
                )
                .orElseGet(() -> {
                    user.setId(id);
                    return userService.saveUser(user);
                });

    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('ROLE_MODERATOR') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<String>("Estimation is deleted successfully.!", HttpStatus.NO_CONTENT);
    }

    @GetMapping("/all")
    @PreAuthorize("hasRole('ROLE_MODERATOR') or hasRole('ROLE_ADMIN')")
    public String allAccess() {
        return "Public Content.";
    }

    @GetMapping("/users")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_MODERATOR') or hasRole('ROLE_ADMIN')")
    public String userAccess() {
        return "User Board.";
    }

    @GetMapping("/user")
    @PreAuthorize("hasRole('ROLE_MODERATOR') or hasRole('ROLE_ADMIN')")
    public List<User> list() {
        return userService.listAllUser();
    }

    @GetMapping("/mod")
    @PreAuthorize("hasRole('ROLE_MODERATOR') or hasRole('ROLE_ADMIN')")
    public String moderatorAccess() {
        return "Moderator Board.";
    }


    @GetMapping("/admin")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String adminAccess() {
        return "Admin Board.";
    }
}