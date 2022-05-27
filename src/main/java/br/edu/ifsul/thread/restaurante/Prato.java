package br.edu.ifsul.thread.restaurante;

import java.io.Serializable;

/**
 * Tal classe contém as variáveis utilizadas para cada prato.
 * Cada prato recebe um nome, valor, tempo de preparo e numero (id).
 * @author Dariãn e Elias
 */
public class Prato implements Serializable {
    private String nome;
    private Integer tempoPreparo;
    private Double Preco;
    private Integer numero;

    public Prato () {

    }

    public Integer getTempoPreparo() {
        return tempoPreparo;
    }

    public void setTempoPreparo(Integer tempoPreparo) {
        this.tempoPreparo = tempoPreparo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return Preco;
    }

    public void setPreco(Double preco) {
        Preco = preco;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }
}
