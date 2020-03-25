package com.projeto.ia.redes.neurais;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class Leitura {

    String caminhoArquivo;
    List<Double> dados = new ArrayList<>();
    String target;

    public Leitura(String caminhoArquivo) {
        this.caminhoArquivo = caminhoArquivo;
    }

    public List<String[]> dadosCSV(){
        try {
            Reader reader = new FileReader(caminhoArquivo);
            CSVReader csvReader = new CSVReader(reader);
            return csvReader.readAll();
        }catch (Exception e ){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<Double> gerarDadosEntrada(String [] linhas){
        //System.out.println("LINHA 1 \n");
        for (int i = 0; i < linhas.length - 1 ; i++) {
            Double numero = Double.parseDouble(linhas[i].replaceAll("\\uFEFF", ""));
            dados.add(numero);
            //System.out.println("linha["+i+"]: "+ dados.get(i));
        }
        setTarget(linhas[linhas.length - 1]);
        return dados;
    }

    public void setTarget(String letra){
        this.target = letra;
        System.out.println("Letra: "+letra);
    }

    public String getTarget() {
        return target;
    }
}
