package com.spotify.project.services;

import com.spotify.project.models.Song;
import com.spotify.project.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class SongService {
    @Autowired
    private SongRepository repository;

    public List<Song> getAllSongs() {
        List<Song> songs = repository.findAll();
        if (songs.size() > 0)
            return songs;
        else
            return new ArrayList<>();
    }

    public Song createOrUpdate(Song song) {
        List<Song> songs = getAllSongs();
        for (Song s : songs) {
            if (s.getReleaseDate() == song.getReleaseDate() && s.getDuration() == song.getDuration() && Objects.equals(s.getLanguage(), song.getLanguage())) {
                song.setId(song.getId());
            }
        }
        song = repository.save(song);
        return song;
    }

    public Optional<Song> getSongById(int id) {
        return repository.findById(id);
    }

    public void deleteSongById(int id) {
        repository.deleteById(id);
    }
}
