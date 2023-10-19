package rpg;

import java.util.Scanner;

public class RPG {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crie uma instância do Oráculo com o nome do Guerreiro
        Guerreiro guerreiro = new Guerreiro();

        // Exibe o estado inicial do Guerreiro
        System.out.println("Bem-vindo, Guerreiro " + guerreiro.getNome() + "!");
        System.out.println("Número de vidas do Guerreiro: " + guerreiro.getVidas());

        // Jogue pelo menos uma partida (você pode adicionar a lógica aqui)
        int resultado = loadLevel1(); // Exemplo de jogo Level 1
        if (resultado == 1) {
            System.out.println(oraculo.prologoVencedor());
        } else {
            System.out.println(oraculo.prologoPerdedor());
        }

        // Simule um pedido de Misericórdia do Guerreiro
        System.out.print("Digite seu pedido de Misericórdia: ");
        String pedidoMisericordia = scanner.nextLine();

        if (oraculo.decidirVidaExtra(pedidoMisericordia)) {
            System.out.println("O pedido de Misericórdia foi atendido! Uma vida extra foi concedida.");
            guerreiro.setVidas(guerreiro.getVidas() + 1);
        } else {
            System.out.println("O pedido de Misericórdia foi recusado.");
        }

        // Exibe o estado atual do Guerreiro
        System.out.println("Número de vidas do Guerreiro: " + guerreiro.getVidas());
    }
}