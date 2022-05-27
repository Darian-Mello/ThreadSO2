package br.edu.ifsul.thread.restaurante;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Tal classe cria um Array onde serão armazenados todos os pedidos.
 * Cada pedido recebe um numero (id).
 * @author Dariãn e Elias
 */
public class Pedido implements Serializable {
    private ArrayList<Prato> pratos;
    private Integer numero;

    public Pedido () {

    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public ArrayList<Prato> getPratos() {
        return pratos;
    }

    public void setPratos(ArrayList<Prato> pratos) {
        this.pratos = pratos;
    }
}
