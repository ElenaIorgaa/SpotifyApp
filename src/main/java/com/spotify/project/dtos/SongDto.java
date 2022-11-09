package com.spotify.project.dtos;

import com.spotify.project.models.Artist;
import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.Id;
import java.util.*;

//@Data
@Data
public class SongDto {
    @Id
    @NotNull
    private int id;
    @NotNull
    private String title;
    @NotNull
    private int duration;
    @NotNull
    private String language;
    @NotNull
    private Date releaseDate;

    @NotNull
    //private Set<Artist> artist;
    private List<Artist> artists;

    public List<Artist> getArtists() {
        return artists;
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }

    public SongDto() {
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


}
