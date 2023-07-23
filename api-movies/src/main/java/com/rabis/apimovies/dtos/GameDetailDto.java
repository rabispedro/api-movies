package com.rabis.apimovies.dtos;


public record GameDetailDto(
	Long id,
	String title,
	Integer year,
	String genre,
	String platforms,
	Double score,
	String imageUrl,
	String shortDescription,
	String longDescription
) {
	
}
