package fr.formation.securityplayground.config;

import fr.formation.securityplayground.dal.entity.User;
import fr.formation.securityplayground.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataSeeder implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DataSeeder(UserRepository userRepository,
                      PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        // On ne crée les utilisateurs que si la base est vide
        if (userRepository.count() == 0) {
            // Création de l'utilisateur standard
            User user = new User();
            user.setUsername("john.doe");
            // Le mot de passe doit être encodé avant d'être sauvegardé !
            user.setPassword(passwordEncoder.encode("pass"));
            user.setRole("ROLE_USER");
            // ... setter d'autres champs si nécessaire
            userRepository.save(user);

            // Création de l'administrateur
            User admin = new User();
            admin.setUsername("jane.smith");
            admin.setPassword(passwordEncoder.encode("pass"));
            admin.setRole("ROLE_ADMIN");
            userRepository.save(admin);

            System.out.println(">>> Utilisateurs de test créés !");

            System.out.println("Test du mot de passe !");
            System.out.println(
                    passwordEncoder.matches("pass", "$2a$10$pa506UuIZFMLxSMTEtgnl.vjjnKPakgqe1fuS5uO1f3eOVzmgqqPG")
            );
        }
    }
}