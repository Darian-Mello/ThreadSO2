package br.edu.ifsul.thread.restaurante;

import java.io.Serializable;
import java.util.ArrayList;

public class Cardapio implements Serializable {
    private ArrayList<Prato> pratos;

    public Cardapio () {
        geraPratos();
    }

    public void geraPratos () {
        Prato p = new Prato();
        pratos = new ArrayList<>();

        p.setNome("Pão de queijo");
        p.setIngredientes("farinha, queijo");
        p.setPreco(10.0);
        p.setTempoPreparo(3);
        p.setNumero(1);
        pratos.add(p);

        p = new Prato();
        p.setNome("Pastel");
        p.setIngredientes("Massa, carne, ovo");
        p.setPreco(15.0);
        p.setTempoPreparo(5);
        p.setNumero(2);
        pratos.add(p);

        p = new Prato();
        p.setNome("Pizza");
        p.setIngredientes("Massa, calabresa, ovo, maionese");
        p.setPreco(20.0);
        p.setTempoPreparo(8);
        p.setNumero(3);
        pratos.add(p);
    }

    public ArrayList<Prato> getPratos() {
        return pratos;
    }

    public void setPratos(ArrayList<Prato> pratos) {
        this.pratos = pratos;
    }
}
