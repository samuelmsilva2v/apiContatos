package com.example.demo.domain.models.dtos;

import java.util.UUID;

import lombok.Data;

@Data
public class ContatoResponseDto {

	private UUID id;
	private String nome;
	private String email;
	private String telefone;
	private Integer categoriaId;
}
