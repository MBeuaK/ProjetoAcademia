package com.academia.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlunoService {
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	public Iterable<Aluno> getAlunos(){
		return alunoRepository.findAll();

	}

	public Optional<Aluno> getAlunosById(Long id) {
		return alunoRepository.findById(id);
	}

	public Aluno save(Aluno aluno) {
		return alunoRepository.save(aluno);
	}

}
