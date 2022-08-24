package com.calife.anamnesis.domain.dtos;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

import com.calife.anamnesis.domain.Cliente;
import com.calife.anamnesis.domain.enums.Perfil;
import com.fasterxml.jackson.annotation.JsonFormat;

public class ClienteDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	protected Integer id;
	@NotNull(message = "Campo NOME é requerido")
	protected String nome;
	@NotNull(message = "Campo CPF é requerido")
	protected String cpf;
	@NotNull(message = "Campo EMAIL é requerido")
	protected String email;
	@NotNull(message = "Campo SENHA é requerido")
	protected String senha;
	protected Set<Integer> perfis = new HashSet<>();
	@NotNull(message = "Campo RG é requerido")
	protected String rg;
	@NotNull(message = "Campo DATA DE NASCIMENTO é requerido")
	protected LocalDate dataNascimento;
	@NotNull(message = "Campo ENDEREÇO é requerido")
	protected String endereco;
	@NotNull(message = "Campo NÚMERO é requerido")
	protected String numero;
	protected String complemento;
	protected String cep;
	protected String telefone;
	@NotNull(message = "Campo CELULAR é requerido")
	protected String celular;
	@NotNull(message = "Campo PIGMENTO USADO é requerido")
	protected String pigmentoUsado;
	
	
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	protected LocalDate dataCriacao = LocalDate.now();

	public ClienteDTO() {
		super();
		addPerfis(Perfil.CLIENTE);
	}

	public ClienteDTO(Cliente oldObj) {
		super();
		this.id = oldObj.getId();
		this.nome = oldObj.getNome();
		this.cpf = oldObj.getCpf();
		this.rg = oldObj.getRg();
		this.dataNascimento = oldObj.getDataNascimento();
		this.endereco = oldObj.getEndereco();
		this.numero = oldObj.getNumero();
		this.complemento = oldObj.getComplemento();
		this.cep = oldObj.getCep();
		this.telefone = oldObj.getTelefone();
		this.celular = oldObj.getCelular();
		this.pigmentoUsado = oldObj.getPigmentoUsado();
		this.email = oldObj.getEmail();
		this.senha = oldObj.getSenha();
		this.perfis = oldObj.getPerfis().stream().map(x -> x.getCodigo()).collect(Collectors.toSet());
		this.dataCriacao = oldObj.getDataCriacao();
		addPerfis(Perfil.CLIENTE);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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

	public Set<Perfil> getPerfis() {
		return perfis.stream().map(x -> Perfil.toEnaum(x)).collect(Collectors.toSet());
	}

	public void addPerfis(Perfil perfis) {
		this.perfis.add(perfis.getCodigo());
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getPigmentoUsado() {
		return pigmentoUsado;
	}

	public void setPigmentoUsado(String pigmentoUsado) {
		this.pigmentoUsado = pigmentoUsado;
	}

	public void setPerfis(Set<Integer> perfis) {
		this.perfis = perfis;
	}
}
