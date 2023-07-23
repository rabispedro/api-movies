package com.rabis.apimovies.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rabis.apimovies.entities.Game;
import com.rabis.apimovies.projections.GameProjection;

public interface GameRepository extends JpaRepository<Game, Long> {
	@Query(nativeQuery = true,
		value = """
			SELECT
				tg.id,
				tg.title,
				tg.release_year AS releaseYear,
				tg.image_url AS imageUrl,
				tg.short_description AS shortDescription,
				tg.long_description AS longDescription,
				tb.position
			FROM tbl_game tg  
			INNER JOIN tbl_belonging tb ON tg.id = tb.game_id 
			WHERE tb.list_id = :listId
			ORDER BY tb.position
		"""
	)
	List<GameProjection> findAllByListId(@Param("listId") Long listId);
}
