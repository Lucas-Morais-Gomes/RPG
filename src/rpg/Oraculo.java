package rpg;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author alunolab08
 */
    public class Oraculo {
    String nome;
    Guerreiro warrior;

    Guerreiro guerreiro = new Guerreiro(nome, 0);
    
    public Oraculo(String nome, Guerreiro warrior) {
        this.nome = nome;
        this.warrior = warrior;
    }
    
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public String prologoVencedor() { //        o nome é do guerreiro        
        return "Grande Guerreiro " + guerreiro.getNome() + ", você é o VENCEDOR! O Oráculo se curva diante de sua grandeza!";
    }
    
    public String prologoPerdedor() {//        o nome é do guerreiro
        return "Guerreiro " + guerreiro.getNome() + ", você é o PERDEDOR! O Oráculo lamenta a sua derrota.";
    }
    
    public String prologoIntroducao() {
        String prologo = "Bem-vindo, Guerreiro " + nome + "!\n";
        prologo += "O Oráculo prevê que você tem " + vidas + " vidas para a jornada que está por vir.";
        return prologo;
    }

    public int sortearNumeroSecreto() {
        Random rand = new Random();
        int numeroSecreto = rand.nextInt(100) + 1;
        return numeroSecreto;
    }
    
    public void loadLevel1() {
        Scanner scanner = new Scanner(System.in);
        int tentativas = 3; // Número de tentativas permitidas

        System.out.println("Você entra na Câmara do Oráculo. Tente adivinhar o número secreto para avançar!");

        for (int i = 0; i < tentativas; i++) {
            System.out.print("Digite seu palpite: ");
            int palpite = scanner.nextInt();

            if (palpite == sortearNumeroSecreto()) {
                System.out.println("Parabéns, você acertou o número secreto!");
                return; // O Guerreiro avançou com sucesso
            } else if (palpite < sortearNumeroSecreto()) {
                System.out.println("O segredo é MAIOR.");
            } else {
                System.out.println("O segredo é MENOR.");
            }

            vidas--; // Decrementa uma vida em caso de palpite errado
            System.out.println("Vidas restantes: " + vidas);
        }

        System.out.println("Você esgotou suas tentativas. O Oráculo venceu!");
    }
    
    public int loadLevel2(int opcao) {
        if (opcao != 0 && opcao != 1) {
            System.out.println("Opção inválida. Escolha 0 para PAR ou 1 para ÍMPAR.");
            return -1; // Valor inválido
        }

        Random rand = new Random();
        int numeroGuerreiro = rand.nextInt(6); // Número do Guerreiro entre 0 e 5
        int numeroOraculo = rand.nextInt(6);  // Número do Oráculo entre 0 e 5
        int soma = numeroGuerreiro + numeroOraculo;
        boolean resultadoPar = soma % 2 == 0;

        System.out.println("Guerreiro escolheu " + (opcao == 0 ? "PAR" : "ÍMPAR"));
        System.out.println("Número do Guerreiro: " + numeroGuerreiro);
        System.out.println("Número do Oráculo: " + numeroOraculo);
        System.out.println("Soma: " + soma);

        if ((opcao == 0 && resultadoPar) || (opcao == 1 && !resultadoPar)) {
            System.out.println("Guerreiro Ganhou!");
            return 1; // Guerreiro Ganhou
        } else {
            System.out.println("Guerreiro Perdeu!");
            vidas--; // Decrementa uma vida em caso de derrota
            System.out.println("Vidas restantes: " + vidas);
            return 0; // Guerreiro Perdeu
        }
    }
    
    
//    opcao: int
//    Revisar o a funcao toda 
    public int loadLevel2(String opcao) {
        Random random = new Random();
        int guerreiroNumero = random.nextInt(6);
        int oraculoNumero = random.nextInt(6);
        int soma = guerreiroNumero + oraculoNumero;

        boolean vitoria = (soma % 2 == 0 && opcao.equalsIgnoreCase("PAR")) ||
                          (soma % 2 != 0 && opcao.equalsIgnoreCase("IMPAR"));

        return vitoria ? 1 : -1;
    }

    public boolean decidirVidaExtra(String Misericordia) {
        String[] palavras = Misericordia.split(" ");
        int numPalavras = palavras.length;

        if (numPalavras > 5) {
            vidas++;
            return true; // Vida extra concedida
        } else {
            return false; // Vida extra não concedida
        }
    }

        
}