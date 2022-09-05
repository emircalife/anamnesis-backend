package com.calife.anamnesis.domain.dtos;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import com.calife.anamnesis.domain.Anamnese;
import com.fasterxml.jackson.annotation.JsonFormat;

public class AnamneseDTO  implements Serializable{

	private static final long serialVersionUID = 1L;
	
	protected Integer id;
	@NotNull(message = "Campo DESCRIÇÃO é requerido")
	protected String descricao;
	@NotNull(message = "Campo OBRIGATORIEDADE é requerido")
	protected boolean obrigatorio;
	@NotNull(message = "Campo EXCLUDENTE é requerido")
	protected boolean excludente;
	protected String observacoes;
	
	@NotNull(message = "Campo DATA DA ANAMNESE é requerido")
	@JsonFormat(pattern = "dd/MM/yyyy")
	protected LocalDate dataAnamnese = LocalDate.now();
	@NotNull(message = "O campo TECNICO é requerido")
	private Integer tecnico;
	@NotNull(message = "O campo CLIENTE é requerido")
	private Integer cliente;
	private String nomeTecnico;
	private String nomeCliente;
	
	public AnamneseDTO() {
		super();
	}

	public AnamneseDTO(Anamnese obj) {
		this.id =  obj.getId();
		this.descricao = obj.getDescricao();
		this.obrigatorio = obj.isObrigatorio();
		this.excludente = obj.isExcludente();
		this.observacoes =  obj.getObservacoes();
		this.dataAnamnese = obj.getDataAnamnese();
		
		this.tecnico = obj.getTecnico().getId();
		this.cliente = obj.getCliente().getId();
		this.nomeTecnico = obj.getTecnico().getNome();
		this.nomeCliente = obj.getCliente().getNome();		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isObrigatorio() {
		return obrigatorio;
	}

	public void setObrigatorio(boolean obrigatorio) {
		this.obrigatorio = obrigatorio;
	}

	public boolean isExcludente() {
		return excludente;
	}

	public void setExcludente(boolean excludente) {
		this.excludente = excludente;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public LocalDate getDataAnamnese() {
		return dataAnamnese;
	}

	public void setDataAnamnese(LocalDate dataAnamnese) {
		this.dataAnamnese = dataAnamnese;
	}

	public Integer getTecnico() {
		return tecnico;
	}

	public void setTecnico(Integer tecnico) {
		this.tecnico = tecnico;
	}

	public Integer getCliente() {
		return cliente;
	}

	public void setCliente(Integer cliente) {
		this.cliente = cliente;
	}

	public String getNomeTecnico() {
		return nomeTecnico;
	}

	public void setNomeTecnico(String nomeTecnico) {
		this.nomeTecnico = nomeTecnico;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
}
	
	
	
	
	
	