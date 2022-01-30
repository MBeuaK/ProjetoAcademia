package com.academia.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class AlunoService {
	
	public List<Aluno> getAlunos(){
		List<Aluno> alunos = new ArrayList<>();
		
		alunos.add(new Aluno(1L, "Jorge"));
		alunos.add(new Aluno(2L, "Pedro"));
		alunos.add(new Aluno(3L, "Paulo"));
		
		
		return alunos;
	}

}
