package com.example.Mistumori.service;

import com.example.Mistumori.Repository.RoleRepo;
import com.example.Mistumori.Repository.UserRepo;
import com.example.Mistumori.model.Role;
import com.example.Mistumori.model.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service @RequiredArgsConstructor @Transactional @Slf4j
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserRepo userRepo;
    private final RoleRepo roleRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findBysurname((username));
        if (user == null){
            log.error("user not found");
            throw new UsernameNotFoundException(("user not found"));
        } else {
            log.error("user found in db {}", username);
        }

        Collection< SimpleGrantedAuthority> authorities = new ArrayList<>();
            user.getRoles().forEach(role -> {authorities.add(new SimpleGrantedAuthority(role.getName()));
        });
        return new org.springframework.security.core.userdetails.User(user.getName(), user.getMdp(), authorities);
    }

    @Override
    public User saveUser(User user) {
        log.info("saving new user {} to db", user.getName());
        return userRepo.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("saving new role {} to db", role.getName());
        return roleRepo.save(role);
    }

    @Override
    public void addRoleToUser(String surname, String roleName) {
        log.info("adding role {} to user {} to db", roleName, surname);
        User user = userRepo.findBysurname(surname);
        Role role = roleRepo.findByname(roleName);
        user.getRoles().add(role);
    }

    @Override
    public User getUser(String surname) {
        log.info("Fetching user {} to db", surname);
        return userRepo.findBysurname(surname);
    }

    @Override
    public List<User> getUsers() {
        log.info("Fetching all users");
        return userRepo.findAll();
    }
}
    //private final UserDAO userDAO;

    /*@Autowired
    public UserService(@Qualifier("postgres") UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    *\
    public int addUser(User user){

        return userDAO.insertUser(user);
    }

    public List<User> getAllPeople(){
        return userDAO.selectAllPeople();
    }

    public Optional<User> getPersonbyId(Integer id) {
        return userDAO.selectPersonById(id);
    }

    public int deletePerson(Integer id){
        return userDAO.deletePersonById(id);
    }
    public int updatePerson(Integer id, User newUser){
        return userDAO.updatePersonById(id, newUser);
    }
}*/
