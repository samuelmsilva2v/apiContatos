package com.example.demo.domain.models.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ContatoRequestDto {

	@NotEmpty(message= "Por favor, digite um nome válido.")
	private String nome;
	
	@Email(message = "Por favor, digite um e-mail válido.")
	@NotEmpty(message = "O e-mail é obrigatório.")
	private String email;
	
	@NotEmpty(message = "Por favor, digite um telefone válido. XX XXXXXXXXX")
	private String telefone;
	
	@NotNull(message = "A categoria é obrigatória.")
	private Integer categoria_id;
}
