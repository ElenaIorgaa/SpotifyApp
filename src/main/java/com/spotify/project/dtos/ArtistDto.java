package com.spotify.project.dtos;

import com.spotify.project.models.Song;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class ArtistDto {
    private int id;
    private String name;
    private String nationality;
    private Date birthDate;
    private List<Song> songs = new ArrayList<>();

    public ArtistDto(int id, String name, String nationality, Date birthDate, List<Song> songs) {
        this.id = id;
        this.name = Objects.requireNonNull(name);
        this.nationality = Objects.requireNonNull(nationality);
        this.birthDate = Objects.requireNonNull(birthDate);
        this.songs = songs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }
}
