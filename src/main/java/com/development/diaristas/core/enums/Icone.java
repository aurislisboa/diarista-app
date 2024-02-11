package com.development.diaristas.core.enums;

public enum Icone {

    CLEANING_1("cleaning_1"),
    CLEANING_2("cleaning_2"),
    CLEANING_3("cleaning_3");


    private String nome;

    private Icone(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

}
