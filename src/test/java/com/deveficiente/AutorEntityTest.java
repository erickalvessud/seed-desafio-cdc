package com.deveficiente;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.context.SpringBootTest;

import com.deveficiente.jpa.entity.AutorEntity;

public class AutorEntityTest {

	@Test
	@DisplayName("Nao deve criar autor com nome vazio")
	public void teste1(){
		Assertions.assertThrows(IllegalArgumentException.class, () ->  new AutorEntity("", "email@gmail.com", "Descricao"));
	}
	
	@Test
	@DisplayName("Nao deve criar autor com nome nulo")
	public void teste2(){
		Assertions.assertThrows(IllegalArgumentException.class, () ->  new AutorEntity(null, "email@gmail.com", "Descricao"));
	}
	
	@Test
	@DisplayName("Nao deve criar autor com email vazio")
	public void teste3(){
		Assertions.assertThrows(IllegalArgumentException.class, () ->  new AutorEntity("João", "", "Descricao"));
	}
	
	@Test
	@DisplayName("Nao deve criar autor com email nulo")
	public void teste4(){
		Assertions.assertThrows(IllegalArgumentException.class, () ->  new AutorEntity("João", null, "Descricao"));
	}
	
	@Test
	@DisplayName("Nao deve criar autor com a descricao vazia")
	public void teste5(){
		Assertions.assertThrows(IllegalArgumentException.class, () ->  new AutorEntity("João", "email@gmail.com", ""));
	}
	
	@Test
	@DisplayName("Nao deve criar autor com a descricao nula")
	public void teste6(){
		Assertions.assertThrows(IllegalArgumentException.class, () ->  new AutorEntity("João", "email@gmail.com", null));
	}
	
	
	@ParameterizedTest
	@ValueSource(strings = {
			// 401 caracteres
			"Essa descricao é muito grande. Essa descricao é muito grande. Essa descricao é muito grande. Essa descricao é muito grande. Essa descricao é muito grande. Essa descricao é muito grande. Essa descricao é muito grande. Essa descricao é muito grande. Essa descricao é muito grande. Essa descricao é muito grande. Essa descricao é muito grande. Essa descricao é muito grande. Essa descricao é muito grande",
			// 406 caracteres
			"Essa descricao é muito grande. Essa descricao é muito grande. Essa descricao é muito grande. Essa descricao é muito grande. Essa descricao é muito grande. Essa descricao é muito grande. Essa descricao é muito grande. Essa descricao é muito grande. Essa descricao é muito grande. Essa descricao é muito grande. Essa descricao é muito grande. Essa descricao é muito grande. Essa descricao é muito grande!!!!!"
	})
	@DisplayName("Nao deve criar autor com a descricao com tamanho inválido")
	public void teste7(String descricao){
		Assertions.assertThrows(IllegalArgumentException.class, () ->  new AutorEntity("João", "email@gmail.com", descricao));
	}
	
	@Test
	@DisplayName("Deve criar autor com sucesso")
	public void teste8(){
		Assertions.assertDoesNotThrow(() ->  new AutorEntity("João", "email@gmail.com", "Descrição sobre o autor"));
	}
}
