package com.academia.controller;

import java.util.List;
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

import com.academia.model.Aluno;

import service.AlunoService;

@RestController
@RequestMapping("/api/v1/alunos")
public class AlunoController {
	@Autowired
	private AlunoService alunoService;
	
	@GetMapping
	public Iterable<Aluno> get() {
		return alunoService.getAlunos();
	}
	
	@GetMapping("/{id}")
	public Optional<Aluno> get(@PathVariable("id") Long id) {
		return alunoService.getAlunosById(id);
	}
	
	
	@PostMapping
	public String post(@RequestBody Aluno aluno) {
		alunoService.save(aluno);
		return "Aluno cadastrado com sucesso!" + aluno.getId();
	}

}
