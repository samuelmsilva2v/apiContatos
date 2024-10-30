package com.example.demo.domain.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.demo.domain.models.dtos.ContatoDto;
import com.example.demo.domain.models.entities.Categoria;
import com.example.demo.domain.models.entities.Contato;
import com.example.demo.domain.services.interfaces.ContatoDomainService;

@Service
public class ContatoDomainServiceImpl implements ContatoDomainService {

	@Override
	public String inserir(ContatoDto dto) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String atualizar(ContatoDto dto) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String excluir(UUID id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Contato> consultar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Categoria consultarPorId(UUID id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
