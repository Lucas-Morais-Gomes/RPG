package rpg;

import java.util.Random;

/**
 *
 * @author alunolab08
 */
public class Guerreiro {
    String nome;
    int vidas;

    public Guerreiro(String nome, int vidas) {
        this.nome = nome;
        this.vidas = vidas;
    }
        
    void vidaExtra() {
        System.out.println("Guerreiro " + nome + ", você pediu uma vida extra.");
        boolean concedida = decidirVidaExtra("Por favor, me dê uma vida extra, grande Oráculo!");
        if (concedida) {
            System.out.println("Vida extra concedida. Agora você tem 13 vidas.");
        } else {
            System.out.println("Desculpe, seu pedido de vida extra foi negado.");
        }
    }

    public void getGuerreiro(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public int setVidas() {
        Random rand = new Random();// Gere um número aleatório entre 9 e 12 (inclusive)
        int vidas = rand.nextInt(4) + 9;
        return vidas;
    }

    public int getVidas() {
        return vidas;
    }
}