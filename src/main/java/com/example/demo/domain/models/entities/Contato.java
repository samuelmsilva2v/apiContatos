package com.example.demo.domain.models.entities;

import java.util.UUID;

import lombok.Data;

@Data
public class Contato {

	private UUID id;
	private String nome;
	private String email;
	private String telefone;
}
