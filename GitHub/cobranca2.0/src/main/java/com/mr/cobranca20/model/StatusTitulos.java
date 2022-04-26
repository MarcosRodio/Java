package com.mr.cobranca20.model;

public enum StatusTitulos {
	
	PENDENTE("Pendente"),
	RECEBIDO("Recebido");
	
	private String descricao;
	
	//construtor  
	StatusTitulos(String descricao) {
		this.descricao = descricao;
	}

		
	public String getDescricao() {
		return descricao;
	}

}
