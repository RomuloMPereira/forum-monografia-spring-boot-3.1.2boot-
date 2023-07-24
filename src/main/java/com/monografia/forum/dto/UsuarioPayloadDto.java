package com.monografia.forum.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.springframework.hateoas.RepresentationModel;

import com.monografia.forum.entities.Funcao;
import com.monografia.forum.entities.Resposta;
import com.monografia.forum.entities.Topico;
import com.monografia.forum.entities.Usuario;

public class UsuarioPayloadDto extends RepresentationModel<UsuarioPayloadDto> implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	@NotBlank(message = "Campo obrigatório")
	private String nome;
	
	@NotBlank(message = "Campo obrigatório")
	@Email(message = "Favor entrar um email válido")
	private String email;
	
	private List<FuncaoDto> funcoes = new ArrayList<>(); 
	private List<TopicoDto> topicos = new ArrayList<>();
	private List<TopicoDto> topicosCurtidos = new ArrayList<>();
	private List<RespostaDto> respostas = new ArrayList<>();
	
	public UsuarioPayloadDto() {
	}

	public UsuarioPayloadDto(Long id, String nome, String email) {
		this.id = id;
		this.nome = nome;
		this.email = email;
	}
	
	public UsuarioPayloadDto(Usuario entidade) {
		this.id = entidade.getId();
		this.nome = entidade.getNome();
		this.email = entidade.getEmail();
	}
	
	public UsuarioPayloadDto(Usuario entidade, Set<Funcao> funcoes, Set<Topico> topicos, Set<Topico> topicosCurtidos, Set<Resposta> respostas) {
		this.id = entidade.getId();
		this.nome = entidade.getNome();
		this.email = entidade.getEmail();
		
		funcoes.forEach(funcao -> this.funcoes.add(new FuncaoDto(funcao)));
		topicos.forEach(topico -> this.topicos.add(new TopicoDto(topico)));
		topicosCurtidos.forEach(topicoCurtido -> this.topicosCurtidos.add(new TopicoDto(topicoCurtido)));
		respostas.forEach(resposta -> this.respostas.add(new RespostaDto(resposta)));
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

	public List<FuncaoDto> getFuncoes() {
		return funcoes;
	}

	public void setFuncoes(List<FuncaoDto> funcoes) {
		this.funcoes = funcoes;
	}

	public List<TopicoDto> getTopicos() {
		return topicos;
	}

	public void setTopicos(List<TopicoDto> topicos) {
		this.topicos = topicos;
	}

	public List<TopicoDto> getTopicosCurtidos() {
		return topicosCurtidos;
	}

	public void setTopicosCurtidos(List<TopicoDto> topicosCurtidos) {
		this.topicosCurtidos = topicosCurtidos;
	}

	public List<RespostaDto> getRespostas() {
		return respostas;
	}

	public void setRespostas(List<RespostaDto> respostas) {
		this.respostas = respostas;
	}
}
