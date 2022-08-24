package com.calife.anamnesis.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.calife.anamnesis.domain.dtos.ClienteDTO;
import com.calife.anamnesis.domain.enums.Perfil;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Cliente extends Pessoa{
	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@OneToMany(mappedBy = "cliente")
	private List<Chamado> chamados = new ArrayList<>();

	private String rg;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataNascimento;
	private String endereco;
	private String numero;
	private String complemento;
	private String bairro;
	private String cidade;
	private String UF;
	private String cep;
	private String telefone;
	private String celular;
	private String pigmentoUsado;
	
	public Cliente() {
		super();
		addPerfil(Perfil.CLIENTE);
	}

	public Cliente(Integer id, String nome, String cpf, String rg, LocalDate dataNascimento, String endereco, String numero,
			String complemento, String bairro, String cidade, String UF, String cep, String telefone, String celular, 
			String email, String senha, String pigmentoUsado) {
		super(id, nome, cpf, email, senha);
		
		this.rg = rg;
		this.dataNascimento = dataNascimento; 
		this.endereco = endereco;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.UF = UF;
		this.cep = cep;
		this.telefone = telefone;
		this.celular = celular;
		this.pigmentoUsado = pigmentoUsado;
		
		addPerfil(Perfil.CLIENTE);
	}

	public Cliente(ClienteDTO objDTO) {
		super();
		this.id = objDTO.getId();
		this.nome = objDTO.getNome();
		this.cpf = objDTO.getCpf();
		this.rg = objDTO.getRg();
		this.dataNascimento = objDTO.getDataNascimento();
		this.endereco = objDTO.getEndereco();
		this.numero = objDTO.getNumero();
		this.complemento = objDTO.getComplemento();
		this.bairro = objDTO.getBairro();
		this.cidade = objDTO.getCidade();
		this.UF = objDTO.getUF();
		this.cep = objDTO.getCep();
		this.telefone = objDTO.getTelefone();
		this.celular = objDTO.getCelular();
		this.email = objDTO.getEmail();
		this.senha = objDTO.getSenha();
		this.pigmentoUsado = objDTO.getPigmentoUsado();
		this.perfis = objDTO.getPerfis().stream().map(x -> x.getCodigo()).collect(Collectors.toSet());
		this.dataCriacao = objDTO.getDataCriacao();
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

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = bairro;
	}
	
	public String getUF() {
		return UF;
	}

	public void setUF(String UF) {
		this.UF = UF;
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

	public List<Chamado> getChamados() {
		return chamados;
	}

	public void setChamados(List<Chamado> chamados) {
		this.chamados = chamados;
	}
}
