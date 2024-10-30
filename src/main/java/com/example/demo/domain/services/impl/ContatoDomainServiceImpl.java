package com.example.demo.domain.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.models.dtos.ContatoDto;
import com.example.demo.domain.models.entities.Contato;
import com.example.demo.domain.services.interfaces.ContatoDomainService;
import com.example.demo.infrastructure.repositories.ContatoRepository;

@Service
public class ContatoDomainServiceImpl implements ContatoDomainService {

	@Autowired
	ContatoRepository contatoRepository;

	@Override
	public String inserir(ContatoDto dto) throws Exception {

		var contato = new Contato();
		contato.setId(UUID.randomUUID());
		contato.setNome(dto.getNome());
		contato.setEmail(dto.getEmail());
		contato.setTelefone(dto.getTelefone());
		contato.setCategoria(dto.getCategoria());

		contatoRepository.insert(contato);

		return "Contato registrado com sucesso!";
	}

	@Override
	public String atualizar(UUID id, ContatoDto dto) throws Exception {

		var contato = contatoRepository.findById(id);

		if (contato != null) {

			contato.setNome(dto.getNome());
			contato.setEmail(dto.getEmail());
			contato.setTelefone(dto.getTelefone());
			contato.setCategoria(dto.getCategoria());

			contatoRepository.update(contato);

		} else {

			return "Contato não encontrado. Verifique o ID informado.";
		}

		return "Contato atualizado com sucesso!";
	}

	@Override
	public String excluir(UUID id) throws Exception {

		var contato = contatoRepository.findById(id);

		if (contato != null) {

			contatoRepository.delete(id);
			
		} else {

			return "Contato não encontrado. Verifique o ID informado.";
		}

		return "Contato excluído com sucesso!";
	}

	@Override
	public List<Contato> consultar() throws Exception {
		
		List<Contato> contatos = contatoRepository.findAll();
	
		return contatos;
	}

	@Override
	public Contato consultarPorId(UUID id) throws Exception {
		
		var contato = contatoRepository.findById(id);
		
		return contato;
	}
}
