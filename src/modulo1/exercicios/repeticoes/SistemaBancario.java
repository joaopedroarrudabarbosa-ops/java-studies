package modulo1.exercicios.repeticoes;
import java.util.Scanner;

public class SistemaBancario {

    static void mostrarMenu() {
        System.out.print("----- SISTEMA BANCÁRIO -----\n" +
                                "1 - Consultar saldo\n" +
                                "2 - Depositar\n" +
                                "3 - Sacar\n" +
                                "4 - Exibir resumo\n" +
                                "0 - Sair\n" +
                                "Escolha uma opção: ");
    }

    static double depositar(double saldo,double valor) {
        return saldo + valor;
    }

    static double sacar(double saldo, double sacar) {
        return saldo - sacar;
    }

    static double maiorValor(double maiorValor, double novoMaior) {
        if (maiorValor > novoMaior) {
            novoMaior = maiorValor;
        }
        return novoMaior;
    }

    public static void main(String[]args) {
        Scanner scanner = new Scanner(System.in);

        int opc = -1;
        double saldo = 1000;
        int quantidadeDepositos = 0;
        double totalDepositado = 0;
        double maiorDeposito = 0;

        int quantidadeSaques = 0;
        double totalSacado = 0;
        double maiorSaque = 0;

        while (opc != 0) {
            mostrarMenu();
            opc = scanner.nextInt();
            if (opc == 0) {
                System.out.println("Sistema encerrado.");
                break;
            }
            if (opc > 4 || opc < 0) {
                System.out.println("Valor inválido.");
                continue;
            }
            if (opc == 1) {
                System.out.println(saldo);
            }
            if (opc == 2) {
                System.out.print("Digite o valor do deposito: ");
                double deposito = scanner.nextDouble();
                if (deposito > 0) {
                    saldo = depositar(saldo,deposito);
                    quantidadeDepositos++;
                    totalDepositado +=deposito;
                    maiorDeposito = maiorValor(maiorDeposito,deposito);
                } else {
                    System.out.println("Valor inválido de deposito.");
                    continue;
                }
            }
            if (opc == 3) {
                System.out.print("Digite o valor do saque: ");
                double saque = scanner.nextDouble();
                if (saque > saldo) {
                    System.out.println("Saldo insuficiente de saque.");
                    continue;
                }
                if (saque > 0 ) {
                    saldo = sacar(saldo,saque);
                    quantidadeSaques++;
                    totalSacado += saque;
                    maiorSaque = maiorValor(maiorSaque,saque);
                } else {
                    System.out.println("Valor inválido de saque.");
                }
            }
            if (opc == 4) {
                System.out.println("---------- RESUMO ----------\n" +
                                      "Saldo atual: " +saldo+
                                      "\nQuantidade de depósitos: " +quantidadeDepositos+
                                      "\nTotal depositado: " +totalDepositado+
                                      "\nMaior depósito: " +maiorDeposito+
                                      "\nQuantidade de saques: " +quantidadeSaques+
                                      "\nTotal sacado: " +totalSacado+
                                      "\nMaior saque: " +maiorSaque);
            }
        }
    }
}
