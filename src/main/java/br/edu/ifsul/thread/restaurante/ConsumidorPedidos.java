package br.edu.ifsul.thread.restaurante;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ConsumidorPedidos extends Thread {
    private BlockingQueue pedidos = null;
    private Boolean pedidosSendoFeitos = false;

    public ConsumidorPedidos(BlockingQueue pedidos, Boolean pedidosSendoFeitos) {
        this.pedidos = pedidos;
        this.pedidosSendoFeitos = pedidosSendoFeitos;
    }

    @Override
    public void run() {
        try {
            Pedido p;
            while (true) {
                if (!this.pedidosSendoFeitos && pedidos.isEmpty()) {
                    System.out.println("saiu");
                    break;
                }

                p = new Pedido();
                System.out.println("esperando");
                p = (Pedido) pedidos.take();
                Integer tempoPreparo = 0;

                for (Prato prato:p.getPratos()) {
                    tempoPreparo += prato.getTempoPreparo();
                }
                System.out.println("Pedido " + p.getNumero() + " sendo feito!" );
                Thread.sleep(tempoPreparo);
                System.out.println("Saindo Pedido: " + p.getNumero());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
