package modulo1.repeticoes.revisao;
import java.util.Scanner;

public class Break {
    public static void main(String[]args) {
        Scanner scanner = new Scanner(System.in);
        for (int i=1; i<=5; i++) {
            System.out.print("Digite o "+i+" numero: ");
            int numero = scanner.nextInt();
            if (numero == 0) {
                break;
            }
            System.out.println(numero);
        }
    }
}
