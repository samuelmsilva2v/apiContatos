package com.example.demo;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ApiContatosApplicationTests {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;

	@Test
	@Order(1)
	void cadastrarCategoriaTest() throws Exception {
		fail("Não implementado");
	}
	
	@Test
	@Order(2)
	void atualizarCategoriaTest() throws Exception {
		fail("Não implementado");
	}
	
	@Test
	@Order(3)
	void cadastrarContatoTest() throws Exception {
		fail("Não implementado");
	}
	
	@Test
	@Order(4)
	void atualizarContatoTest() throws Exception {
		fail("Não implementado");
	}
	
	@Test
	@Order(5)
	void consultarCategoriaPorIdTest() throws Exception {
		fail("Não implementado");
	}
	
	@Test
	@Order(6)
	void consultarCategoriasTest() throws Exception {
		fail("Não implementado");
	}
	
	@Test
	@Order(7)
	void consultarContatoPorIdTest() throws Exception {
		fail("Não implementado");
	}
	
	@Test
	@Order(8)
	void consultarContatosTest() throws Exception {
		fail("Não implementado");
	}
	
	@Test
	@Order(9)
	void removerContatoTest() throws Exception {
		fail("Não implementado");
	}
	
	@Test
	@Order(10)
	void removerCategoriaTest() throws Exception {
		fail("Não implementado");
	}

}
