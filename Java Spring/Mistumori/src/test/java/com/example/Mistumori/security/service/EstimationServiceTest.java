package com.example.Mistumori.security.service;

import com.example.Mistumori.Repository.EstimationRepo;
import com.example.Mistumori.model.Estimation;
import com.example.Mistumori.model.User;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class EstimationServiceTest {

    @Mock private EstimationRepo estimationRepo;
    private AutoCloseable autocloseable;
    private EstimationService estimationService;

    @BeforeEach
    void setUp() {
        autocloseable = MockitoAnnotations.openMocks(this);
        estimationService = new EstimationService(estimationRepo);

    }

    @AfterEach
    void tearDown() throws Exception {
        autocloseable.close();
    }

    @Test
    void getEstimation() {
        estimationService.getEstimation(1L);
        verify(estimationRepo).findById(1L);
    }

    @Test
    void saveEstimation() {
        Date date = new Date("10/20/2000");
        User user1 = new User("enzo", "enzo@gmail.com", "blabla");
        Estimation estimation = new Estimation(1L,"nike","chaussures","nike dunk",100,date," ok super", user1);

        estimationService.saveEstimation(estimation);

        ArgumentCaptor<Estimation> estimationArgumentCaptor = ArgumentCaptor.forClass(Estimation.class);
        verify(estimationRepo).save(estimationArgumentCaptor.capture());

        Estimation captureEstimation = estimationArgumentCaptor.getValue();
        assertThat(captureEstimation).isEqualTo(estimation);
    }

    @Test
    void listAllEstimation() {
        estimationService.listAllEstimation();
        verify(estimationRepo).findAll();
    }

    @Test
    void deleteEstimation() {
        estimationService.deleteEstimation(1L);
        verify(estimationRepo).deleteById(1L);
    }
}