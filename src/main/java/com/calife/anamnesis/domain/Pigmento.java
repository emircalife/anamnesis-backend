package com.calife.anamnesis.domain;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Pigmento  implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;
	protected String descricao;
	protected boolean ativo;
	
	@ManyToOne
	@JoinColumn(name = "anamnese_id")
	private Anamnese anamnese;
	
	public Pigmento() {
		super();
	}
	
	public Pigmento(Integer id, String descricao, boolean ativo, Anamnese anamnese) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.ativo = ativo;
		this.anamnese = anamnese;
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

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
}
