package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.StandardCharsets;
import java.util.Locale;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.domain.models.dtos.CategoriaRequestDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;

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

		var faker = new Faker(Locale.forLanguageTag("pt-BR"));

		var request = new CategoriaRequestDto();
		request.setNome(faker.book().genre());

		var result = mockMvc.perform(post("/api/categorias").contentType("application/json")
				.content(objectMapper.writeValueAsString(request))).andExpect(status().isOk()).andReturn();
		
		var content = result.getResponse().getContentAsString(StandardCharsets.UTF_8);
		
		assertTrue(content.contains("Categoria cadastrada com sucesso!"));
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
