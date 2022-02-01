package com.academia.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.academia.model.Exercicio;
import com.academia.model.Treino;

@Repository
public interface ExercicioRepository extends CrudRepository<Exercicio, Long>{

	List<Treino> findByTipo(String tipo);
}
