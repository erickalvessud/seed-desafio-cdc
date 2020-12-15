package com.deveficiente.controller.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.deveficiente.jpa.entity.PaisEntity;
import com.deveficiente.util.Document;
import com.deveficiente.util.ExistsId;

import lombok.Data;
import lombok.Getter;

@Getter
@Data
public class PagamentoRequest {
	
	@NotBlank
	@Email
	private String email;
	
	@NotBlank
	private String nome;
	
	@NotBlank
	private String sobrenome;
	
	@NotBlank
	@Document
	private String documento;
	
	@NotBlank
	private String endereco;
	
	@NotBlank
	private String complemento;
	
	@NotBlank
	private String cidade;
	
	@NotNull
	@ExistsId(domainClass = PaisEntity.class, fieldName = "id")
	private Long pais;
	
	private Long estado;
	
	@NotBlank
	private String telefone;
	
	@NotBlank
	private String cep;
	
	public PagamentoRequest(String email, String nome, String sobrenome, String documento, String endereco,
			String complemento, String cidade, Long pais, String telefone, String cep) {
		super();
		this.email = email;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.documento = documento;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.pais = pais;
		this.telefone = telefone;
		this.cep = cep;
	}
}
