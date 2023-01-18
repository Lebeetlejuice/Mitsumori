package com.example.Mistumori.Api;

import com.example.Mistumori.Repository.EstimationRepo;
import com.example.Mistumori.api.EstimationController;
import com.example.Mistumori.model.Estimation;
import com.example.Mistumori.model.User;
import com.example.Mistumori.security.service.EstimationService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import java.util.Date;
import java.util.Optional;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@AutoConfigureMockMvc(addFilters = false)
@WebMvcTest(EstimationControllerTest.class)
public class EstimationControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private EstimationRepo estimationRepo;

    @Autowired
    private ObjectMapper objectMapper;
   /* @Test
    void shouldCreateEstimation() throws Exception {
        Date date1 = new Date("25/02/2000");
        User user1 = new User("enzo","fazazf@gmail.com", "enzo");
        Estimation estimation = new Estimation(1L, "leonard de vinci", "art", "joconde", 1500, date1, "azfazfaz", user1);

        mockMvc.perform(post("api/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(estimation)))
                .andExpect(status().isCreated())
                .andDo(print());
    }*/

    @Test
    void shouldReturnNotFoundTutorial2() throws Exception {
        mvc.perform(post("/api/products/post")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
    @Test
    void shouldReturnNotFoundTutorial() throws Exception {
        long id = 134L;

        when(estimationRepo.findById(id)).thenReturn(Optional.empty());
        mvc.perform(get("/api/products/mod/{id}",id))
                .andExpect(status().isNotFound())
                .andDo(print());
    }

}
