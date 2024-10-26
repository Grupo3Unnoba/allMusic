package ar.edu.unnoba.poo2024.allmusic.repository;

import ar.edu.unnoba.poo2024.allmusic.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    //Optional<User> findByUsername(String username);
}
