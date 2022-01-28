package com.academia.api;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class IndexController {
	
	
	@PostMapping("/login")
	public String login(@RequestParam("login")String login, @RequestParam("senha")String senha) {
		return "login: " + login + " senha: " + senha;
	}
	
	@GetMapping
	public String get() {
		return "Get spring boot";
	}
	
	@GetMapping("/alunos")
	public String getListaAlunos(@PathVariable("Todos") String alunosLista) {
		return "Lista de alunos" + alunosLista;
	}
	
	@PutMapping
	public String put() {
		return "Put spring boot";
	}
	
	
	@DeleteMapping
	public String delete() {
		return "Delete spring boot";
	}

}
