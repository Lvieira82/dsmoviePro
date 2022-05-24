package com.devsuperior.dsmoviePro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dsmoviePro.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>{

}
