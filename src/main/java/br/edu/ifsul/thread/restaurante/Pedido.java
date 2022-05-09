package br.edu.ifsul.thread.restaurante;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

public class Pedido implements Serializable {
    private Cliente cliente;
    private ArrayList<Prato> pratos;
    private Calendar hora;
    private String obs;

    public Pedido () {

    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
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
