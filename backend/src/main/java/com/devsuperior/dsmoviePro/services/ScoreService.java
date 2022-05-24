package com.devsuperior.dsmoviePro.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsmoviePro.dtp.MovieDTO;
import com.devsuperior.dsmoviePro.dtp.ScoreDTO;
import com.devsuperior.dsmoviePro.entities.Movie;
import com.devsuperior.dsmoviePro.entities.Score;
import com.devsuperior.dsmoviePro.entities.Users;
import com.devsuperior.dsmoviePro.repositories.MovieRepository;
import com.devsuperior.dsmoviePro.repositories.ScoreRepository;
import com.devsuperior.dsmoviePro.repositories.UserRepository;

@Service
public class ScoreService {
	
	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ScoreRepository scoreRepository;
	
	@Transactional
	public MovieDTO saveScore(ScoreDTO dto) {	

		Users user = userRepository.findByEmail(dto.getEmail());
		if(user == null) {
			user = new Users();
			user.setEmail(dto.getEmail());
			user = userRepository.saveAndFlush(user);
		}
		
		Movie movie = movieRepository.findById(dto.getMovieId()).get();
		
		Score score = new Score();
		score.setMovie(movie);
		score.setUsers(user);
		score.setValue(dto.getScore());
		
		score = scoreRepository.saveAndFlush(score);
		double sum = 0.0;
		for (Score s:movie.getScores()) {
			sum = sum + s.getValue();
		}
		
		double avg = sum / movie.getScores().size();
		movie.setScore(avg);
		movie.setCount(movie.getScores().size());
		movie = movieRepository.save(movie);
		
		return new MovieDTO(movie);
	}
}