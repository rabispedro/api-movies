package com.rabis.apimovies.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Modifying;

import com.rabis.apimovies.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long>{
	@Modifying
	@Query(nativeQuery = true,
		value = """
			UPDATE tbl_belonging
			SET position = :newPosition
			WHERE
				list_id = :listId
				AND game_id = :gameId;
		"""
	)
	void updateBelongingPosition(@Param("listId") Long listId, @Param("gameId") Long gameId, @Param("newPosition") Integer newPosition);
}

