package com.example.Mistumori;

import com.example.Mistumori.model.Role;
import com.example.Mistumori.model.User;
import com.example.Mistumori.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class MistumoriApplication {

	public static void main(String[] args) {
		SpringApplication.run(MistumoriApplication.class, args);
	}


	/*@Bean
	PasswordEncoder passwordEncoder()
	*/
	@Bean
	CommandLineRunner run(UserService userService){
		return args -> {

		};
	}
}

								