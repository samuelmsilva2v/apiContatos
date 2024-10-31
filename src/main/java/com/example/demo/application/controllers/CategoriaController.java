package com.example.demo.application.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.models.dtos.CategoriaRequestDto;
import com.example.demo.domain.models.dtos.CategoriaResponseDto;
import com.example.demo.domain.services.interfaces.CategoriaDomainService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

	@Autowired
	CategoriaDomainService categoriaDomainService;
	
	@PostMapping
	public String post(@Valid @RequestBody CategoriaRequestDto dto) throws Exception {
		return categoriaDomainService.inserir(dto);
	}
	
	@PutMapping("{id}")
	public String put(@PathVariable Integer id, @Valid @RequestBody CategoriaRequestDto dto) throws Exception {
		return categoriaDomainService.atualizar(id, dto);
	}
	
	@DeleteMapping("{id}")
	public String delete(@PathVariable Integer id) throws Exception {
		return categoriaDomainService.excluir(id);
	}
	
	@GetMapping
	public List<CategoriaResponseDto> getAll() throws Exception {
		return categoriaDomainService.consultar();
	}
	
	@GetMapping("{id}")
	public CategoriaResponseDto getById(@PathVariable Integer id) throws Exception {
		return categoriaDomainService.consultarPorId(id);
	}
}
