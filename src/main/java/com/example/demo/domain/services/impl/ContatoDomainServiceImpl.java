package com.example.demo.domain.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.models.dtos.ContatoRequestDto;
import com.example.demo.domain.models.dtos.ContatoResponseDto;
import com.example.demo.domain.models.entities.Categoria;
import com.example.demo.domain.models.entities.Contato;
import com.example.demo.domain.services.interfaces.ContatoDomainService;
import com.example.demo.infrastructure.repositories.ContatoRepository;

@Service
public class ContatoDomainServiceImpl implements ContatoDomainService {

	@Autowired
	ContatoRepository contatoRepository;

	@Override
	public String inserir(ContatoRequestDto dto) throws Exception {

		var contato = new Contato();
		contato.setCategoria(new Categoria());
		
		contato.setId(UUID.randomUUID());
		contato.setNome(dto.getNome());
		contato.setEmail(dto.getEmail());
		contato.setTelefone(dto.getTelefone());
		contato.getCategoria().setId(dto.getCategoria_id());

		contatoRepository.insert(contato);

		return "Contato registrado com sucesso!";
	}

	@Override
	public String atualizar(UUID id, ContatoRequestDto dto) throws Exception {

		var contato = contatoRepository.findById(id);

		if (contato == null)
			return "Contato não encontrado. Verifique o ID informado.";
		
		contato.setId(id);
		contato.setNome(dto.getNome());
		contato.setEmail(dto.getEmail());
		contato.setTelefone(dto.getTelefone());
		contato.getCategoria().setId(dto.getCategoria_id());

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
	public List<ContatoResponseDto> consultar() throws Exception {
		
		List<Contato> contatos = contatoRepository.findAll();
		
		List<ContatoResponseDto> response = new ArrayList<ContatoResponseDto>();
		
		for(Contato contato : contatos) {
			
			var novoContato = new ContatoResponseDto();
			novoContato.setId(contato.getId());
			novoContato.setNome(contato.getNome());
			novoContato.setEmail(contato.getEmail());
			novoContato.setTelefone(contato.getTelefone());
			novoContato.setCategoriaId(contato.getCategoria().getId());
			
			response.add(novoContato);
		}
	
		return response;
	}

	@Override
	public ContatoResponseDto consultarPorId(UUID id) throws Exception {
		
		var contato = contatoRepository.findById(id);
		
		var response = new ContatoResponseDto();
		response.setId(contato.getId());
		response.setNome(contato.getNome());
		response.setEmail(contato.getEmail());
		response.setTelefone(contato.getTelefone());
		response.setCategoriaId(contato.getCategoria().getId());
		
		return response;
	}
}
