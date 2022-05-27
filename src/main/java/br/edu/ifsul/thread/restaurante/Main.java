package br.edu.ifsul.thread.restaurante;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * A classe Main é utilizada pra iniciar a BlockingQueue, declarar as classes produtor e consumidor
 * e as inicializar.
 * @author Dariãn e Elias
 */
public class Main {
    public static void main(String[] args) {
        BlockingQueue<Pedido> pedidos = new ArrayBlockingQueue<>(3);

        ProdutorPedidos produtor = new ProdutorPedidos(pedidos);

        Cozinheiro c = new Cozinheiro();
        c.setNome("Pedro");
        ConsumidorPedidos consumidor = new ConsumidorPedidos(c, pedidos);

        c = new Cozinheiro();
        c.setNome("Carlos");
        ConsumidorPedidos consumidor2 = new ConsumidorPedidos(c, pedidos);

        produtor.start();
        consumidor.start();
        consumidor2.start();
    }
}