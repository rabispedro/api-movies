package com.rabis.apimovies.mappers;

import org.springframework.stereotype.Component;

import com.rabis.apimovies.dtos.GameListDto;
import com.rabis.apimovies.entities.GameList;

@Component
public class GameListMapper {
	public GameList mapFromDto(GameListDto gameListDto) {
		return new GameList(
			gameListDto.id(),
			gameListDto.name()
		);
	}

	public GameListDto mapToDto(GameList gameList) {
		return new GameListDto(
			gameList.getId(),
			gameList.getName()
		);
	}
}
