package com.academia.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.academia.model.Treino;

@Repository
public interface TreinoRepository extends CrudRepository<Treino, Long>{

	List<Treino> findByTipo(String tipo);
}
