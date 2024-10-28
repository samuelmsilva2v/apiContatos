package com.example.demo.domain.models.dtos;

import java.util.UUID;

import com.example.demo.domain.models.entities.Categoria;

import lombok.Data;

@Data
public class ContatoDto {

	private UUID id;
	private String nome;
	private String email;
	private String telefone;
	private Categoria categoria;
}
