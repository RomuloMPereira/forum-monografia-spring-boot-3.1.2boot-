package com.monografia.forum.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.springframework.hateoas.RepresentationModel;

import com.monografia.forum.entities.Funcao;
import com.monografia.forum.entities.Usuario;

public class UsuarioDto extends RepresentationModel<UsuarioDto> implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	@NotBlank(message = "Campo obrigatório")
	private String nome;
	
	@NotBlank(message = "Campo obrigatório")
	@Email(message = "Favor entrar um email válido")
	private String email;
	
	@NotBlank(message = "Campo obrigatório")
	private String senha;
	
	private List<FuncaoDto> funcoes = new ArrayList<>(); 
	
	public UsuarioDto() {
	}

	public UsuarioDto(Long id, String nome, String email, String senha) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}
	
	public UsuarioDto(Usuario entidade) {
		this.id = entidade.getId();
		this.nome = entidade.getNome();
		this.email = entidade.getEmail();
		this.senha = entidade.getSenha();
	}
	
	public UsuarioDto(Usuario entidade, Set<Funcao> funcoes) {
		this.id = entidade.getId();
		this.nome = entidade.getNome();
		this.email = entidade.getEmail();
		this.senha = entidade.getSenha();
		
		funcoes.forEach(funcao -> this.funcoes.add(new FuncaoDto(funcao)));
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<FuncaoDto> getFuncoes() {
		return funcoes;
	}

	public void setFuncoes(List<FuncaoDto> funcoes) {
		this.funcoes = funcoes;
	}
}
