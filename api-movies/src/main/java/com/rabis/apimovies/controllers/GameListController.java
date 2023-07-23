package com.rabis.apimovies.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rabis.apimovies.dtos.GameDto;
import com.rabis.apimovies.dtos.GameListDto;
import com.rabis.apimovies.dtos.ReplacementDto;
import com.rabis.apimovies.services.GameListService;
import com.rabis.apimovies.services.GameService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@RestController
@RequestMapping(path = "/api/v1/lists")
@AllArgsConstructor
@NoArgsConstructor
public class GameListController {
	@Autowired
	private GameListService gameListService;

	@Autowired
	private GameService gameService;

	@GetMapping(path = "/{id}")
	public ResponseEntity<GameListDto> findById(@PathVariable Long id) {
		var game = this.gameListService.findById(id);

		return ResponseEntity.ok(game);
	}

	@GetMapping()
	public ResponseEntity<List<GameListDto>> findAll() {
		var games = this.gameListService.findAll();

		return ResponseEntity.ok(games);
	}

	@GetMapping(path = "/{id}/games")
	public ResponseEntity<List<GameDto>> findAllByListId(@PathVariable Long id) {
		var games = this.gameService.findAllByListId(id);

		return ResponseEntity.ok(games);
	}

	@PostMapping(path = "/{id}/placement")
	public void updateGameListPlacement(@PathVariable Long id, @RequestBody ReplacementDto replacementDto) {
		this.gameListService.updateGameListPlacement(id, replacementDto.sourceIndex(), replacementDto.destinationIndex());
		return;
	}
}

