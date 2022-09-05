package com.calife.anamnesis.domain.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.calife.anamnesis.domain.Pigmento;

public class PigmentoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	protected Integer id;
	@NotNull(message = "O campo DESCRICAO é requerido")
	private String  descricao;
	@NotNull(message = "O campo ATIVO é requerido")
	private boolean ativo;
	
	public PigmentoDTO() {
		super();
	}

	public PigmentoDTO(Pigmento obj) {
		super();
		this.id = obj.getId();
		this.descricao = obj.getDescricao();
		this.ativo = obj.isAtivo();
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
