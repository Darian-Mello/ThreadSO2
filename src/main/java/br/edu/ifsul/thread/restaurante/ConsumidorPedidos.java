package br.edu.ifsul.thread.restaurante;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

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
                p = (Pedido) pedidos.take();
                if (p.getNumero() == 0) {
                    System.out.println("\nCozinheiro " + this.getName() + " encerrou os trabalhos.");
                    pedidos.put(p);
                    return;
                }

                Integer tempoPreparo = 0;
                for (Prato prato : p.getPratos()) {
                    tempoPreparo += prato.getTempoPreparo();
                }

                System.out.println("\nPedido nº" + p.getNumero() + " esta sendo feito pelo cozinheiro: " + this.getName());
                TimeUnit.SECONDS.sleep(tempoPreparo);
                System.out.println("\nO pedido nº: " + p.getNumero() + " foi finalizado pelo cozinheiro " + this.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
