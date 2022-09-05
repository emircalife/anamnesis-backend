package com.calife.anamnesis.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Especialidade implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;
	private String nomeEspecialidade;
	@JsonFormat(pattern = "dd/MM/yyyy")
	protected LocalDate dataCadastro = LocalDate.now();
	
	@ManyToMany
	@JoinColumn(name = "tecnico_id")
	private Tecnico tecnico;
	
	public Especialidade() {
		super();
	}

	public Especialidade(Integer id, String nomeEspecialidade, LocalDate dataCadastro, Tecnico tecnico) {
		this.id = id;
		this.nomeEspecialidade = nomeEspecialidade;
		this.dataCadastro = dataCadastro;
		this.tecnico = tecnico;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeEspecialidade() {
		return nomeEspecialidade;
	}

	public void setNomeEspecialidade(String nomeEspecialidade) {
		this.nomeEspecialidade = nomeEspecialidade;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Tecnico getTecnico() {
		return tecnico;
	}

	public void setTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dataCadastro, id, nomeEspecialidade, tecnico);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Especialidade other = (Especialidade) obj;
		return Objects.equals(dataCadastro, other.dataCadastro) && Objects.equals(id, other.id)
				&& Objects.equals(nomeEspecialidade, other.nomeEspecialidade) && Objects.equals(tecnico, other.tecnico);
	}
}