package com.academia.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.academia.model.Aluno;
import com.academia.model.AlunoService;

@RestController
@RequestMapping("/api/v1/alunos")
public class AlunoController {
	@Autowired
	private AlunoService service;
	
	@GetMapping
	public List<Aluno> get() {
		return service.getAlunos();
	}
	
	

}
