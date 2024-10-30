package com.example.demo.application.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/contatos")
public class ContatoController {

	@PostMapping
	public String post() {
		// TODO
		return null;
	}
	
	@PutMapping
	public String put() {
		// TODO
		return null;
	}
	
	@DeleteMapping
	public String delete() {
		// TODO
		return null;
	}
	
	@GetMapping
	public String getAll() {
		// TODO
		return null;
	}
}
