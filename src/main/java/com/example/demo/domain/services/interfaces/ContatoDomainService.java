package com.example.demo.domain.services.interfaces;

import java.util.List;
import java.util.UUID;

import com.example.demo.domain.models.dtos.ContatoDto;
import com.example.demo.domain.models.entities.Categoria;
import com.example.demo.domain.models.entities.Contato;

public interface ContatoDomainService {

	public String inserir(ContatoDto dto) throws Exception;

	public String atualizar(ContatoDto dto) throws Exception;

	public String excluir(UUID id) throws Exception;

	public List<Contato> consultar() throws Exception;

	public Categoria consultarPorId(UUID id) throws Exception;
}
