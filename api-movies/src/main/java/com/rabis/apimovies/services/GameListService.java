package com.rabis.apimovies.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rabis.apimovies.dtos.GameListDto;
import com.rabis.apimovies.mappers.GameListMapper;
import com.rabis.apimovies.repositories.GameListRepository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class GameListService {
	@Autowired
	private GameListMapper gameListMapper;
	
	@Autowired
	private GameListRepository gameListRepository;

	@Transactional(readOnly = true)
	public GameListDto findById(Long id) {
		var gameList = this.gameListRepository.findById(id);

		return this.gameListMapper.mapToDto(gameList.get());
	}
	
	@Transactional(readOnly = true)
	public List<GameListDto> findAll() {
		var gameLists = this.gameListRepository.findAll();

		return gameLists
			.stream()
			.map(gameList -> this.gameListMapper.mapToDto(gameList))
			.toList();
	}
}
