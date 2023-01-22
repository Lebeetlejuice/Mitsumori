package com.example.Mistumori.security.service;

import com.example.Mistumori.Repository.UserRepo;
import com.example.Mistumori.model.Estimation;
import com.example.Mistumori.model.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Date;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;

class UserServiceTest {
    @Mock
    private UserRepo userRepo;
    private AutoCloseable autocloseable;
    private UserService userService;
    @BeforeEach
    void setUp() {
        autocloseable = MockitoAnnotations.openMocks(this);
        userService = new UserService(userRepo);
    }

    @AfterEach
    void tearDown() throws Exception {
        autocloseable.close();
    }

    @Test
    void listAllUser() {
        userService.listAllUser();
        verify(userRepo).findAll();
    }

    @Test
    void saveUser() {

        User user1 = new User("enzo", "enzo@gmail.com", "blabla");
        userService.saveUser(user1);

        ArgumentCaptor<User> estimationArgumentCaptor = ArgumentCaptor.forClass(User.class);
        verify(userRepo).save(estimationArgumentCaptor.capture());

        User captureUser = estimationArgumentCaptor.getValue();
        assertThat(captureUser).isEqualTo(user1);
    }

    @Test
    void getUser() {
        userService.getUser(1L);
        verify(userRepo).findById(1L);
    }

    @Test
    void deleteUser() {
        userService.deleteUser(1L);
        verify(userRepo).deleteById(1L);
    }
}