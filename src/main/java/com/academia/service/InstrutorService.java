package com.academia.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.academia.model.Instrutor;
import com.academia.repository.InstrutorRepository;

@Service
public class InstrutorService {
	
	@Autowired
	private InstrutorRepository instrutorRepository;
	
	public Iterable<Instrutor> getInstrutor(){
		return instrutorRepository.findAll();

	}

	public Optional<Instrutor> getInstrutorById(Long id) {
		return instrutorRepository.findById(id);
	}

	public Instrutor insert(Instrutor instrutor) {
		return instrutorRepository.save(instrutor);
	}

	public Instrutor update(Instrutor instrutor, Long id) {
		Assert.notNull(id, "Não foi possivel atualizar o registro do instrutor");
		
		//Busca o instrutor no banco de dados
		Optional<Instrutor> optional = getInstrutorById(id);
		if(optional.isPresent()) {
			Instrutor db=optional.get();
			//Copia as propriedades
			db.setId(instrutor.getId());
			db.setNome(instrutor.getNome());
			System.out.println("instrutor id: " + db.getId());
			
			//Atualiza o instrutor
			instrutorRepository.save(db);
			return db;
		} else {
			throw new RuntimeException("Não foi possivel atualizar o registro do instrutor");
		}
	}
	
	public void delete(Long id) {
		Optional<Instrutor> instrutor = getInstrutorById(id);
			if(instrutor.isPresent()) {
				instrutorRepository.deleteById(id);
			}
	}



}
