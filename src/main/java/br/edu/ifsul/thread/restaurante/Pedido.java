package br.edu.ifsul.thread.restaurante;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

public class Pedido implements Serializable {
    private Cozinheiro cliente;
    private ArrayList<Prato> pratos;
    private Calendar hora;
    private Integer numero;

    public Pedido () {

    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Cozinheiro getCliente() {
        return cliente;
    }

    public void setCliente(Cozinheiro cliente) {
        this.cliente = cliente;
    }

    public ArrayList<Prato> getPratos() {
        return pratos;
    }

    public void setPratos(ArrayList<Prato> pratos) {
        this.pratos = pratos;
    }

    public Calendar getHora() {
        return hora;
    }

    public void setHora(Calendar hora) {
        this.hora = hora;
    }
}
