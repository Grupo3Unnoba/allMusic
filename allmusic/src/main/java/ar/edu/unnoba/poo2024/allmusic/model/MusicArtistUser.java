package ar.edu.unnoba.poo2024.allmusic.model;

import jakarta.persistence.Entity;

@Entity
public class MusicArtistUser extends User {
    private String artistName;

    @Override
    public boolean canCreateSongs() {
        return true;
    }
    public String getArtistName() {
        return artistName;
}
