package br.edu.ifsul.thread.restaurante;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Classe utilizada como consumidor (Cozinheiro) dos pedidos gerados pelo produtor (Cliente)
 * Tem como objetivo retirar os pedidos da BlockingQueue e calcular o tempo de preparo de cada pedido somando o tempo de todos os pratos.
 * @author Dariãn e Elias
 */
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

                System.out.println("\nPedido nº" + p.getNumero() + " esta sendo feito pelo cozinheiro: " + this.getName() + ";");
                prepararPedido(tempoPreparo);
                System.out.println("\nO pedido nº: " + p.getNumero() + " foi finalizado pelo cozinheiro " + this.getName() + " (" + tempoPreparo + "s);");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Função que passa o tempo necessário para a conclusão do tempo total do pedido.
     */
    public void prepararPedido (Integer tempoPreparo) throws Exception {
        for(int i=1; i <= tempoPreparo ; i++){
            TimeUnit.SECONDS.sleep(1);
            //System.out.println( "" + this.getName() + ", " + i + "/" + tempoPreparo + "s;" );
        }
    }
}
