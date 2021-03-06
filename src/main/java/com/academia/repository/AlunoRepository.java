package com.academia.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.academia.model.Aluno;

@Repository
public interface AlunoRepository extends CrudRepository<Aluno, Long>{

}
