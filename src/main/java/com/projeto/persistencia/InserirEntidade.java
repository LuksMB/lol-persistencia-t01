package com.projeto.persistencia;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import com.projeto.persistencia.Models.Champion;

public class InserirEntidade {
    private static final String nomeDoArquivo = "entidades.csv";

    public static void main(Scanner scanner) {

        System.out.println("Digite o nome do campeão");
        String name = scanner.nextLine();

        System.out.println("Digite a posição do campeão");
        String position = scanner.nextLine();

        System.out.println("Digite a raça do campeão");
        String species = scanner.nextLine();

        System.out.println("Digite o range do campeão");
        String range = scanner.nextLine();

        System.out.println("Digite a região do campeão");
        String region = scanner.nextLine();

        System.out.println("Digite o recurso do campeão");
        String resource = scanner.nextLine();

        System.out.println("Digite a data de criação do campeão");
        String creationDate = scanner.nextLine();

        int id = recuperarId(); // Recupere o ID do arquivo CSV
        Champion champion = new Champion(id, name, position, species, range, region, resource, creationDate);

        try {
            FileWriter arquivoWriter = new FileWriter(nomeDoArquivo, true);
            PrintWriter gravador = new PrintWriter(arquivoWriter);

            if (champion.getId() == 0) {
                String cabecalho = String.format("ID,NAME,POSITION,SPECIES,RANGE,REGION,RESOURCE,CREATIONDATE");
                gravador.println(cabecalho);
            }

            String linhaCSV = String.format("%s,%s,%s,%s,%s,%s,%s,%s",
                    champion.getId(),
                    champion.getName(), champion.getPosition(),
                    champion.getSpecies(), champion.getRange(), champion.getRegion(), champion.getResource(),
                    champion.getCreationDate());

            gravador.println(linhaCSV);

            gravador.close(); // Feche o PrintWriter para salvar as mudanças no arquivo
            arquivoWriter.close();

        } catch (IOException e) {
            System.err.println("Erro ao adicionar o campeão no arquivo CSV.");
        }
    }

    public static int recuperarId() {
        int proximoId = 0; // Comece com o ID 1 como padrão

        try {
            BufferedReader br = new BufferedReader(new FileReader(nomeDoArquivo));
            String linha;
            boolean primeiraLinha = true;

            while ((linha = br.readLine()) != null) {
                if (primeiraLinha) {
                    primeiraLinha = false; 
                    continue;
                }

                String[] colunas = linha.split(",");

                
                if (colunas.length > 0) {
                    int id = Integer.parseInt(colunas[0]);

                    if (id >= proximoId) {
                        proximoId = id + 1;
                    }
                }
            }

            br.close(); 
        } catch (IOException e) {
            System.err.println("Erro ao recuperar o próximo ID disponível.");
        } catch (NumberFormatException e) {
            System.err.println("Erro ao converter o ID em número inteiro.");
        }

        return proximoId;
    }

}
