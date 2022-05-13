package br.edu.ifsul.thread.restaurante;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {
    public static void main(String[] args) {
        BlockingQueue<Pedido> pedidos = new ArrayBlockingQueue<>(2);
        Boolean pedidosSendoFeitos = true;

        ProdutorPedidos produtor = new ProdutorPedidos(pedidos, pedidosSendoFeitos);
        ConsumidorPedidos consumidor = new ConsumidorPedidos(pedidos, pedidosSendoFeitos);
        //ConsumidorPedidos consumidor2 = new ConsumidorPedidos(pedidos, pedidosSendoFeitos);

        produtor.start();
        consumidor.start();
        //consumidor2.start();

    }
}