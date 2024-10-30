package com.example.demo.domain.services.interfaces;

import java.util.List;
import java.util.UUID;

import com.example.demo.domain.models.dtos.ContatoRequestDto;
import com.example.demo.domain.models.dtos.ContatoResponseDto;
import com.example.demo.domain.models.entities.Contato;

public interface ContatoDomainService {

	public String inserir(ContatoRequestDto dto) throws Exception;

	public String atualizar(UUID id, ContatoRequestDto dto) throws Exception;

	public String excluir(UUID id) throws Exception;

	public List<ContatoResponseDto> consultar() throws Exception;

	public Contato consultarPorId(UUID id) throws Exception;
}
