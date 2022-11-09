package com.spotify.project.models;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="songs")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "duration", nullable = false)
    private int duration;

    @Column(name = "language", nullable = false)
    private String language;

    @Column(name = "release_date")
    private Date releaseDate;

    @ManyToMany(fetch=FetchType.LAZY,
            cascade={
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })

    @JoinTable(name="artist_song",
            joinColumns = {@JoinColumn(name="id_song")},
            inverseJoinColumns = {@JoinColumn(name="id_artist")})
    private List<Artist> artists;
    public List<Artist> getArtists() {
        return artists;
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }


    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;
        return duration == song.duration && Objects.equals(id, song.id) && Objects.equals(title, song.title) && Objects.equals(language, song.language) && Objects.equals(releaseDate, song.releaseDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, duration, language, releaseDate);
    }

    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", duration=" + duration +
                ", languange='" + language + '\'' +
                ", releaseDate=" + releaseDate +
                '}';
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String languange) {
        this.language = languange;
    }




}
