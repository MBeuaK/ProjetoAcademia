package com.academia.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="treino")
public class Treino {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "nome_treino")
	private String nomeDoTreino;
	
	@Column(name = "tipo_treino")
	private String tipoTreino;

	
	
	public Treino(int id, String nomeDoTreino, String tipoTreino) {
		this.id = id;
		this.nomeDoTreino = nomeDoTreino;
		this.tipoTreino = tipoTreino;
	}
	

	public Treino() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeDoTreino() {
		return nomeDoTreino;
	}

	public void setNomeDoTreino(String nomeDoTreino) {
		this.nomeDoTreino = nomeDoTreino;
	}

	public String getTipoTreino() {
		return tipoTreino;
	}

	public void setTipoTreino(String tipoTreino) {
		this.tipoTreino = tipoTreino;
	}
	
	

}
