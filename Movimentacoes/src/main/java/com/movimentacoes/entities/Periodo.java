/**
 * 
 */
package com.movimentacoes.entities;

/**
 * @author Daniel Farcas de Almeida Queiroz [ danielfaq@gmail.com ]<br/><br/>
 * Primeira versão de classe: 9 de dez de 2015<br/> 
 */
public class Periodo {

	private Filial filial;
	
	private Float totalPeriodo = new Float(0F);
	
	private Float totalPorMes = new Float(0F);
	
	private Float resultadoVendas = new Float(0F);
	

	public Filial getFilial() {
		return filial;
	}

	public void setFilial(Filial filial) {
		this.filial = filial;
	}

	public Float getTotalPeriodo() {
		return totalPeriodo;
	}

	public void setTotalPeriodo(Float totalPeriodo) {
		this.totalPeriodo = totalPeriodo;
	}

	public Float getResultadoVendas() {
		return resultadoVendas;
	}

	public void setResultadoVendas(Float resultadoVendas) {
		this.resultadoVendas = resultadoVendas;
	}

	public Float getTotalPorMes() {
		return totalPorMes;
	}

	public void setTotalPorMes(Float totalPorMes) {
		this.totalPorMes = totalPorMes;
	}	
}
