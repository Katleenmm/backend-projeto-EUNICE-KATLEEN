package com.example.backend_projeto_EUNICE_KATLEEN.Entities;

public class Fruta {
    private String name;
    private Integer id;
    private String family;
    private String order;
    private String genus;

    public Fruta(String name, String order, String genus){
        this.name = name;
        this.id = id;
        this.order = order;
        this.genus = genus;
        //this.nutritions = nutritions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getGenus() {
        return genus;
    }

    public void setGenus(String genus) {
        this.genus = genus;
    }
}