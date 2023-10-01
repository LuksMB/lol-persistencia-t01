package com.projeto.persistencia.Models;

import java.io.Serializable;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Champion implements Serializable{
    private int id;
    private String name;
    private String position;
    private String species;
    private String range;
    private String region;
    private String resource;
    private String creationDate;

    public Champion(){};
    
    public Champion(int id, String name, String position, String species, String range, String region, String resource,String creationDate) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.species = species;
        this.range = range;
        this.region = region;
        this.resource = resource;
        this.creationDate = creationDate;
    }

    

    @Override
    public String toString() {
        return "Champion [id=" + id + ", name=" + name + ", position=" + position + ", species=" + species + ", range="
                + range + ", region=" + region + ", recurso=" + resource + ", creationDate=" + creationDate + "]";
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    @JacksonXmlProperty(localName = "Name")
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }
    public String getSpecies() {
        return species;
    }
    public void setSpecies(String species) {
        this.species = species;
    }
    public String getRange() {
        return range;
    }
    public void setRange(String range) {
        this.range = range;
    }
    public String getRegion() {
        return region;
    }
    public void setRegion(String region) {
        this.region = region;
    }
    
    public String getCreationDate() {
        return creationDate;
    }
    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }
    
    
    

}