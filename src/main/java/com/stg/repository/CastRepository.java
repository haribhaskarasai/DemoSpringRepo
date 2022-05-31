package com.stg.repository;

import org.springframework.data.jpa.repository.JpaRepository;



import org.springframework.stereotype.Repository;

import com.stg.entity.Cast;
import com.stg.entity.Movie;
@Repository
public interface CastRepository extends JpaRepository<Cast, Integer>{
	public Cast findByActorId(int actorId);
}
