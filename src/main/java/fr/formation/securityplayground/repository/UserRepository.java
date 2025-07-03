package fr.formation.securityplayground.repository;


import fr.formation.securityplayground.dal.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // Nous ajouterons des méthodes personnalisées ici plus tard
}
