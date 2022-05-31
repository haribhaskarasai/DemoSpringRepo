package com.stg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stg.entity.Crew;
@Repository
public interface CrewRepository  extends JpaRepository<Crew, Integer>{
	public Crew findByTechName(String techName);
}
