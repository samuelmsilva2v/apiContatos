package com.example.demo.domain.models.entities;

import java.util.List;

import lombok.Data;

@Data
public class Categoria {

	private Integer id;
	private String nome;
	private List<Contato> contatos;
}
