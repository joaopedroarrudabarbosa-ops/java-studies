package modulo1.exercicios.revisao;
import java.util.Scanner;

public class SistemaEstacionamento {

    static String lerNome(Scanner scanner) {
        System.out.print("Digite seu nome: ");
        return scanner.nextLine();
    }

    static int lerIdade(Scanner scanner) {
        System.out.print("Digite sua idade: ");
        return scanner.nextInt();
    }

    static int lerHoras(Scanner scanner) {
        System.out.print("Digite quantas horas você ficou estacionado: ");
        return scanner.nextInt();
    }

    static boolean lerFidelidade(Scanner scanner) {
        System.out.print("Possui fidelidade? (S/N) ");
        String fidadelidade = scanner.nextLine();
        if (fidadelidade.equalsIgnoreCase("S")) {
            return true;
        }
        else {
            return false;
        }
    }

    static double calcularValorSemDesconto(int horas) {
        int valor = 8;
        return horas * valor;
    }

    static double lerDesconto(double valor, boolean fidelidade ){
        if(fidelidade == true) {
            return valor - (valor * 0.85);
        }
        else  {
            return 0;
        }
    }

    static double calcularValorFinal(double valor, double desconto) {
            return valor - desconto;
    }

    static void mostrarResultado(String nome, int idade, int horas, boolean fidelidade, double valor, double desconto, double valorFinal) {
        System.out.println("-------ESTACIONAMENTO-------\nMOTORISTA: "+nome+"\nIDADE: " +idade+"\nHORAS: "+horas+"\nFIDELIDADE: "+fidelidade+"\nVALOR SEM DESCONTO: "+valor+"\nDESCONTO: "+desconto+"\nVALOR FINAL: "+valorFinal);
    }

    public static void main(String[]args) {
        Scanner scanner = new Scanner(System.in);

        String nome = lerNome(scanner);
        int idade = lerIdade(scanner);
        if (idade < 18 ){
            System.out.println("Acesso não permitido.");
            return;
        }
        int horas = lerHoras(scanner);
        if (horas <= 0 ) {
            System.out.println("Quantidade de horas inválidas.");
            return;
        }
        double valor = calcularValorSemDesconto(horas);

        scanner.nextLine();

        boolean fidelidade = lerFidelidade(scanner);
        double desconto = (lerDesconto(valor,fidelidade));
        double valorFinal = calcularValorFinal(valor,desconto);

        mostrarResultado(nome,idade,horas,fidelidade,valor,desconto,valorFinal);
    }
}
