package com.rabis.apimovies.dtos;


public record GameDto(
	Long id,
	String title,
	Integer year,
	String imageUrl,
	String shortDescription
) {

}
