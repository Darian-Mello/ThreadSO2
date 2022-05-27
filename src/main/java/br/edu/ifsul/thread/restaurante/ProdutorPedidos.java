package br.edu.ifsul.thread.restaurante;

import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Classe utilizada como produtor (Cliente) dos pedidos que posteriormente serão consumidos pela classe consumidora (Cozinheiro)
 * Tal classe gera 8 pedidos com 4 pratos cada. Dados provenientes da classe "Cardapio" onde 11 pratos distintos são criados.
 * Os 4 pratos são definidos de forma aleatória dentro desta classe para poder mostrar várias possibilidades.
 * @author Dariãn e Elias
 */
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
                p.setNumero(i);
                int tempoPreparo = 0;
                double precoTotal = 0.0;

                pedidos.put(p);
                for (Prato prato : p.getPratos()) {
                    precoTotal += prato.getPreco();
                    tempoPreparo += prato.getTempoPreparo();
                }
                System.out.println("\nPedido nº " + i + " foi inserido na fila, seus pratos: " +
                    p.getPratos().get(0).getNome() + ", " + p.getPratos().get(1).getNome() + ", " + p.getPratos().get(2).getNome() + ", " + p.getPratos().get(3).getNome() +
                                "; Tempo de preparo: " +
                                tempoPreparo + "s; Preço Total: R$" + precoTotal + ";");

                TimeUnit.SECONDS.sleep(1);
            }
            p = new Pedido();
            p.setNumero(0);
            pedidos.put(p);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Função que executa a randomização dos 4 pratos dentro do pedido, retornando o mesmo.
     */
    public Pedido montaPedido () throws Exception {
        Pedido p = new Pedido();
        ArrayList<Prato> pratosDoPedido = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            pratosDoPedido.add(cardapio.getPratos().get((int)Math.floor(Math.random() * cardapio.getPratos().size())));
        }
        p.setPratos(pratosDoPedido);

        return p;
    }

    /**
     * Função que mostra todos os pratos disponiveis no cardápio com todos seus dados.
     */
    public void mostraPratos () {
        System.out.println("Pratos do dia:");
        for (Prato prato: cardapio.getPratos()) {
            System.out.println( prato.getNumero() + " - " + prato.getNome() + " - Tempo de preparo: " + prato.getTempoPreparo()  + "s - Preço: " +
                    prato.getPreco());
        }
    }
}
