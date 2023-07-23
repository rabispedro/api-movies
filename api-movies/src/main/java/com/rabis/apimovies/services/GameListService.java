package com.rabis.apimovies.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rabis.apimovies.dtos.GameListDto;
import com.rabis.apimovies.mappers.GameListMapper;
import com.rabis.apimovies.repositories.GameListRepository;
import com.rabis.apimovies.repositories.GameRepository;
import com.rabis.apimovies.projections.GameProjection;

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
	
	@Autowired
	private GameRepository gameRepository;

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
	
	@Transactional
	public void updateGameListPlacement(Long listId, int sourceIndex, int destinationIndex) {
		List<GameProjection> gameList = this.gameRepository.findAllByListId(listId);
		GameProjection game = gameList.remove(sourceIndex);
		gameList.add(destinationIndex, game);
		
		int lowerBound = Math.min(sourceIndex, destinationIndex);
		int upperBound = Math.max(sourceIndex, destinationIndex);
		
		for(int i=lowerBound; i<=upperBound; i++) {
			System.out.print("ListId: " + listId + "\tGameId: " + gameList.get(i).getId() + "\tNewPosition: " + i + "\n");
			this.gameListRepository.updateBelongingPosition(listId, gameList.get(i).getId(), i);
		}
		
		return;
	}
}

