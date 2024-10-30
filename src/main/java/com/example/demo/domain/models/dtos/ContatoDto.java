package com.example.demo.domain.models.dtos;

import com.example.demo.domain.models.entities.Categoria;

import lombok.Data;

@Data
public class ContatoDto {

	private String nome;
	private String email;
	private String telefone;
	private Categoria categoria;
}
