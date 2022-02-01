package com.academia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.academia.model.Treino;
import com.academia.repository.TreinoRepository;

@Service
public class TreinoService {
	
	@Autowired
	private TreinoRepository treinoRepository;
	
	public Iterable<Treino> getTreino(){
		return treinoRepository.findAll();

	}
	
	public List<Treino> getTreinoByTipo(String tipo){
		return treinoRepository.findByTipo(tipo);
	}

	public Optional<Treino> getTreinoById(Long id) {
		return treinoRepository.findById(id);
	}

	public Treino insert(Treino treino) {
		return treinoRepository.save(treino);
	}

	public Treino update(Treino treino, Long id) {
		Assert.notNull(id, "Não foi possivel atualizar o registro do treino");
		
		//Busca o treino no banco de dados
		Optional<Treino> optional = getTreinoById(id);
		if(optional.isPresent()) {
			Treino db=optional.get();
			//Copia as propriedades
			db.setId(treino.getId());
			db.setNomeDoTreino(treino.getNomeDoTreino());
			System.out.println("Treino id: " + db.getId());
			
			//Atualiza o treino
			treinoRepository.save(db);
			return db;
		} else {
			throw new RuntimeException("Não foi possivel atualizar o registro do treino");
		}
	}
	
	public void delete(Long id) {
		Optional<Treino> treino = getTreinoById(id);
			if(treino.isPresent()) {
				treinoRepository.deleteById(id);
			}
	}
	

}
