package com.movimentacoes.entities;

public class Filial {
	
	private String cidade;
	
	private String periodo;
	
	private Float total;
	
	public Filial(){}
	
	public Filial(String cidade, String periodo, Float total) {
		
		this.cidade = cidade;
		this.periodo = periodo;
		this.total = total;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public Float getTotal() {
		return total;
	}

	public void setTotal(Float total) {
		this.total = total;
	}
}
