package com.rabis.apimovies.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rabis.apimovies.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long>{
	
}
