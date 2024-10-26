package ar.edu.unnoba.poo2024.allmusic.controller;

import ar.edu.unnoba.poo2024.allmusic.model.Playlist;
import ar.edu.unnoba.poo2024.allmusic.model.User;
import ar.edu.unnoba.poo2024.allmusic.repository.PlaylistRepository;
import ar.edu.unnoba.poo2024.allmusic.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/playlists")
public class PlaylistController {

    @Autowired
    private PlaylistRepository playlistRepository;

    @Autowired
    private UserRepository userRepository;

    // Crear una nueva playlist
    @PostMapping
    public ResponseEntity<Playlist> createPlaylist(@RequestBody Playlist playlist, @RequestParam Long userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            playlist.setUser(user.get());
            Playlist savedPlaylist = playlistRepository.save(playlist);
            return ResponseEntity.ok(savedPlaylist);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Obtener todas las playlists
    @GetMapping
    public List<Playlist> getAllPlaylists() {
        return playlistRepository.findAll();
    }

    // Obtener una playlist por ID
    @GetMapping("/{id}")
    public ResponseEntity<Playlist> getPlaylistById(@PathVariable Long id) {
        Optional<Playlist> playlist = playlistRepository.findById(id);
        return playlist.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Actualizar una playlist existente
    @PutMapping("/{id}")
    public ResponseEntity<Playlist> updatePlaylist(@PathVariable Long id, @RequestBody Playlist playlistDetails, @RequestParam Long userId) {
        Optional<Playlist> playlistOptional = playlistRepository.findById(id);
        Optional<User> user = userRepository.findById(userId);

        if (playlistOptional.isPresent() && user.isPresent() && playlistOptional.get().getUser().equals(user.get())) {
            Playlist playlist = playlistOptional.get();
            playlist.setName(playlistDetails.getName());
            Playlist updatedPlaylist = playlistRepository.save(playlist);
            return ResponseEntity.ok(updatedPlaylist);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar una playlist por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlaylist(@PathVariable Long id, @RequestParam Long userId) {
        Optional<Playlist> playlist = playlistRepository.findById(id);
        Optional<User> user = userRepository.findById(userId);

        if (playlist.isPresent() && user.isPresent() && playlist.get().getUser().equals(user.get())) {
            playlistRepository.delete(playlist.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

