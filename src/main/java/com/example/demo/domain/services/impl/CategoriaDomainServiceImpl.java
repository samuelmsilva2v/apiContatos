package com.example.demo.domain.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.models.dtos.CategoriaRequestDto;
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

		if (categoria != null) {

			categoria.setNome(dto.getNome());

			categoriaRepository.update(id, categoria);

		} else {

			return "Categoria não encontrada. Verifique o ID informado.";
		}

		return "Categoria atualizada com sucesso!";
	}

	@Override
	public String excluir(Integer id) throws Exception {

		var categoria = categoriaRepository.findById(id);

		if (categoria != null) {

			categoriaRepository.delete(id);

		} else {

			return "Categoria não encontrada. Verifique o ID informado.";
		}

		return "Categoria excluída com sucesso!";
	}

	@Override
	public Categoria consultarPorId(Integer id) throws Exception {

		var categoria = categoriaRepository.findById(id);

		return categoria;
	}

	@Override
	public List<Categoria> consultar() throws Exception {

		List<Categoria> categorias = categoriaRepository.findAll();

		return categorias;
	}

}
