package com.academia.model;

public class Aluno {
	private String nome; 
	private long id;
	
	public Aluno(long id, String nome) {
		super();
		this.nome = nome;
		this.id = id;
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
	

}
