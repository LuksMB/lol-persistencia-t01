package com.projeto.persistencia;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class CompactarCSV {

    public static void main() {
        String nomeArquivoCSV = "entidades.csv";
        String nomeArquivoZIP = "entidades.zip";

        try {
            FileInputStream arquivoCSV = new FileInputStream(nomeArquivoCSV);
            FileOutputStream arquivoZIP = new FileOutputStream(nomeArquivoZIP);
            ZipOutputStream zipOutputStream = new ZipOutputStream(arquivoZIP);

            // Define o nome do arquivo dentro do ZIP
            ZipEntry zipEntry = new ZipEntry(nomeArquivoCSV);
            zipOutputStream.putNextEntry(zipEntry);

            byte[] buffer = new byte[8192];
            int tamanho;

            while ((tamanho = arquivoCSV.read(buffer)) > 0) {
                zipOutputStream.write(buffer, 0, tamanho);
            }

            zipOutputStream.close();
            arquivoCSV.close();
            System.out.println("\nArquivo CSV compactado com sucesso para " + nomeArquivoZIP);
        
        } catch (IOException e) {
            System.err.println("\nCompactação falhou! --> Erro: " + e);
        }
    }
}
