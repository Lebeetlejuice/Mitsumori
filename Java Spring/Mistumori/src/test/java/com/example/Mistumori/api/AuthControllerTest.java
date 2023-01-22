package com.example.Mistumori.api;

import com.example.Mistumori.Repository.EstimationRepo;
import com.example.Mistumori.Repository.RoleRepo;
import com.example.Mistumori.Repository.UserRepo;
import com.example.Mistumori.model.User;
import com.example.Mistumori.security.SecurityConfig;
import com.example.Mistumori.security.jwt.JwtUtils;
import com.example.Mistumori.security.service.EstimationService;
import com.example.Mistumori.security.service.RefreshTokenService;
import com.example.Mistumori.security.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@AutoConfigureMockMvc(addFilters = false)
@WebMvcTest(controllers = AuthController.class)
class AuthControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AuthenticationManager authenticationManager;
    @MockBean
    private PasswordEncoder passwordEncoder;
    @MockBean
    private RefreshTokenService refreshTokenService;
    @MockBean
    private JwtUtils jwtUtils;
    @MockBean
    private RoleRepo roleRepo;
    @MockBean
    private UserService userService;

    @MockBean
    private UserRepo userRepo;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @Disabled
    void authenticateUser() {
    }

    @Test
    void registerUser() throws Exception {
        User user1 = new User("Roberto","ok@gmail.com","azerty");
        this.mockMvc.perform(post("/api/auth/signup")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(user1)))
                .andExpect(status().isCreated());
    }

    @Test
    @Disabled
    void logoutUser() {
    }

    @Test
    @Disabled
    void refreshtoken() {
    }
}