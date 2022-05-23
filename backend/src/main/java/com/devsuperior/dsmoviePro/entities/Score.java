package com.devsuperior.dsmoviePro.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_score")
public class Score {
	
	@EmbeddedId
	private ScorePK id = new ScorePK();
	//private Movie movie; por ter duas chaves primárias não é posive a associação entre os usuarios 
	//private Users user;e os filmes. Daí será criada uma classe que reacione os dois. A ScorePK
	private Double value;
	
	public Score() {
	}
	public void setMovie(Movie movie) {
		id.setMovie(movie);//filme escolhido para ser avaliado, que vem do ScorePK.
	}
	public void setUsers(Users user) {
		id.setUser(user);
	}

	public ScorePK getId() {
		return id;
	}

	public void setId(ScorePK id) {
		this.id = id;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}
	

}
