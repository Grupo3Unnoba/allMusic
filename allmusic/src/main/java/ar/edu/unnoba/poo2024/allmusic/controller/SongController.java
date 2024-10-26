package ar.edu.unnoba.poo2024.allmusic.controller;

import ar.edu.unnoba.poo2024.allmusic.model.Song;
import ar.edu.unnoba.poo2024.allmusic.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/songs")
public class SongController {

    @Autowired
    private SongRepository songRepository;

    @PostMapping
    public Song createSong(@RequestBody Song song) {
        // Verificar si el creador puede crear canciones
        if (!song.getCreator().canCreateSongs()) {
            throw new RuntimeException("El usuario no tiene permisos para crear canciones.");
        }
        return songRepository.save(song);
    }

    @GetMapping
    public List<Song> getAllSongs() {
        return songRepository.findAll();
    }
}

