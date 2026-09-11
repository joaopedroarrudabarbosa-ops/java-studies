package modulo1.switchcase;
import java.util.Scanner;

public class SwitchCase {
    public static void main(String[]args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Digite a opção que deseja: ");
        int opc = input.nextInt();
        switch (opc) {
            case 1:
                System.out.println("Você escolheu 1");
                break;
            case 2:
                System.out.println("Você escolheu 2");
                break;
            default:
                System.out.println("Opção inválida");
        }

        input.nextLine();
        System.out.print("Digite o dia da semana que deseja: ");
        String dia = input.nextLine();
        switch (dia) {
            case "segunda":
                System.out.println("Começo da semana");
                break;
            case "sexta":
                System.out.println("Quase fim de semana");
                break;
            default:
                System.out.println("Dia comum");
        }

        int numero = 3;
        switch (numero) {
            case 1:
                System.out.println("A");
                break;
            case 2:
                System.out.println("B");
                break;
            case 3:
                System.out.println("C");
                break;
            default:
                System.out.println("D");
        }

        int numero1 = 1;
        switch (numero1) {
            case 1:
                System.out.println("Oi");
            case 2:
                System.out.println("Voce");
            case 3:
                System.out.println("Esta");
            default:
                System.out.println("Bem");
        }
    }
}
