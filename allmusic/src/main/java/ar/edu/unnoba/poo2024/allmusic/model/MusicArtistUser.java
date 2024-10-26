package ar.edu.unnoba.poo2024.allmusic.model;

import jakarta.persistence.Entity;

@Entity
public class MusicArtistUser extends User {

    @Override
    public boolean canCreateSongs() {
        return true;
    }
}
