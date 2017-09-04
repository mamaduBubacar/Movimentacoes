/**
 *
 */
package com.movimentacoes.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.jxpath.JXPathContext;

import com.movimentacoes.entities.Filial;
import com.movimentacoes.entities.Periodo;

/**
 * @author Daniel Farcas de Almeida Queiroz [ danielfaq@gmail.com ]<br/><br/>
 * Primeira versão de classe: 9 de dez de 2015<br/>
 */
public class Calculador {

    private List<Filial> filiaisArquivo;
    private String fileName;

    public Calculador() {}

    public Calculador(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Metodo que lê o arquivo e trasforma em uma lista de objetos
     *
     * @return Lista de todas as filiais do arquivo
     * @throws IOException
     */
    public void lerArquivo() {

        filiaisArquivo = new ArrayList<Filial>();

        try {
            Scanner scanner = null;
            if ((fileName == null)
                    || (fileName.isEmpty())) {
                scanner = new Scanner(new FileReader("src" + File.separator + "main" + File.separator
                        + "webapp" + File.separator + "WEB-INF" + File.separator + "uploads" + File.separator + "movimentacoes-1.txt"));
            } else {
                scanner = new Scanner(new FileReader(this.fileName));
            }

            scanner.nextLine();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] valores = line.split("\t");
                Filial f = new Filial(valores[0], valores[1], new Float(valores[2].replace(".", "").replace(",", ".")));
                filiaisArquivo.add(f);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public List<Filial> separarLista(String criterio) {
        @SuppressWarnings({"unchecked"})
        List<Filial> filtered = JXPathContext.newContext(filiaisArquivo).selectNodes(criterio);

        Collections.sort(filtered, new Comparator<Filial>() {
            @Override
            public int compare(Filial f1, Filial f2) {

                return f1.getCidade().compareTo(f2.getCidade());
            }
        });
        return filtered;
    }

    public Periodo somarPeriodo(List<Filial> filiais) {

        Periodo periodo = new Periodo();

        for (Filial f : filiais) {
            periodo.setTotalPeriodo(periodo.getTotalPeriodo() + f.getTotal());
        }

        periodo.setFilial(filiais.get(0));

        return periodo;
    }

    public Periodo maisVendeuNoPeriodo(List<Periodo> periodos) {

        Collections.sort(periodos, new Comparator<Periodo>() {
            @Override
            public int compare(Periodo p1, Periodo p2) {

                return p2.getTotalPeriodo().compareTo(p1.getTotalPeriodo());
            }
        });
        return periodos.get(0);
    }

    public Periodo calcularResultadoDeVendas(List<Filial> filiais) {

        Periodo periodo = new Periodo();
        Float resultado = new Float(0F);
        for (Filial f : filiais) {
            resultado = periodo.getResultadoVendas() + f.getTotal();
        }
        periodo.setResultadoVendas(resultado / filiais.size());
        periodo.setFilial(filiais.get(0));

        return periodo;
    }

    public Periodo maisCresceuNoPeriodo(List<Periodo> periodos) {

        Collections.sort(periodos, new Comparator<Periodo>() {
            @Override
            public int compare(Periodo p1, Periodo p2) {

                return p2.getResultadoVendas().compareTo(p1.getResultadoVendas());
            }
        });
        return periodos.get(0);
    }

    public Periodo menosCresceuNoPeriodo(List<Periodo> periodos) {

        Collections.sort(periodos, new Comparator<Periodo>() {
            @Override
            public int compare(Periodo p1, Periodo p2) {

                return p1.getResultadoVendas().compareTo(p2.getResultadoVendas());
            }
        });
        return periodos.get(0);
    }

    public Periodo somaPorMes(List<Filial> filiais) {

        Periodo periodo = new Periodo();

        for (Filial f : filiais) {
            periodo.setTotalPorMes(periodo.getTotalPorMes() + f.getTotal());
        }

        periodo.setFilial(filiais.get(0));

        return periodo;
    }

    public Periodo maisVendidoNoMes(List<Periodo> periodos) {

        Collections.sort(periodos, new Comparator<Periodo>() {
            @Override
            public int compare(Periodo p1, Periodo p2) {

                return p2.getTotalPorMes().compareTo(p1.getTotalPorMes());
            }
        });
        return periodos.get(0);
    }
}
