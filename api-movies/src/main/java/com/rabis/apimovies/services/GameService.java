package com.rabis.apimovies.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rabis.apimovies.dtos.GameDetailDto;
import com.rabis.apimovies.dtos.GameDto;
import com.rabis.apimovies.mappers.GameMapper;
import com.rabis.apimovies.repositories.GameRepository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class GameService {
	@Autowired
	private GameRepository gameRepository;
	
	@Autowired
	private GameMapper gameMapper;
	
	@Transactional(readOnly = true)
	public List<GameDto> findAll() {
		var games = this.gameRepository.findAll();

		return games
			.stream()
			.map(game -> this.gameMapper.mapToDto(game))
			.toList();
	}

	@Transactional(readOnly = true)
	public GameDetailDto findById(Long id) {
		var game = this.gameRepository.findById(id);

		return this.gameMapper.mapToDetailDto(game.get());
	}

	@Transactional(readOnly = true)
	public List<GameDto> findAllByListId(Long listId) {
		var games = this.gameRepository.findAllByListId(listId);

		return games
			.stream()
			.map(game -> this.gameMapper.mapToDto(game))
			.toList();
	}
}
