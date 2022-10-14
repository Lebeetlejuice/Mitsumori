package com.example.Mistumori;

import com.example.Mistumori.model.Role;
import com.example.Mistumori.model.User;
import com.example.Mistumori.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MistumoriApplication {

	public static void main(String[] args) {
		SpringApplication.run(MistumoriApplication.class, args);
	}


	@Bean
	CommandLineRunner run(UserService userService){
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_EXPERT"));
			userService.saveRole(new Role(null, "ROLE_SUPERADMIN"));

			userService.saveUser(new User( null,"enzo", "MAFFEI", "012345"));

			userService.addRoleToUser("MAFFEI", "ROLE_ADMIN");
		};
	}
}

								