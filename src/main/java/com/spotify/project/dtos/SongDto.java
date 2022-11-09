package com.spotify.project.dtos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.spotify.project.controllers.ArtistController;
import com.spotify.project.controllers.SongController;
import com.sun.istack.NotNull;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.Id;
import java.util.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Data
public class SongDto extends RepresentationModel<SongDto> {
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
    private List<String> artists;

    @JsonCreator
    public SongDto(@JsonProperty("id") int id, @JsonProperty("title") String title,
                   @JsonProperty("duration") int duration, @JsonProperty("language") String language,
                   @JsonProperty("releaseDate") Date releaseDate, @JsonProperty("artists") List<String> artists) {
        this.title = title;
        this.duration = duration;
        this.id = id;
        this.language = language;
        this.releaseDate = releaseDate;
        this.artists = artists;
        add(linkTo(methodOn(SongController.class).getAllSongs()).withSelfRel());
        add(linkTo(methodOn(ArtistController.class).getAllArtists()).withRel("artists"));
    }

    public List<String> getArtists() {
        return artists;
    }

    public void setArtists(List<String> artists) {
        this.artists = artists;
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
