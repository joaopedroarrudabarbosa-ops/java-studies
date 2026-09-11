package modulo1.repeticoes.revisao;
import java.util.Scanner;

public class DoWhile {
    public static void main(String[]args) {
        Scanner scanner = new Scanner(System.in);

        int quantidade = 10;

        do {
            System.out.println(quantidade);
            quantidade++;
        } while (quantidade <= 5);

        int senhaCorreta = 1234;
        int senha;

        do {
            System.out.print("Digite a senha: ");
            senha = scanner.nextInt();
            if (senha != senhaCorreta) {
                System.out.println("Acesso negado.");
            }
        } while (senha != senhaCorreta);
        System.out.println("Acesso permitido.");

        int opc;
        int numero;
        do {
            System.out.print("----- MENU -----" +
                            "\n1 - Dizer Olá" +
                            "\n2 - Mostrar um número" +
                            "\n0 - Sair" +
                            "\nEscolha uma opção: ");
            opc = scanner.nextInt();
            if (opc == 1) {
                System.out.println("Olá");
            }
            else if (opc == 2) {
                System.out.print("Digite o número que gostaria de mostrar: ");
                numero = scanner.nextInt();
                System.out.println("Número: "+numero);
            }
            else if (opc == 0) {
                System.out.println("Programa encerrado.");
            } else {
                System.out.println("Digite um valor válido.");
            }
        } while (opc != 0);
    }
}
