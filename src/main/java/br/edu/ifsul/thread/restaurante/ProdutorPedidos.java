package br.edu.ifsul.thread.restaurante;

import javax.swing.*;
import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;

public class ProdutorPedidos extends Thread {
    private BlockingQueue<Pedido> pedidos = null;
    private Boolean pedidosSendoFeitos = false;
    private Cardapio cardapio = new Cardapio();
    private ArrayList<Prato> pratosDoDia = new ArrayList<>();
    private String menu = "";

    public ProdutorPedidos(BlockingQueue pedidos, Boolean pedidosSendoFeitos) {
        this.pedidos = pedidos;
        this.pedidosSendoFeitos = pedidosSendoFeitos;
    }

    @Override
    public void run() {
        try {
            Pedido p;
            montaMenu();
            int cont = 0;

            while (this.pedidosSendoFeitos) {
                cont++;
                p = new Pedido();
                p = montaPedido();
                if (p != null) {
                    p.setNumero(cont);
                    pedidos.put(p);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Pedido montaPedido () throws InterruptedException {
        Pedido p = new Pedido();
        String texto;
        ArrayList<Prato> pratosDoPedido = new ArrayList<>();
        Integer numeroPrato;

        do {
            texto = JOptionPane.showInputDialog("Deseja fazer um pedido (0 - Sair, 1 - Sim)? ");
        } while (!texto.equals("0") && !texto.equals("1"));

        if (texto.equals("0")) {
            this.pedidosSendoFeitos = false;
            return null;
        } else {
            texto = JOptionPane.showInputDialog(this.menu);
            pratosDoPedido.add(pratosDoDia.get(Integer.parseInt(texto)-1));
            p.setPratos(pratosDoPedido);

            return p;
        }
    }

    public void montaMenu () {
        this.pratosDoDia = cardapio.getPratos();
        this.menu = "Pratos do dia:\n\n";
        for (Prato prato: this.pratosDoDia) {
            this.menu += prato.getNumero() + " - " + prato.getNome() + " - Tempo de preparo: " + prato.getTempoPreparo()  + " - Preço: " +
                    prato.getPreco() + "\n";
        }

        menu += "\n\nDigite o prato que você deseja: ";
    }

}
