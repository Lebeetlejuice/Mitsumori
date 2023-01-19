package com.example.Mistumori;


import com.example.Mistumori.Repository.EstimationRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

public class TestUnit {
    class Calculator {
        int add(int a, int b) {
            return a + b;
        }
    }

    @Autowired
    EstimationRepo estimationRepo;

    Calculator underTest = new Calculator();
    @Test
    public void should_find_50() {
        int number1 = 20;
        int number2 = 30;

        int result = underTest.add(number1,number2);

        assertThat(result).isEqualTo(50);
    }
}