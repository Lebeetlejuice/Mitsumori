package com.example.Mistumori.api;

import com.example.Mistumori.Repository.UserRepo;
import com.example.Mistumori.model.User;
import com.example.Mistumori.security.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc(addFilters = false)
@WebMvcTest(controllers = UsersController.class)
class UsersControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserRepo userRepo;

    @MockBean
    private UserService userService;

    @Autowired
    private ObjectMapper objectMapper;

    private List<User> userList;

    @BeforeEach
    void setUp() {
        this.userList = new ArrayList<>();
        this.userList.add(new User("Roberto","ok@gmail.com","azerty"));
        this.userList.add(new User("Roberto2","ok2@gmail.com","azerty2"));
    }

    @Test
    void list() throws Exception {
        when(userService.listAllUser()).thenReturn(userList);

        this.mockMvc.perform(get("/api/test/user"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(userList.size()))
                .andDo(print());
    }
    @Test
    void DeleteUser() throws Exception {
        long id = 1L;

        doNothing().when(userService).deleteUser(id);
        this.mockMvc.perform(delete("/api/test/delete/{id}",id)
                        .characterEncoding("utf-8"))
                .andExpect(status().isNoContent())
                .andDo(print());
    }
    @Test
    void createUser() throws Exception {
        User user1 = new User("Roberto","ok@gmail.com","azerty");

        this.mockMvc.perform(post("/api/test/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(user1))
                        .characterEncoding("utf-8"))

                .andExpect(status().isCreated())
                .andDo(print());
    }
    @Test
    void shouldUpdateUser() throws Exception {
        long id = 1L;

        User user1 = new User(id,"Roberto","ok@gmail.com","azerty");
        User updateuser = new User(id,"Roberto", "ok@gmail.com", "Updated");

        when(userService.getUser(id)).thenReturn(Optional.of(user1));
        when(userService.saveUser(any(User.class))).thenReturn(updateuser);

        mockMvc.perform(put("/api/test/put/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updateuser))
                .characterEncoding("utf-8"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username").value(updateuser.getUsername()))
                .andExpect(jsonPath("$.email").value(updateuser.getEmail()))
                .andExpect(jsonPath("$.password").value(updateuser.getPassword()))
                .andDo(print());
    }

    @Test
    void allAccess() throws Exception {
        this.mockMvc.perform(get("/api/test/all"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void userAccess() throws Exception {
        this.mockMvc.perform(get("/api/test/users"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void moderatorAccess() throws Exception {
        this.mockMvc.perform(get("/api/test/mod"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void adminAccess() throws Exception {
        this.mockMvc.perform(get("/api/test/admin"))
                .andExpect(status().isOk())
                .andDo(print());
    }
}