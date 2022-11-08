package com.spotify.project.dtos;

import com.spotify.project.models.Artist;

import java.util.Date;
import java.util.Objects;

public class SongDto {
    private int id;
    private String title;
    private int duration;
    private String language;
    private Date releaseDate;
    private Artist artist;

    public SongDto(int id, String title, int duration, String language, Date releaseDate, Artist artist) {
        this.id = id;
        this.title = Objects.requireNonNull(title);
        this.duration = duration;
        this.language = Objects.requireNonNull(language);
        this.releaseDate = Objects.requireNonNull(releaseDate);
        this.artist = Objects.requireNonNull(artist);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }
}
