package com.academia.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.academia.model.Exercicio;
import com.academia.repository.ExercicioRepository;

@Service
public class ExercicioService {
	
	@Autowired
	private ExercicioRepository exercicioRepository;
	
	public Iterable<Exercicio> getExercicio(){
		return exercicioRepository.findAll();

	}

	public Optional<Exercicio> getExercicioById(Long id) {
		return exercicioRepository.findById(id);
	}

	public Exercicio insert(Exercicio exercicio) {
		return exercicioRepository.save(exercicio);
	}

	public Exercicio update(Exercicio exercicio, Long id) {
		Assert.notNull(id, "Não foi possivel atualizar o registro do exercicio");
		
		//Busca o exercicio no banco de dados
		Optional<Exercicio> optional = getExercicioById(id);
		if(optional.isPresent()) {
			Exercicio db=optional.get();
			//Copia as propriedades
			db.setId(exercicio.getId());
			db.setNomeDoExercicio(exercicio.getNomeDoExercicio());
			System.out.println("Aluno id: " + db.getId());
			
			//Atualiza o exercicio
			exercicioRepository.save(db);
			return db;
		} else {
			throw new RuntimeException("Não foi possivel atualizar o registro do exercicio");
		}
	}
	
	public void delete(Long id) {
		Optional<Exercicio> exercicio = getExercicioById(id);
			if(exercicio.isPresent()) {
				exercicioRepository.deleteById(id);
			}
	}
	

}
