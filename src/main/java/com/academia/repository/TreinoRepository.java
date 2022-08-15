package com.academia.repository;

import com.academia.model.Treino;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TreinoRepository extends CrudRepository<Treino, Long>{

	List<Treino> findByTipoTreino(int tipo);
}
