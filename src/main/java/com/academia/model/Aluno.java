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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ALUNO")
public class Aluno {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "NOME")
	private String nome; 

	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "id")
	private List<Treino> treino;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id")
	private Instrutor instrutor;

	
	
	public Aluno(long id, String nome, Instrutor instrutor) {
		this.id = id;
		this.nome = nome;
		this.instrutor = instrutor;
	}


	public Aluno() {
	}


	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public Instrutor getInstrutor() {
		return instrutor;
	}

	public void setInstrutor(Instrutor instrutor) {
		this.instrutor = instrutor;
	}
	
	
	

}
