package com.movimentacoes.calculo;

import com.movimentacoes.run.*;
import static junit.framework.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.movimentacoes.entities.Filial;
import com.movimentacoes.entities.Periodo;
import com.movimentacoes.util.Calculador;

/**
 * @author Daniel Farcas de Almeida Queiroz [ danielfaq@gmail.com ]<br/>
 *         <br/>
 *         Primeira versão de classe: 10 de dez de 2015<br/>
 */
public class MovimentacoesTest {
	
	Calculador calculador;
	
	@Before
	public void beforeTest() {
		calculador = new Calculador();
		calculador.lerArquivo();
	}
	
	
	
	@Test
	public void testMaisVendeu() {
		
		List<Filial> brasilia = calculador.separarLista(".[@cidade='Brasilia']");
		List<Filial> saopaulo = calculador.separarLista(".[@cidade='São Paulo']");
		List<Filial> salvador = calculador.separarLista(".[@cidade='Salvador']");
		List<Filial> rio = calculador.separarLista(".[@cidade='Rio de Janeiro']");
		List<Filial> fortaleza = calculador.separarLista(".[@cidade='Fortaleza']");
		List<Filial> goiania = calculador.separarLista(".[@cidade='Goiânia']");
		List<Filial> beloHorizonte = calculador.separarLista(".[@cidade='Belo Horizonte']");
		
		List<Periodo> periodoMaisVendeu = new ArrayList<Periodo>();
		
		periodoMaisVendeu.add(calculador.somarPeriodo(brasilia));
		periodoMaisVendeu.add(calculador.somarPeriodo(saopaulo));
		periodoMaisVendeu.add(calculador.somarPeriodo(salvador));
		periodoMaisVendeu.add(calculador.somarPeriodo(rio));
		periodoMaisVendeu.add(calculador.somarPeriodo(fortaleza));
		periodoMaisVendeu.add(calculador.somarPeriodo(goiania));
		periodoMaisVendeu.add(calculador.somarPeriodo(beloHorizonte));
		
		Periodo maisVendeu = calculador.maisVendeuNoPeriodo(periodoMaisVendeu);
		
		assertEquals("Belo Horizonte", maisVendeu.getFilial().getCidade());
		
	}
	
	
	@Test
	public void testMaisCresceu() {
		
		List<Filial> brasilia = calculador.separarLista(".[@cidade='Brasilia']");
		List<Filial> saopaulo = calculador.separarLista(".[@cidade='São Paulo']");
		List<Filial> salvador = calculador.separarLista(".[@cidade='Salvador']");
		List<Filial> rio = calculador.separarLista(".[@cidade='Rio de Janeiro']");
		List<Filial> fortaleza = calculador.separarLista(".[@cidade='Fortaleza']");
		List<Filial> goiania = calculador.separarLista(".[@cidade='Goiânia']");
		List<Filial> beloHorizonte = calculador.separarLista(".[@cidade='Belo Horizonte']");
		
		List<Periodo> periodoMaisCresceu = new ArrayList<Periodo>();
		
		periodoMaisCresceu.add(calculador.calcularResultadoDeVendas(brasilia));
		periodoMaisCresceu.add(calculador.calcularResultadoDeVendas(saopaulo));
		periodoMaisCresceu.add(calculador.calcularResultadoDeVendas(salvador));
		periodoMaisCresceu.add(calculador.calcularResultadoDeVendas(rio));
		periodoMaisCresceu.add(calculador.calcularResultadoDeVendas(fortaleza));
		periodoMaisCresceu.add(calculador.calcularResultadoDeVendas(goiania));
		periodoMaisCresceu.add(calculador.calcularResultadoDeVendas(beloHorizonte));
		
		Periodo maisCresceu = calculador.maisCresceuNoPeriodo(periodoMaisCresceu);
		
		assertEquals("Belo Horizonte", maisCresceu.getFilial().getCidade());
	}
	
	
	@Test
	public void testMenosCresceu() {
		
		List<Filial> brasilia = calculador.separarLista(".[@cidade='Brasilia']");
		List<Filial> saopaulo = calculador.separarLista(".[@cidade='São Paulo']");
		List<Filial> salvador = calculador.separarLista(".[@cidade='Salvador']");
		List<Filial> rio = calculador.separarLista(".[@cidade='Rio de Janeiro']");
		List<Filial> fortaleza = calculador.separarLista(".[@cidade='Fortaleza']");
		List<Filial> goiania = calculador.separarLista(".[@cidade='Goiânia']");
		List<Filial> beloHorizonte = calculador.separarLista(".[@cidade='Belo Horizonte']");
		
		List<Periodo> periodoMenosCresceu = new ArrayList<Periodo>();
		
		periodoMenosCresceu.add(calculador.calcularResultadoDeVendas(brasilia));
		periodoMenosCresceu.add(calculador.calcularResultadoDeVendas(saopaulo));
		periodoMenosCresceu.add(calculador.calcularResultadoDeVendas(salvador));
		periodoMenosCresceu.add(calculador.calcularResultadoDeVendas(rio));
		periodoMenosCresceu.add(calculador.calcularResultadoDeVendas(fortaleza));
		periodoMenosCresceu.add(calculador.calcularResultadoDeVendas(goiania));
		periodoMenosCresceu.add(calculador.calcularResultadoDeVendas(beloHorizonte));
		
		Periodo menosCresceu = calculador.menosCresceuNoPeriodo(periodoMenosCresceu);
		
		assertEquals("Goiânia", menosCresceu.getFilial().getCidade());		
	}
	
	
	@Test
	public void testMaisCresceuNoMes() {
		
		List<Filial> janeiro = calculador.separarLista(".[@periodo='Janeiro']");
		List<Filial> fevereiro = calculador.separarLista(".[@periodo='Fevereiro']");
		List<Filial> marco = calculador.separarLista(".[@periodo='Março']");
		
		List<Periodo> mesQueMaisCresceu = new ArrayList<Periodo>();		
		
		mesQueMaisCresceu.add(calculador.somaPorMes(janeiro));
		mesQueMaisCresceu.add(calculador.somaPorMes(fevereiro));
		mesQueMaisCresceu.add(calculador.somaPorMes(marco));
		
		Periodo cresceuNoMes = calculador.maisVendidoNoMes(mesQueMaisCresceu);
		
		assertEquals("Março", cresceuNoMes.getFilial().getPeriodo());	
	}

}
