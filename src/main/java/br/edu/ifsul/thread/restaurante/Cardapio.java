package br.edu.ifsul.thread.restaurante;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Tal classe cria diversos pratos de forma estática.
 * Tais pratos podem ser utilizados nos pedidos.
 * @author Dariãn e Elias
 */
public class Cardapio implements Serializable {
    private ArrayList<Prato> pratos;

    public Cardapio () {
        geraPratos();
    }

    public void geraPratos () {
        Prato p = new Prato();
        pratos = new ArrayList<>();

        p.setNome("Feijão");
        p.setPreco(5.0);
        p.setTempoPreparo(3);
        p.setNumero(1);
        pratos.add(p);

        p = new Prato();
        p.setNome("Arroz");
        p.setPreco(5.0);
        p.setTempoPreparo(3);
        p.setNumero(2);
        pratos.add(p);

        p = new Prato();
        p.setNome("Mandioca Frita");
        p.setPreco(4.0);
        p.setTempoPreparo(3);
        p.setNumero(3);
        pratos.add(p);

        p = new Prato();
        p.setNome("Batata Frita");
        p.setPreco(6.0);
        p.setTempoPreparo(3);
        p.setNumero(4);
        pratos.add(p);

        p = new Prato();
        p.setNome("Queijo Frito");
        p.setPreco(5.0);
        p.setTempoPreparo(3);
        p.setNumero(5);
        pratos.add(p);

        p = new Prato();
        p.setNome("Saladas");
        p.setPreco(3.0);
        p.setTempoPreparo(1);
        p.setNumero(6);
        pratos.add(p);

        p = new Prato();
        p.setNome("Frango Grelhado");
        p.setPreco(8.0);
        p.setTempoPreparo(5);
        p.setNumero(7);
        pratos.add(p);

        p = new Prato();
        p.setNome("Frango à Passarinho");
        p.setPreco(8.0);
        p.setTempoPreparo(5);
        p.setNumero(8);
        pratos.add(p);

        p = new Prato();
        p.setNome("Bife Acebolado");
        p.setPreco(10.0);
        p.setTempoPreparo(5);
        p.setNumero(9);
        pratos.add(p);

        p = new Prato();
        p.setNome("Bife à Parmegiana");
        p.setPreco(10.0);
        p.setTempoPreparo(5);
        p.setNumero(10);
        pratos.add(p);

        p = new Prato();
        p.setNome("Lasanha");
        p.setPreco(9.0);
        p.setTempoPreparo(4);
        p.setNumero(11);
        pratos.add(p);
    }

    public ArrayList<Prato> getPratos() {
        return pratos;
    }

    public void setPratos(ArrayList<Prato> pratos) {
        this.pratos = pratos;
    }
}
