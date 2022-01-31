package service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.academia.model.Aluno;

import repository.AlunoRepository;

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
