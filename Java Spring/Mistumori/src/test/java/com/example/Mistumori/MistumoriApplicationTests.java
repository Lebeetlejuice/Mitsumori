package com.example.Mistumori;


import com.example.Mistumori.Api.EstimationControllerTest;
import com.example.Mistumori.api.EstimationController;
import org.junit.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@AutoConfigureMockMvc
@SpringBootTest(classes = EstimationControllerTest.class)
class MistumoriApplicationTests {

	@Test
	void contextLoads() {
	}

}
