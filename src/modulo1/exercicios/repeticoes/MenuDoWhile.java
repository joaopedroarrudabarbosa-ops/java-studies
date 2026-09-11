package modulo1.exercicios.repeticoes;
import java.util.Scanner;

public class MenuDoWhile {
    public static void main(String[]args) {
        Scanner scanner = new Scanner(System.in);
        int opc;

        do {
            System.out.println("---MENU---");
            System.out.println("1 - Ver saldo");
            System.out.println("2 - Ver perfil");
            System.out.println("0 - Sair");
            System.out.print("Digite a opção que deseja: ");
            opc = scanner.nextInt();
            if (opc == 1) {
                System.out.println("Seu saldo é R$1.000,00");
            }
            else if (opc == 2) {
                System.out.println("Joao.");
            }
            else if (opc == 0) {
                System.out.println("Saindo...");
            }
            else {
                System.out.println("Opção incorreta.");
            }
        } while (opc != 0);

    }
}
