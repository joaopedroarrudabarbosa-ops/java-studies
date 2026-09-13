package modulo1.exercicios.switchcase;
import java.util.Scanner;

public class SistemaBancario {

    static void exibirMenu() {
        System.out.println("\n===== SISTEMA BANCÁRIO =====\n" +
                                "\n" +
                                "1 - Consultar saldo\n" +
                                "2 - Depositar\n" +
                                "3 - Sacar\n" +
                                "4 - Aplicar rendimento\n" +
                                "0 - Sair");
    }

    static double exibirDepositar(Scanner input,double saldo) {
        System.out.print("Digite o valor que deseja depositar: ");
        double deposito = input.nextDouble();
        do {
            if (deposito <= 0) {
                System.out.print("Valor de deposito inválido.\nDigite um valor de deposito válido: ");
                deposito = input.nextDouble();
            }
        } while (deposito <= 0);
        saldo += deposito;
        System.out.printf("Deposito realizado com sucesso.\nNovo saldo: R$ %.2f%n",saldo);
        return saldo;
    }

    static double exibirSacar(Scanner input, double saldo) {
        System.out.print("Digite o valor que deseja sacar: ");
        double saque = input.nextDouble();
        do {
            if (saque <= 0) {
                System.out.print("Valor de saque inválido.\nDigite um valor válido: ");
                saque = input.nextDouble();
            }
        } while (saque <= 0);
        if (saque > saldo) {
            System.out.println("Saldo insuficiente.");
        } else {
            saldo -= saque;
            System.out.printf("Saque realizado com sucesso.%nNovo saldo: R$ %.2f%n",saldo);
        }
        return saldo;
    }

    static void exibirMenuRendimento() {
        System.out.println("\n===== RENDIMENTO =====\n" +
                                "\n" +
                                "1 - 1%\n" +
                                "2 - 2%\n" +
                                "3 - 5%");
    }

    public static void main(String[]args) {
        Scanner input = new Scanner(System.in);

        double saldo = 1000.00;

        int opc;
        do {
            exibirMenu();
            System.out.print("Digite a opção que deseja: ");
            opc = input.nextInt();
            switch (opc) {
                case 1:
                    System.out.printf("Saldo: R$ %.2f%n", saldo);
                    break;
                case 2:
                    saldo = exibirDepositar(input, saldo);
                    break;
                case 3:
                    saldo = exibirSacar(input, saldo);
                    break;
                case 4:
                    exibirMenuRendimento();
                    System.out.print("Digite a opção que deseja: ");
                    int opcRendimento = input.nextInt();
                    double rendimento = 0;
                    int taxa = 0;
                    boolean taxaValida = true;
                    switch (opcRendimento) {
                        case 1:
                            taxa = 1;
                            break;
                        case 2:
                            taxa = 2;
                            break;
                        case 3:
                            taxa = 5;
                            break;
                        default:
                            System.out.println("Opção inválida.");
                            taxaValida = false;
                            break;
                    }
                    if (taxaValida) {
                        rendimento = saldo * taxa/100;
                        saldo += rendimento;
                        System.out.printf("Rendimento de %d%% = R$ %.2f%nNovo saldo: R$ .%.2f%n",taxa,rendimento,saldo);
                    }
                    break;
                case 0:
                    System.out.printf("Sistema encerrado.\n" +
                            "Saldo final: R$ %.2f%n",saldo);
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } while (opc != 0);
        input.close();
    }
}
