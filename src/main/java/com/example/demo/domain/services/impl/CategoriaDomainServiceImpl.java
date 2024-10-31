package com.example.demo.domain.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.models.dtos.CategoriaRequestDto;
import com.example.demo.domain.models.dtos.CategoriaResponseDto;
import com.example.demo.domain.models.entities.Categoria;
import com.example.demo.domain.services.interfaces.CategoriaDomainService;
import com.example.demo.infrastructure.repositories.CategoriaRepository;

@Service
public class CategoriaDomainServiceImpl implements CategoriaDomainService {

	@Autowired
	CategoriaRepository categoriaRepository;

	@Override
	public String inserir(CategoriaRequestDto dto) throws Exception {

		var categoria = new Categoria();
		categoria.setNome(dto.getNome());

		categoriaRepository.insert(categoria);

		return "Categoria cadastrada com sucesso!";
	}

	@Override
	public String atualizar(Integer id, CategoriaRequestDto dto) throws Exception {

		var categoria = categoriaRepository.findById(id);

		if (categoria == null)
			return "Categoria não encontrada. Verifique o ID informado.";

		categoria.setNome(dto.getNome());
		categoriaRepository.update(id, categoria);

		return "Categoria atualizada com sucesso!";
	}

	@Override
	public String excluir(Integer id) throws Exception {

		var categoria = categoriaRepository.findById(id);

		if (categoria == null)
			return "Categoria não encontrada. Verifique o ID informado.";

		categoriaRepository.delete(id);

		return "Categoria excluída com sucesso!";
	}

	@Override
	public CategoriaResponseDto consultarPorId(Integer id) throws Exception {

		var categoria = categoriaRepository.findById(id);

		var response = new CategoriaResponseDto();
		response.setId(categoria.getId());
		response.setNome(categoria.getNome());

		return response;
	}

	@Override
	public List<CategoriaResponseDto> consultar() throws Exception {

		List<Categoria> categorias = categoriaRepository.findAll();
		
		List<CategoriaResponseDto> response = new ArrayList<CategoriaResponseDto>();
		
		for(Categoria categoria : categorias) {
			
			var categoriaResponse = new CategoriaResponseDto();
			categoriaResponse.setId(categoria.getId());
			categoriaResponse.setNome(categoria.getNome());
			
			response.add(categoriaResponse);
		}

		return response;
	}

}
