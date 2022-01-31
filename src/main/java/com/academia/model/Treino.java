package com.academia.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="TREINO")
public class Treino {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "NOME_TREINO")
	private String nomeDoTreino;
	
	@Column(name = "TIPO_TREINO")
	private String tipoTreino;
	

	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "id")
	private List<Exercicio> exercicio;
	
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
