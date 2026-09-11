package modulo1.exercicios.switchcase;
import java.util.Scanner;

public class CalculadoraSwitch {

    static void exibirMenu() {
        System.out.println("===== CALCULADORA =====\n" +
                                "\n" +
                                "1 - Somar\n" +
                                "2 - Subtrair\n" +
                                "3 - Multiplicar\n" +
                                "4 - Dividir\n" +
                                "0 - Sair");
    }

    static void somar(Scanner input) {
            System.out.printf("Digite o 1 número: ");
            double numero1 = input.nextDouble();
            System.out.printf("Digite o 2 número: ");
            double numero2 = input.nextDouble();
            double soma  = numero1 + numero2;
            System.out.printf("A soma de %.2f + %.2f = %.2f%n",numero1,numero2,soma);
    }

    static void subtrair(Scanner input) {
        System.out.printf("Digite o 1 número: ");
        double numero1 = input.nextDouble();
        System.out.printf("Digite o 2 número: ");
        double numero2 = input.nextDouble();
        double subtrair  = numero1 - numero2;
        System.out.printf("A subtração de %.2f - %.2f = %.2f%n",numero1,numero2,subtrair);
    }

    static void multiplicar(Scanner input) {
        System.out.printf("Digite o 1 número: ");
        double numero1 = input.nextDouble();
        System.out.printf("Digite o 2 número: ");
        double numero2 = input.nextDouble();
        double multiplicacao  = numero1 * numero2;
        System.out.printf("A multiplicação de %.2f x %.2f = %.2f%n",numero1,numero2,multiplicacao);
    }

    static void dividir(Scanner input) {
        System.out.printf("Digite o 1 número: ");
        double numero1 = input.nextDouble();
        System.out.printf("Digite o 2 número: ");
        double numero2 = input.nextDouble();
        if (numero2 == 0) {
            System.out.println("Não é possível dividir por zero.");
        } else {
            double dividir  = numero1 / numero2;
            System.out.printf("A divisão de %.2f / %.2f = %.2f%n",numero1,numero2,dividir);
        }
    }

    public static void main(String[]args) {
        Scanner input = new Scanner(System.in);

        int opc;
        do {
            exibirMenu();
            System.out.print("Digite a opção que deseja: ");
            opc = input.nextInt();
            switch (opc) {
                case 0:
                    System.out.println("Calculadora encerrada.");
                    break;
                case 1:
                    somar(input);
                    break;
                case 2:
                    subtrair(input);
                    break;
                case 3:
                    multiplicar(input);
                    break;
                case 4:
                    dividir(input);
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opc != 0);
        input.close();
    }
}
