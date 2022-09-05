package com.calife.anamnesis.domain.enums;

public enum Pele {
	
	OLEOSA(0, "OLEOSA"), SECA(1, "SECA"), MISTA(2, "MISTA");

	private Integer codigo;
	private String descricao;
	
	private Pele(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public static Pele toEnaum(Integer cod) {
		if(cod == null) {
			return null;
		}

		for(Pele x : Pele.values()) {
			if(cod.equals(x.getCodigo())) {
				return x; 
			}
		}
		
		throw new IllegalArgumentException("Pele inválida");
	}
}
