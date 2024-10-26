package ar.edu.unnoba.poo2024.allmusic.repository;

import ar.edu.unnoba.poo2024.allmusic.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song, Long> {
    // Aquí puedes definir métodos personalizados, como:
    // List<Song> findByGenre(Genre genre);
}

