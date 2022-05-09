package br.edu.ifsul.thread.restaurante;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProdutorPedidos extends Thread {
    private BlockingQueue<Pedido> pedidos = null;

    public ProdutorPedidos(BlockingQueue pedidos) {
        this.pedidos = pedidos;
    }

    @Override
    public void run() {
        try {
            Pedido p = new Pedido();
            p.setObs("teste01");
            pedidos.put(p);
            Thread.sleep(5000);
            pedidos.put(p);
            Thread.sleep(5000);
            pedidos.put(p);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
