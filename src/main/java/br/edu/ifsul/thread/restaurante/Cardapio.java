package br.edu.ifsul.thread.restaurante;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Cardapio implements Serializable {
    private ArrayList<Prato> pratos;

    public Cardapio () {

    }

    public ArrayList<Prato> getPratos() {
        pratos = new ArrayList<>();

        Prato p = new Prato();
        p.setNome("Pão de queijo");
        p.setIngredientes("farinha, queijo");
        p.setPreco(10.0);
        p.setTempoPreparo(2000);
        p.setNumero(1);
        pratos.add(p);

        p = new Prato();
        p.setNome("Pastel");
        p.setIngredientes("Massa, carne, ovo");
        p.setPreco(15.0);
        p.setTempoPreparo(6000);
        p.setNumero(2);
        pratos.add(p);

        p = new Prato();
        p.setNome("Pizza");
        p.setIngredientes("Massa, calabresa, ovo, maionese");
        p.setPreco(20.0);
        p.setTempoPreparo(8000);
        p.setNumero(3);
        pratos.add(p);

        return pratos;
    }

    public void setPratos(ArrayList<Prato> pratos) {
        this.pratos = pratos;
    }
}
