package com.rabis.apimovies.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_game")
public class Game {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "release_year")
	private Integer year;
	
	@Column(name = "genre")
	private String genre;
	
	@Column(name = "platforms")
	private String platforms;

	@Column(name = "score")
	private Double score;

	@Column(name = "image_url")
	private String imageUrl;

	@Column(name = "short_description", columnDefinition = "TEXT")
	private String shortDescription;

	@Column(name = "long_description", columnDefinition = "TEXT")
	private String longDescription;
}
