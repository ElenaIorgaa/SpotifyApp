package com.spotify.project.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class SongArtistId implements Serializable {
    @Column(name="id_song")
    private int idSong;

    @Column(name="id_artist")
    private int idArtist;

    public int getIdSong() {
        return idSong;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SongArtistId that = (SongArtistId) o;
        return idSong == that.idSong && idArtist == that.idArtist;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSong, idArtist);
    }

    public void setIdSong(int idSong) {
        this.idSong = idSong;
    }

    public int getIdArtist() {
        return idArtist;
    }

    public void setIdArtist(int idArtist) {
        this.idArtist = idArtist;
    }
}
