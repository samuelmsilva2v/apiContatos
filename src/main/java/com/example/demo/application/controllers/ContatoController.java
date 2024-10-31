package com.example.demo.application.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.models.dtos.ContatoRequestDto;
import com.example.demo.domain.models.dtos.ContatoResponseDto;
import com.example.demo.domain.services.interfaces.ContatoDomainService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/contatos")
public class ContatoController {

	@Autowired
	ContatoDomainService contatoDomainService;
	
	@PostMapping
	public String post(@Valid @RequestBody ContatoRequestDto dto) throws Exception {
		return contatoDomainService.inserir(dto);
	}
	
	@PutMapping("{id}")
	public String put(@PathVariable UUID id, @Valid @RequestBody ContatoRequestDto dto) throws Exception {
		return contatoDomainService.atualizar(id, dto);
	}
	
	@DeleteMapping("{id}")
	public String delete(@PathVariable UUID id) throws Exception {
		return contatoDomainService.excluir(id);
	}
	
	@GetMapping
	public List<ContatoResponseDto> getAll() throws Exception {
		return contatoDomainService.consultar();
	}
	
	@GetMapping("{id}")
	public ContatoResponseDto getById(@PathVariable UUID id) throws Exception {
		return contatoDomainService.consultarPorId(id);
	}
}
