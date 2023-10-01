package com.projeto.persistencia.Models;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.List;

public class Champions {
    private List<Champion> champions;

    @JacksonXmlElementWrapper(localName = "Champions")
    @JacksonXmlProperty(localName = "Champion")
    public List<Champion> getChampions() {
        return champions;
    }

    public void setChampions(List<Champion> champions) {
        this.champions = champions;
    }

    public Champions() {
    }

    public Champions(List<Champion> champions) {
        this.champions = champions;
    }
}
