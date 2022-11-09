package com.spotify.project.models;

import javax.persistence.*;

@Entity
@Table(name="artist_song")
public class SongArtist {
    @EmbeddedId
    private SongArtistId id;

    @ManyToOne
    @MapsId("idSong")
    @JoinColumn(name="id_song")
    Song song;

    @ManyToOne
    @MapsId("idArtist")
    @JoinColumn(name="id_artist")
    Artist artist;

    public SongArtistId getId() {
        return id;
    }

    public void setId(SongArtistId id) {
        this.id = id;
    }

    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }
}
