package io.github.seebaware.lemon;

import io.github.seebaware.lemon.domain.Role;
import io.github.seebaware.lemon.domain.User;
import io.github.seebaware.lemon.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class LemonApplication {

	public static void main(String[] args) {
		SpringApplication.run(LemonApplication.class, args);
	}


	@Bean
	PasswordEncoder passwordEncoder () {
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(UserService userService) {
		return args -> {

			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

			userService.saveUser(new User(null, "Jo Travo", "jo", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "Ja Smith", "ja", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "Ji Carry", "ji", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "Ju Schwazi", "ju", "juju", new ArrayList<>()));

			userService.addRoleToUser("jo","ROLE_USER");
			userService.addRoleToUser("ja","ROLE_MANAGER");
			userService.addRoleToUser("ji","ROLE_ADMIN");
			userService.addRoleToUser("ju","ROLE_SUPER_ADMIN");
			userService.addRoleToUser("ju","ROLE_ADMIN");
			userService.addRoleToUser("ju","ROLE_USER");

		};
	}

}
