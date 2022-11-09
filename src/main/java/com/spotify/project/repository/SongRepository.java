package com.spotify.project.repository;

import com.spotify.project.models.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepository extends JpaRepository<Song,Integer> {
   // List<Song> findSongByArtistId(int songId);
}
