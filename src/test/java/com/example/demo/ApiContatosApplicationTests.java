package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.domain.models.dtos.CategoriaRequestDto;
import com.example.demo.domain.models.dtos.CategoriaResponseDto;
import com.example.demo.domain.models.dtos.ContatoRequestDto;
import com.example.demo.domain.models.dtos.ContatoResponseDto;
import com.fasterxml.jackson.core.type.TypeReference;
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

	private static UUID contatoId;

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

		var faker = new Faker(Locale.forLanguageTag("pt-BR"));

		var request = new CategoriaRequestDto();
		request.setNome(faker.book().genre());

		var result = mockMvc.perform(put("/api/categorias/" + 1).contentType("application/json")
				.content(objectMapper.writeValueAsString(request))).andExpect(status().isOk()).andReturn();

		var content = result.getResponse().getContentAsString(StandardCharsets.UTF_8);

		assertTrue(content.contains("Categoria atualizada com sucesso!"));
	}

	@Test
	@Order(3)
	void cadastrarContatoTest() throws Exception {

		var faker = new Faker(Locale.forLanguageTag("pt-BR"));

		var request = new ContatoRequestDto();
		request.setNome(faker.name().fullName());
		request.setEmail(faker.internet().emailAddress());
		request.setTelefone(faker.number().digits(11));
		request.setCategoria_id(1);

		var result = mockMvc.perform(
				post("/api/contatos").contentType("application/json").content(objectMapper.writeValueAsString(request)))
				.andExpect(status().isOk()).andReturn();

		var content = result.getResponse().getContentAsString(StandardCharsets.UTF_8);

		var response = objectMapper.readValue(content, ContatoResponseDto.class);

		assertNotNull(response.getId());
		assertEquals(response.getNome(), request.getNome());
		assertEquals(response.getEmail(), request.getEmail());
		assertEquals(response.getTelefone(), request.getTelefone());

		contatoId = response.getId();
	}

	@Test
	@Order(4)
	void atualizarContatoTest() throws Exception {

		var faker = new Faker(Locale.forLanguageTag("pt-BR"));

		var request = new ContatoRequestDto();
		request.setNome(faker.name().fullName());
		request.setEmail(faker.internet().emailAddress());
		request.setTelefone(faker.number().digits(11));
		request.setCategoria_id(1);

		var result = mockMvc.perform(put("/api/contatos/" + contatoId).contentType("application/json")
				.content(objectMapper.writeValueAsString(request))).andExpect(status().isOk()).andReturn();

		var content = result.getResponse().getContentAsString(StandardCharsets.UTF_8);

		assertTrue(content.contains("Contato atualizado com sucesso!"));
	}

	@Test
	@Order(5)
	void consultarCategoriaPorIdTest() throws Exception {

		var result = mockMvc.perform(get("/api/categorias/" + 1)).andExpect(status().isOk()).andReturn();

		var content = result.getResponse().getContentAsString(StandardCharsets.UTF_8);

		var response = objectMapper.readValue(content, CategoriaResponseDto.class);

		assertEquals(response.getId(), 1);
		assertNotNull(response.getNome());
	}

	@Test
	@Order(6)
	void consultarCategoriasTest() throws Exception {

		var result = mockMvc.perform(get("/api/categorias")).andExpect(status().isOk()).andReturn();

		var content = result.getResponse().getContentAsString(StandardCharsets.UTF_8);

		var response = objectMapper.readValue(content, new TypeReference<List<CategoriaResponseDto>>() {
		});

		response.stream().filter(categoria -> categoria.getId().equals(1)).findFirst()
				.orElseThrow(() -> new AssertionError("Categoria não encontrada"));
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
