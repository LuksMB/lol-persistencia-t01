package com.projeto.persistencia;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ContarEntidades {
    public static void main() {
        int contador = 0;

        try {
            BufferedReader br = new BufferedReader(new FileReader("entidades.csv"));
            String linha;
            linha = br.readLine(); //pular o cabeçalho

            while ((linha = br.readLine()) != null) {
                String[] colunas = linha.split(",",1);

                for (int i = 0; i < colunas.length; i++) {
                    contador++;
                }

            }
            br.close();
        } catch (IOException e) {
            System.err.println("Erro ao recuperar a quantidade de elementos.");
        } 
        System.out.println("Numero de elementos é: " + contador);
    }
}
