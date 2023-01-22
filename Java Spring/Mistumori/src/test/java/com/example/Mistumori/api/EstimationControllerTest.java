package com.example.Mistumori.api;

import com.example.Mistumori.Repository.EstimationRepo;
import com.example.Mistumori.Repository.UserRepo;
import com.example.Mistumori.model.Estimation;
import com.example.Mistumori.model.User;
import com.example.Mistumori.security.service.EstimationService;
import com.example.Mistumori.security.service.UserDetailsImpl;
import com.example.Mistumori.security.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.web.servlet.MockMvc;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
@WebMvcTest(controllers = EstimationController.class)
@AutoConfigureMockMvc(addFilters = false)
class EstimationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EstimationService estimationService;

    @MockBean
    private UserService userService;

    @MockBean
    private UserDetailsImpl userDetails;
    @MockBean
    private UserRepo userRepo;

    @MockBean
    private EstimationRepo estimationRepo;

    @Autowired
    private ObjectMapper objectMapper;
    @BeforeEach
    void setUp() {

      }

    @Test
    void createEstimation() throws Exception {
        Date date = new Date();
        User user1 = new User("Roberto","ok@gmail.com","azerty");
        Estimation estimation1 =  new Estimation(1L,"nike","chaussutres","nike dunk",1000,date,"belle chaussure",user1);

        Authentication authentication = Mockito.mock(Authentication.class);
        // Mockito.whens() for your authorization object
        SecurityContext securityContext = Mockito.mock(SecurityContext.class);
        Mockito.when(securityContext.getAuthentication()).thenReturn(authentication);
        SecurityContextHolder.setContext(securityContext);


        this.mockMvc.perform(post("/api/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(estimation1)))
                .andExpect(status().isCreated());
    }

    @Test
    @Disabled
    void put() {
    }

    @Test
    @Disabled
    void delete() {
    }

    @Test
    @Disabled
    void listestimation() {
    }

    @Test
    @Disabled
    void getById() {
    }
}