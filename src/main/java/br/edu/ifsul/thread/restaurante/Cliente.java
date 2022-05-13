package br.edu.ifsul.thread.restaurante;

import java.io.Serializable;

public class Cliente extends Thread implements Serializable {
    Integer numero;
    Double conta;
}
