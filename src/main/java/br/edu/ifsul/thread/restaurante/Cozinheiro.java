package br.edu.ifsul.thread.restaurante;

import java.io.Serializable;

public class Cozinheiro implements Serializable {
    private String nome;

    public Cozinheiro () {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
