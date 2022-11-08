package com.spotify.project.models;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

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
    private String languange;

    @Column(name = "release_date")
    private Date releaseDate;

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
        return duration == song.duration && Objects.equals(id, song.id) && Objects.equals(title, song.title) && Objects.equals(languange, song.languange) && Objects.equals(releaseDate, song.releaseDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, duration, languange, releaseDate);
    }

    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", duration=" + duration +
                ", languange='" + languange + '\'' +
                ", releaseDate=" + releaseDate +
                '}';
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getLanguange() {
        return languange;
    }

    public void setLanguange(String languange) {
        this.languange = languange;
    }




}
