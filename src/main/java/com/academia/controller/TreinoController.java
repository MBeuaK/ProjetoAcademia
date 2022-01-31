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

import com.academia.model.Treino;
import com.academia.service.TreinoService;

@RestController
@RequestMapping("/api/v1/treino")
public class TreinoController {
	@Autowired
	private TreinoService treinoService;
	
	@GetMapping
	public Iterable<Treino> get() {
		return treinoService.getTreino();
	}
	
	@GetMapping("/{id}")
	public Optional<Treino> get(@PathVariable("id") Long id) {
		return treinoService.getTreinoById(id);
	}
	
	
	@PostMapping
	public String post(@RequestBody Treino treino) {
		Treino t = treinoService.insert(treino);
		return "Treino cadastrado com sucesso!" + t.getId();
	}
	
	@PutMapping("/{id}")
	public String put(@PathVariable("id")Long id, @RequestBody Treino treino) {
		Treino t = treinoService.update(treino,id);
		return "Treino atualizado com sucesso!" + t.getId(); 
		
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id")Long id) {
		treinoService.delete(id);
		return "Treino deletado com sucesso!";
	}

}
