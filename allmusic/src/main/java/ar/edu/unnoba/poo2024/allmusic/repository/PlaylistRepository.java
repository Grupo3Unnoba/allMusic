package ar.edu.unnoba.poo2024.allmusic.repository;

import ar.edu.unnoba.poo2024.allmusic.model.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaylistRepository extends JpaRepository<Playlist, Long> {
    // métodos personalizados para búsquedas específicas:
    // List<Playlist> findByUserId(Long userId);
}

