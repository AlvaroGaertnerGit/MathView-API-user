package com.MathView.user_api_v1;

import com.MathView.user_api_v1.models.User;
import com.MathView.user_api_v1.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class DatabaseInitializer {

    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        return args -> {
            // Verificar si la base de datos ya tiene usuarios
            if (userRepository.count() == 0) {
                System.out.println("Inicializando la base de datos con usuarios de prueba...");

                // Insertar usuarios de ejemplo
                User user1 = new User("admin", passwordEncoder.encode("admin123"));
                User user2 = new User("user", passwordEncoder.encode("user123"));
                User user3 = new User("user3", passwordEncoder.encode("user3123"));
                User user4 = new User("user4", passwordEncoder.encode("user4123"));

                userRepository.save(user1);
                userRepository.save(user2);
                userRepository.save(user3);
                userRepository.save(user4);

                System.out.println("Usuarios de prueba creados correctamente.");
            } else {
                System.out.println("La base de datos ya contiene usuarios. No se insertarán datos de prueba.");
            }
        };
    }
}
