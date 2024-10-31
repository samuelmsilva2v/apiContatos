package com.example.demo.domain.services.interfaces;

import java.util.List;

import com.example.demo.domain.models.dtos.CategoriaRequestDto;
import com.example.demo.domain.models.dtos.CategoriaResponseDto;

public interface CategoriaDomainService {

	public String inserir(CategoriaRequestDto request) throws Exception;
	
	public String atualizar(Integer id, CategoriaRequestDto dto) throws Exception;
	
	public String excluir(Integer id) throws Exception;
	
	public List<CategoriaResponseDto> consultar() throws Exception;
	
	public CategoriaResponseDto consultarPorId(Integer id) throws Exception;
}
