package com.example.backend_projeto_EUNICE_KATLEEN.Entities;

public class Sobre {
    private String[] integrantes = {"Eunice","Katleen"};
    private String nome_projeto = "Trabalho Frutas";

    public String[] getIntegrantes() {
        return integrantes;
    }

    public void setIntegrantes(String[] integrantes) {
        this.integrantes = integrantes;
    }

    public String getNome_projeto() {
        return nome_projeto;
    }

    public void setNome_projeto(String nome_projeto) {
        this.nome_projeto = nome_projeto;
    }
}