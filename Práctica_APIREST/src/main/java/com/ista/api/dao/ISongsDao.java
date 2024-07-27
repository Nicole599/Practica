package com.ista.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ista.api.entity.Songs;

public interface ISongsDao extends JpaRepository<Songs, Long> {

}
