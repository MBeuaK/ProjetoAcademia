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
import com.academia.model.Instrutor;
import com.academia.service.InstrutorService;

@RestController
@RequestMapping("/api/v1/instrutores")
public class InstrutorController {
	@Autowired
	private InstrutorService instrutorService;
	
	@GetMapping
	public ResponseEntity<Iterable<Instrutor>> get() {
		return ResponseEntity.ok(instrutorService.getInstrutor());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Instrutor> get(@PathVariable("id") Long id) {
		Optional<Instrutor> instrutor = instrutorService.getInstrutorById(id);
		return instrutor
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	
	@PostMapping
	public String post(@RequestBody Instrutor instrutor) {
		Instrutor i = instrutorService.insert(instrutor);
		return "Instrutor cadastrado com sucesso!" + i.getId();
	}
	
	@PutMapping("/{id}")
	public String put(@PathVariable("id")Long id, @RequestBody Instrutor instrutor) {
		Instrutor i = instrutorService.update(instrutor,id);
		return "Instrutor atualizado com sucesso!" + i.getId(); 
		
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id")Long id) {
		instrutorService.delete(id);
		return "Instrutor deletado com sucesso!";
	}

}
