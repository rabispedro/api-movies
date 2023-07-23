package com.rabis.apimovies.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rabis.apimovies.dtos.GameDetailDto;
import com.rabis.apimovies.dtos.GameDto;
import com.rabis.apimovies.services.GameService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@RestController
@RequestMapping(path = "/api/v1/games")
@AllArgsConstructor
@NoArgsConstructor
public class GameController {
	@Autowired
	private GameService gameService;

	@GetMapping(path = "/{id}")
	public ResponseEntity<GameDetailDto> findById(@PathVariable Long id) {
		var game = this.gameService.findById(id);

		return ResponseEntity.ok(game);
	}
	
	@GetMapping("")
	public ResponseEntity<List<GameDto>> findAll() {
		var games = this.gameService.findAll();

		return ResponseEntity.ok(games);
	}
}
