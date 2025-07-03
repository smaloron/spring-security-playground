package fr.formation.securityplayground.repository;


import fr.formation.securityplayground.dal.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Nous ajouterons des méthodes personnalisées ici plus tard

    Optional<UserDetails> findByUsername(String username);
}
