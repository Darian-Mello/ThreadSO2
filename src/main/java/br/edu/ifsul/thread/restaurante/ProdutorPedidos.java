package br.edu.ifsul.thread.restaurante;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class ProdutorPedidos extends Thread {
    private BlockingQueue<Pedido> pedidos = null;
    private Cardapio cardapio = new Cardapio();

    public ProdutorPedidos(BlockingQueue pedidos) {
        this.pedidos = pedidos;
    }

    @Override
    public void run() {
        try {
            Pedido p;
            mostraPratos();
            for (int i = 1; i <= 8; i++) {
                p = montaPedido();
                p.setHora(Calendar.getInstance());
                p.setNumero(i);

                pedidos.put(p);
                System.out.println("\nPedido nº " + i + " foi inserido na fila, seus pratos: " +
                    p.getPratos().get(0).getNome() + ", " + p.getPratos().get(1).getNome() + ", " + p.getPratos().get(2).getNome() + ";");

                TimeUnit.SECONDS.sleep(1);
            }
            p = new Pedido();
            p.setNumero(0);
            pedidos.put(p);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Pedido montaPedido () throws Exception {
        Pedido p = new Pedido();
        ArrayList<Prato> pratosDoPedido = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            pratosDoPedido.add(cardapio.getPratos().get((int)Math.floor(Math.random() * cardapio.getPratos().size())));
        }
        p.setPratos(pratosDoPedido);

        return p;
    }

    public void mostraPratos () {
        System.out.println("Pratos do dia:");
        for (Prato prato: cardapio.getPratos()) {
            System.out.println( prato.getNumero() + " - " + prato.getNome() + " - Tempo de preparo: " + prato.getTempoPreparo()  + "s - Preço: " +
                    prato.getPreco());
        }
    }
}
