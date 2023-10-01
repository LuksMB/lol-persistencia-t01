package com.projeto.persistencia;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MostrarHashSHA256 {
    public static void main() {
        String nomeArquivoCSV = "entidades.csv";
        try {

            FileInputStream arquivoCSV = new FileInputStream(nomeArquivoCSV);
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            byte[] buffer = new byte[8192];
            int tamanho;
            
            while ((tamanho = arquivoCSV.read(buffer)) > 0) {
                digest.update(buffer, 0, tamanho);

            }

            byte[] hash = digest.digest();
            String hashHex = bytesParaHex(hash);

            System.out.println("\nHash SHA-256 do arquivo " + nomeArquivoCSV + ": " + hashHex);
            arquivoCSV.close();

        } catch (IOException | NoSuchAlgorithmException e) {
            System.err.println("\nErro: " + e);
        }
    }

    // Converte um array de bytes em uma representação hexadecimal
    public static String bytesParaHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder(2 * bytes.length);
        for (byte b : bytes) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}

