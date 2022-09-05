package com.calife.anamnesis.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Anamnese implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;
	
	private String descricao;
	private boolean obrigatorio;
	private boolean excludente;
	private String observacoes;
	@JsonFormat(pattern = "dd/MM/yyyy")
	protected LocalDate dataAnamnese = LocalDate.now();
	
	@ManyToOne
	@JoinColumn(name = "tecnico_id")
	private Tecnico tecnico;
	
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
	public Anamnese() {
		super();
	}
	
	public Anamnese(Integer id, String descricao, boolean obrigatorio, boolean excludente, String observacoes, LocalDate dataAnamnese,
			Tecnico tecnico, Cliente cliente) {
		
		super();
		
		this.id = id;
		this.descricao = descricao;
		this.obrigatorio = obrigatorio;
		this.excludente = excludente;
		this.observacoes = observacoes;
		this.dataAnamnese = dataAnamnese;
		this.tecnico = tecnico;
		this.cliente = cliente;
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

	public Tecnico getTecnico() {
		return tecnico;
	}

	public void setTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		
		if (obj == null)
			return false;
		
		if (getClass() != obj.getClass())
			return false;
		
		Anamnese other = (Anamnese) obj;
		
		return Objects.equals(id, other.id);
	}
}
