package com.academia.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.academia.model.Instrutor;
import com.academia.service.InstrutorService;

@RestController
@RequestMapping("/api/v1/instrutores")
public class InstrutorController {
	@Autowired
	private InstrutorService instrutorService;
	
	@GetMapping
	public Iterable<Instrutor> get() {
		return instrutorService.getInstrutor();
	}
	
	@GetMapping("/{id}")
	public Optional<Instrutor> get(@PathVariable("id") Long id) {
		return instrutorService.getInstrutorById(id);
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
