package com.spotify.project.repository;

import com.spotify.project.models.SongArtist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongArtistRepository extends JpaRepository<SongArtist, Integer> {
}