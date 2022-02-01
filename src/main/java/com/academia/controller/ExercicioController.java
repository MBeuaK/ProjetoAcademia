package com.academia.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.academia.model.Exercicio;
import com.academia.service.ExercicioService;

@RestController
@RequestMapping("/api/v1/exercicios")
public class ExercicioController {
	@Autowired
	private ExercicioService exercicioService;
	
	@GetMapping
	public ResponseEntity<Iterable<Exercicio>> get() {
		return ResponseEntity.ok(exercicioService.getExercicio());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Exercicio> get(@PathVariable("id") Long id) {
		Optional<Exercicio> exercicio = exercicioService.getExercicioById(id);
		return exercicio
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	
	@PostMapping
	public String post(@RequestBody Exercicio Exercicio) {
		Exercicio e = exercicioService.insert(Exercicio);
		return "Exercicio cadastrado com sucesso!" + e.getId();
	}
	
	@PutMapping("/{id}")
	public String put(@PathVariable("id")Long id, @RequestBody Exercicio Exercicio) {
		Exercicio e = exercicioService.update(Exercicio,id);
		return "Exercicio atualizado com sucesso!" + e.getId(); 
		
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id")Long id) {
		exercicioService.delete(id);
		return "Exercicio deletado com sucesso!";
	}

}
