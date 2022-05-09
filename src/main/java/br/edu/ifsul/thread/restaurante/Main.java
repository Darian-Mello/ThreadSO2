package br.edu.ifsul.thread.restaurante;
import java.util.Arrays;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {
    public static void main(String[] args) {
        BlockingQueue<Pedido> pedidos = new ArrayBlockingQueue<>(10);

        ProdutorPedidos produtor = new ProdutorPedidos(pedidos);
        ConsumidorPedidos consumidor = new ConsumidorPedidos(pedidos);

        produtor.start();
        consumidor.start();

    }

    /*
    public static void main (String[] args) throws InterruptedException{
        BlockingQueue<String> bq = new ArrayBlockingQueue<>(3);
        Thread t1 = new Thread(new RemoveFromQueue(bq));
        t1.start();

        System.out.println(Arrays.toString(bq.toArray()));

        bq.put("Feijao");
        Thread.sleep(50);
        System.out.println("Inseriu Feijao");
        Thread.sleep(1000);
        System.out.println(Arrays.toString(bq.toArray()));

        bq.put("Salada");
        Thread.sleep(50);
        System.out.println("Inseriu Salada");
        Thread.sleep(1000);
        System.out.println(Arrays.toString(bq.toArray()));

        bq.put("Massa");
        Thread.sleep(50);
        System.out.println("Inseriu Massa");
        Thread.sleep(1000);
        System.out.println(Arrays.toString(bq.toArray()));

        bq.put("Pizza");
        Thread.sleep(50);
        System.out.println("Inseriu Pizza");
        Thread.sleep(1000);
        System.out.println(Arrays.toString(bq.toArray()));

        bq.put("Hamburguer");
        Thread.sleep(50);
        System.out.println("Inseriu Hamburguer");
        Thread.sleep(1000);
        System.out.println(Arrays.toString(bq.toArray()));

        bq.put("Suco");
        Thread.sleep(50);
        System.out.println("Inseriu Suco");
        Thread.sleep(1000);
        System.out.println(Arrays.toString(bq.toArray()));

        bq.put("Vinho");
        Thread.sleep(50);
        System.out.println("Inseriu Vinho");
        System.out.println(Arrays.toString(bq.toArray()));


        Thread.sleep(11000);
        System.out.println(Arrays.toString(bq.toArray()));
    }

    static class RemoveFromQueue implements Runnable{
        private BlockingQueue<String> bq;

        public RemoveFromQueue(BlockingQueue<String> bq){
            this.bq = bq;
        }

        @Override
        public void run() {
            try{
                Thread.sleep(3000);
                while(!bq.isEmpty()){
                    if(bq.peek()=="Pizza"){
                        Thread.sleep(8000);
                    }
                    else
                        Thread.sleep(1000);
                    System.out.println("Removeu " + bq.take());

                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }*/
}