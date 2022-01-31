package com.academia.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.academia.model.Aluno;
import com.academia.repository.AlunoRepository;

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

	public Aluno insert(Aluno aluno) {
		return alunoRepository.save(aluno);
	}

	public Aluno update(Aluno aluno, Long id) {
		Assert.notNull(id, "Não foi possivel atualizar o registro do aluno");
		
		//Busca o aluno no banco de dados
		Optional<Aluno> optional = getAlunosById(id);
		if(optional.isPresent()) {
			Aluno db=optional.get();
			//Copia as propriedades
			db.setId(aluno.getId());
			db.setNome(aluno.getNome());
			System.out.println("Aluno id: " + db.getId());
			
			//Atualiza o aluno
			alunoRepository.save(db);
			return db;
		} else {
			throw new RuntimeException("Não foi possivel atualizar o registro do aluno");
		}
	}
	
	public void delete(Long id) {
		Optional<Aluno> aluno = getAlunosById(id);
			if(aluno.isPresent()) {
				alunoRepository.deleteById(id);
			}
	}
	

}
