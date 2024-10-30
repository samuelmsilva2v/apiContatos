package com.example.demo.domain.services.interfaces;

import java.util.List;

import com.example.demo.domain.models.dtos.CategoriaRequestDto;
import com.example.demo.domain.models.entities.Categoria;

public interface CategoriaDomainService {

	public String inserir(CategoriaRequestDto request) throws Exception;
	
	public String atualizar(Integer id, CategoriaRequestDto dto) throws Exception;
	
	public String excluir(Integer id) throws Exception;
	
	public List<Categoria> consultar() throws Exception;
	
	public Categoria consultarPorId(Integer id) throws Exception;
}
