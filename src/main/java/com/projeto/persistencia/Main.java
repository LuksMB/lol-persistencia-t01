package com.projeto.persistencia;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1: Inserir entidade no arquivo CSV");
            System.out.println("2: Mostrar a quantidade de entidades existentes no arquivo CSV");
            System.out.println("3: Converter os dados do arquivo CSV para JSON e XML");
            System.out.println("4: Compactar o arquivo CSV em um arquivo ZIP");
            System.out.println("5: Mostrar o hash SHA256 do arquivo CSV");
            System.out.println("6: Encerrar\n");

            String escolha = scanner.nextLine();

            switch (escolha) {
                case "1":
                    InserirEntidade.main(scanner); // Chama o método para inserir entidade
                    break;

                case "2":
                    ContarEntidades.main();
                    break;

                case "3":
                    ConverterDados.main();
                    break;

                case "4":
                    CompactarCSV.main();
                    break;
                    
                case "5":
                    MostrarHashSHA256.main();
                    break;
                    
                case "6":
                    scanner.close();
                    System.exit(0); // Encerra o programa
                    break;
            }
        }
    }
}
