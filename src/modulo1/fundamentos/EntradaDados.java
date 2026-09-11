package modulo1.fundamentos;
import java.util.Scanner;

public class EntradaDados {
    public static void main(String[]args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite sua idade: ");
        int idade = scanner.nextInt();
        System.out.println("Você tem "+idade+" anos.");

        System.out.print("Digite sua altura: ");
        double altura = scanner.nextDouble();
        System.out.println("Você tem "+altura+"m de altura.");

        scanner.nextLine();

        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();
        System.out.println("Olá, " + nome + "!");
    }
}
