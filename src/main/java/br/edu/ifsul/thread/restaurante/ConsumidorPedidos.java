package br.edu.ifsul.thread.restaurante;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ConsumidorPedidos extends Thread {
    private BlockingQueue pedidos = null;

    public ConsumidorPedidos(BlockingQueue pedidos) {
        this.pedidos = pedidos;
    }

    @Override
    public void run() {
        try {
            Pedido p = new Pedido();
            p = (Pedido) pedidos.take();
            System.out.println(p.getObs());
            p = (Pedido) pedidos.take();
            System.out.println(p.getObs());
            p = (Pedido) pedidos.take();
            System.out.println(p.getObs());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
