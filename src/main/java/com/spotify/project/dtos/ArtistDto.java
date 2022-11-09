package com.spotify.project.dtos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.spotify.project.controllers.ArtistController;
import com.spotify.project.controllers.SongController;
import com.sun.istack.NotNull;
import lombok.Data;
import net.minidev.json.annotate.JsonIgnore;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.Id;
import java.util.Date;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Data
public class ArtistDto extends RepresentationModel<ArtistDto> {
    @Id
    @NotNull
    private int id;
    @NotNull
    private String name;
    @NotNull
    private String nationality;

    @NotNull
    private Date birthDate;
    @NotNull
    @JsonIgnore
    private List<String> songs;

    public List<String> getSongs() {
        return songs;
    }

    public void setSongs(List<String> songs) {
        this.songs = songs;
    }

    @JsonCreator
    public ArtistDto(@JsonProperty("id") int id, @JsonProperty("name") String name,
                     @JsonProperty("nationality") String nationality, @JsonProperty("birthDate") Date birthDate,
                     @JsonProperty("songs") List<String> songs) {
        this.id = id;
        this.name = name;
        this.nationality = nationality;
        this.birthDate = birthDate;
        this.songs = songs;
        add(linkTo(methodOn(ArtistController.class).getAllArtists()).withSelfRel());
        add(linkTo(methodOn(SongController.class).getAllSongs()).withRel("songs"));
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
}
