package com.rabis.apimovies.projections;

public interface GameProjection {
	Long getId();
	String getTitle();
	Integer getReleaseYear();
	String getImageUrl();
	String getShortDescription();
	String getLongDescription();
	Integer getPosition();
}
