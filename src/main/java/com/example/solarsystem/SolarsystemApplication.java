// package com.example.solarsystem;
// import org.springframework.boot.SpringApplication;
// import org.springframework.boot.autoconfigure.SpringBootApplication;


// @SpringBootApplication
// public class SolarsystemApplication {
//     @Autowired
//     private UserService userService;

//     @PostConstruct
//     public void initializeAdminUser() {
//         if (!userRepository.existsByUsername("admin")) {
//             userService.registerUser("admin", "admin@example.com", "adminpassword", true);
//         }
//     }

//     public static void main(String[] args) {
//         SpringApplication.run(SolarsystemApplication.class, args);
//     }
// }



package com.example.solarsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class SolarsystemApplication {
	public static void main(String[] args) {
		SpringApplication.run(SolarsystemApplication.class, args);
	}
}