package com.rabis.apimovies.mappers;

import org.springframework.stereotype.Component;

import com.rabis.apimovies.dtos.GameDetailDto;
import com.rabis.apimovies.dtos.GameDto;
import com.rabis.apimovies.entities.Game;
import com.rabis.apimovies.projections.GameProjection;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class GameMapper {
	public Game mapFromDto(GameDto gameDto) {
		return new Game(
			gameDto.id(),
			gameDto.title(),
			gameDto.year(),
			null,
			null,
			null,
			gameDto.imageUrl(),
			gameDto.shortDescription(),
			null
		);
	}

	public Game mapFromDto(GameDetailDto gameDetailDto) {
		return new Game(
			gameDetailDto.id(),
			gameDetailDto.title(),
			gameDetailDto.year(),
			gameDetailDto.genre(),
			gameDetailDto.platforms(),
			gameDetailDto.score(),
			gameDetailDto.imageUrl(),
			gameDetailDto.shortDescription(),
			gameDetailDto.longDescription()
		);
	}


	public GameDto mapToDto(Game game) {
		return new GameDto(
			game.getId(),
			game.getTitle(),
			game.getYear(),
			game.getImageUrl(),
			game.getShortDescription()
		);
	}

	public GameDto mapToDto(GameProjection gameProjection) {
		return new GameDto(
			gameProjection.getId(),
			gameProjection.getTitle(),
			gameProjection.getReleaseYear(),
			gameProjection.getImageUrl(),
			gameProjection.getShortDescription()
		);
	}

	public GameDetailDto mapToDetailDto(Game game) {
		return new GameDetailDto(
			game.getId(),
			game.getTitle(),
			game.getYear(),
			game.getGenre(),
			game.getPlatforms(),
			game.getScore(),
			game.getImageUrl(),
			game.getShortDescription(),
			game.getLongDescription()
		);
	}
}
