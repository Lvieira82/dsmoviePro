package com.devsuperior.dsmoviePro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dsmoviePro.entities.Score;
import com.devsuperior.dsmoviePro.entities.ScorePK;

public interface ScoreRepository extends JpaRepository<Score, ScorePK>{

}
