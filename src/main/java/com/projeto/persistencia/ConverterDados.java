package com.projeto.persistencia;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import com.projeto.persistencia.Models.Champion;
import com.projeto.persistencia.Models.Champions;

public class ConverterDados {
   
    public static void main() throws IOException {

       
        List<Champion> champions = readDataFromCSV("entidades.csv");

        Champions championsList = new Champions();
        championsList.setChampions(champions);
        

        //Converter para XML
        XmlMapper xmlMapper = new XmlMapper();

        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);

        File outputFileXml = new File("personagens.xml");

        xmlMapper.writeValue(outputFileXml, championsList);


        //Converter para Json

        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        File outputFileJson = new File("personagens.json");

        objectMapper.writeValue(outputFileJson, championsList);

    }

    private static List<Champion> readDataFromCSV(String csvFile) throws IOException {

        List<Champion> champions = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(csvFile));
        String line = reader.readLine();

        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length == 8) {
                Champion champion = new Champion();
                champion.setId(Integer.parseInt(parts[0]));
                champion.setName(parts[1]);
                champion.setPosition(parts[2]);
                champion.setSpecies(parts[3]);
                champion.setRange(parts[4]);
                champion.setRegion(parts[5]);
                champion.setResource(parts[6]);
                champion.setCreationDate(parts[7]);

                champions.add(champion);
            }
        }
        reader.close();

        return champions;
    }
}
