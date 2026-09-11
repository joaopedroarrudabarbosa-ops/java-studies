package modulo1.exercicios.revisao;
import java.util.Scanner;

public class SistemaBancario {
    public static void main(String[]args) {
        Scanner scanner = new Scanner(System.in);
        int saldo = 1000;
        int opc;

        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();

        System.out.print("Digite sua idade: ");
        int idade = scanner.nextInt();

        if (idade >= 18) {
            System.out.println("Acesso permitido! Seja bem-vindo "+ nome+".");
            do {
                System.out.println("-------MENU-------");
                System.out.println("1 - Consultar saldo");
                System.out.println("2 - Depositar");
                System.out.println("3 - Sacar");
                System.out.println("4 - Tabuada");
                System.out.println("0 - Sair");
                System.out.print("Escolha: ");
                opc = scanner.nextInt();
                if (opc == 1) {
                    System.out.println("Seu saldo é de R$"+saldo+".");
                }
                else if (opc == 2) {
                    System.out.print("Insira o valor do deposito: ");
                    int depositar = scanner.nextInt();
                    if (depositar > 0) {
                        saldo = saldo + depositar;
                        System.out.println("O valor atual agora é de R$" + saldo);
                    }
                    else {
                        System.out.println("Valor invalido.");
                    }

                }
                else if (opc == 3) {
                    System.out.print("Insirar o valor que deseja sacar: ");
                    int sacar = scanner.nextInt();
                    if (sacar > 0 && sacar <= saldo) {
                        saldo = saldo - sacar;
                        System.out.println("O valor atual agora é de R$" + saldo);
                    }
                    else {
                        System.out.println("Saque não permitido.");
                    }
                }
                else if (opc == 4) {
                    System.out.print("Digite o valor que deseja verificar a tabuada: ");
                    int tabuada = scanner.nextInt();
                    for (int i = 1; i <= 10; i++) {
                        System.out.println(tabuada+" X "+i+" = "+ tabuada*i);
                    }
                }
                else if (opc == 0 ) {
                    System.out.println("Até mais, "+nome+"!");
                    break;
                }
                else {
                    System.out.println("Opção incorreta! Tente novamente.");
                }
            } while (opc != 0);
        }
        else {
            System.out.println("Acesso negado! É necesário ser maior de idade.");
        }
    }
}
