package com.example.demo.domain.models.dtos;

import com.example.demo.domain.models.entities.Categoria;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class ContatoDto {

	@NotEmpty(message= "Por favor, digite um nome válido.")
	private String nome;
	
	@Email(message = "Por favor, digite um e-mail válido.")
	@NotEmpty(message = "O e-mail é obrigatório.")
	private String email;
	
	@NotEmpty(message = "Por favor, digite um telefone válido. XX XXXXXXXXX")
	private String telefone;
	
	@NotEmpty(message = "A categoria é obrigatória.")
	private Categoria categoria;
}
