package com.stg.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int mvId;
	@Column(name = "moviename", length = 20)
	private String mvName;

	private String mvGener;

	private float mvRating;
 
	private LocalDate releaseDate;

	// @JsonManagedReference
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "movie_actor", joinColumns = {
			@JoinColumn(name = "movie_Id", referencedColumnName = "mvId", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "actor_Id", referencedColumnName = "actorId", nullable = false, updatable = false), })
	private List<Cast> actors = new ArrayList<Cast>();

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "movie_tech", joinColumns = {
			@JoinColumn(name = "movie_Id", referencedColumnName = "mvId", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "tech_Id", referencedColumnName = "techId", nullable = false, updatable = false), })
	private List<Crew> crews = new ArrayList<Crew>();

	public Movie() {
		super();
	}

	public Movie(int mvId, String mvName, float mvRating, String mvGener, LocalDate releaseDate, List<Cast> actors,
			List<Crew> crews) {
		super();
		this.mvId = mvId;
		this.mvName = mvName;
		this.mvGener = mvGener;
		this.releaseDate = releaseDate;
		this.actors = actors;
		this.mvRating = mvRating;
		this.crews = crews;
	}

	public int getMvId() {
		return mvId;
	}

	public void setMvId(int mvId) {
		this.mvId = mvId;
	}

	public String getMvName() {
		return mvName;
	}

	public void setMvName(String mvName) {
		this.mvName = mvName;
	}

	public String getMvGener() {
		return mvGener;
	}

	public void setMvGener(String mvGener) {
		this.mvGener = mvGener;
	}

	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}

	public List<Cast> getActors() {
		return actors;
	}

	public void setActors(List<Cast> actors) {
		this.actors = actors;
	}

	public float getMvRating() {
		return mvRating;
	}

	public void setMvRating(float mvRating) {
		this.mvRating = mvRating;
	}

	public List<Crew> getCrews() {
		return crews;
	}

	public void setCrews(List<Crew> crews) {
		this.crews = crews;
	}

}
