package com.ista.api.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ista.api.entity.Playlist;

public interface IPlaylistDao extends JpaRepository<Playlist, Long> {
    Optional<Playlist> findByName(String name);

}
