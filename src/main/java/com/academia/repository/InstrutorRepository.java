package com.academia.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.academia.model.Instrutor;

@Repository
public interface InstrutorRepository extends CrudRepository<Instrutor, Long>{

}
