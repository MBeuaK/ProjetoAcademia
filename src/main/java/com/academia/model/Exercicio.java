package com.academia.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="exercicio")
public class Exercicio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "nome_exercicio")
	private String nomeDoExercicio;
	
	@Column(name = "numero_de_repeticoes")
	private int numeroDeRepeticoes;

	public Exercicio(int id, String nomeDoExercicio, int numeroDeRepeticoes) {
		this.id = id;
		this.nomeDoExercicio = nomeDoExercicio;
		this.numeroDeRepeticoes = numeroDeRepeticoes;
	}

	public Exercicio() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeDoExercicio() {
		return nomeDoExercicio;
	}

	public void setNomeDoExercicio(String nomeDoExercicio) {
		this.nomeDoExercicio = nomeDoExercicio;
	}

	public int getNumeroDeRepeticoes() {
		return numeroDeRepeticoes;
	}

	public void setNumeroDeRepeticoes(int numeroDeRepeticoes) {
		this.numeroDeRepeticoes = numeroDeRepeticoes;
	}
	
	
	
	

	
}
