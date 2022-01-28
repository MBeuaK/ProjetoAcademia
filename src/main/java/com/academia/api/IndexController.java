package com.academia.api;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class IndexController {
	
	@GetMapping
	public String get() {
		return "Get spring boot";
	}
	
	@PutMapping
	public String put() {
		return "Put spring boot";
	}
	
	@PostMapping
	public String post() {
		return "Post spring boot";
	}
	
	@DeleteMapping
	public String delete() {
		return "Delete spring boot";
	}

}
