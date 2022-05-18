package br.edu.ifsul.thread.restaurante;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ConsumidorPedidos extends Thread {
    private BlockingQueue pedidos = null;

    public ConsumidorPedidos(Cozinheiro cozinheiro, BlockingQueue pedidos) {
        super(cozinheiro.getNome());
        this.pedidos = pedidos;
    }

    @Override
    public void run() {
        try {
            Pedido p;
            while (true) {
                System.out.println("\nCozinheiro " + this.getName() + " aguardando um pedido.");
                p = (Pedido) pedidos.take();
                System.out.println("\nFila de pedidos: " + pedidos);
                if (p.getNumero() == 0) {
                    System.out.println("\nCozinheiro " + this.getName() + " encerrou os trabalhos.");
                    pedidos.put(p);
                    return;
                }

                Integer tempoPreparo = 0;
                for (Prato prato:p.getPratos()) {
                    tempoPreparo += prato.getTempoPreparo();
                }

                System.out.println("\nPedido nº" + p.getNumero() + " esta sendo feito pelo cozinheiro: " + this.getName());
                Thread.sleep(tempoPreparo);
                System.out.println("\nO pedido nº: " + p.getNumero() + " foi finalizado pelo cozinheiro " + this.getName());

                System.out.println("\nFila de pedidos: " + pedidos);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
