/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movimentacoes.bo;

import com.movimentacoes.entities.Filial;
import com.movimentacoes.entities.Periodo;
import com.movimentacoes.util.Calculador;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 *
 * @author Mamadu
 */
public class UploadBO {

    //Constructor Default
    public UploadBO() {}

    public void executar(String fileName) throws Exception {

        try{
        Calculador calculador = new Calculador(fileName);
        calculador.lerArquivo();
        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

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

        System.out.println("Mais Vendeu: " + maisVendeu.getFilial().getCidade() + ": " + nf.format(maisVendeu.getTotalPeriodo()));

        List<Periodo> periodoMaisCresceu = new ArrayList<Periodo>();

        periodoMaisCresceu.add(calculador.calcularResultadoDeVendas(brasilia));
        periodoMaisCresceu.add(calculador.calcularResultadoDeVendas(saopaulo));
        periodoMaisCresceu.add(calculador.calcularResultadoDeVendas(salvador));
        periodoMaisCresceu.add(calculador.calcularResultadoDeVendas(rio));
        periodoMaisCresceu.add(calculador.calcularResultadoDeVendas(fortaleza));
        periodoMaisCresceu.add(calculador.calcularResultadoDeVendas(goiania));
        periodoMaisCresceu.add(calculador.calcularResultadoDeVendas(beloHorizonte));

        Periodo maisCresceu = calculador.maisCresceuNoPeriodo(periodoMaisCresceu);

        System.out.println("Mais Cresceu: " + maisCresceu.getFilial().getCidade() + ": " + nf.format(maisCresceu.getResultadoVendas()));

        List<Periodo> periodoMenosCresceu = new ArrayList<Periodo>();

        periodoMenosCresceu.add(calculador.calcularResultadoDeVendas(brasilia));
        periodoMenosCresceu.add(calculador.calcularResultadoDeVendas(saopaulo));
        periodoMenosCresceu.add(calculador.calcularResultadoDeVendas(salvador));
        periodoMenosCresceu.add(calculador.calcularResultadoDeVendas(rio));
        periodoMenosCresceu.add(calculador.calcularResultadoDeVendas(fortaleza));
        periodoMenosCresceu.add(calculador.calcularResultadoDeVendas(goiania));
        periodoMenosCresceu.add(calculador.calcularResultadoDeVendas(beloHorizonte));

        Periodo menosCresceu = calculador.menosCresceuNoPeriodo(periodoMenosCresceu);

        System.out.println("Menos Cresceu: " + menosCresceu.getFilial().getCidade() + ": " + nf.format(menosCresceu.getResultadoVendas()));

        List<Filial> janeiro = calculador.separarLista(".[@periodo='Janeiro']");
        List<Filial> fevereiro = calculador.separarLista(".[@periodo='Fevereiro']");
        List<Filial> marco = calculador.separarLista(".[@periodo='Março']");

        List<Periodo> mesQueMaisCresceu = new ArrayList<Periodo>();

        mesQueMaisCresceu.add(calculador.somaPorMes(janeiro));
        mesQueMaisCresceu.add(calculador.somaPorMes(fevereiro));
        mesQueMaisCresceu.add(calculador.somaPorMes(marco));

        Periodo cresceuNoMes = calculador.maisVendidoNoMes(mesQueMaisCresceu);

        System.out.println("Mês que mais cresceu: " + cresceuNoMes.getFilial().getPeriodo() + ": " + nf.format(cresceuNoMes.getTotalPorMes()));

        System.out.println();
        System.out.println("--------------------------------------- Leitura do Arquivo ---------------------------------------");
        System.out.println();

        for (Filial f : brasilia) {
            System.out.println(f.getCidade() + " " + f.getPeriodo() + ": " + nf.format(f.getTotal()));
        }
        System.out.println();
        for (Filial f : saopaulo) {
            System.out.println(f.getCidade() + " " + f.getPeriodo() + ": " + nf.format(f.getTotal()));
        }
        System.out.println();
        for (Filial f : salvador) {
            System.out.println(f.getCidade() + " " + f.getPeriodo() + ": " + nf.format(f.getTotal()));
        }
        System.out.println();
        for (Filial f : rio) {
            System.out.println(f.getCidade() + " " + f.getPeriodo() + ": " + nf.format(f.getTotal()));
        }
        System.out.println();
        for (Filial f : fortaleza) {
            System.out.println(f.getCidade() + " " + f.getPeriodo() + ": " + nf.format(f.getTotal()));
        }
        System.out.println();
        for (Filial f : goiania) {
            System.out.println(f.getCidade() + " " + f.getPeriodo() + ": " + nf.format(f.getTotal()));
        }
        System.out.println();
        for (Filial f : beloHorizonte) {
            System.out.println(f.getCidade() + " " + f.getPeriodo() + ": " + nf.format(f.getTotal()));
        }
        }catch(Exception e){
            throw new Exception("Ocorreu erro durante calculo: "+e.getMessage());
        }
    }
}
