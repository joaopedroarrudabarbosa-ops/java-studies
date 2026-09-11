package modulo1.repeticoes;
import java.util.Scanner;

public class For {
    public static void main(String[]args) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 2; i <= 10; i+=2) {
            System.out.println(i);
        }
        System.out.print("Digite o numero que gostaria de saber a tabuada: ");
        int tabuada = scanner.nextInt();

        for (int i=1; i <=10; i++) {
            int resultado = tabuada * i;
            System.out.println(tabuada+" X "+i+" = "+resultado);
        }

    }
}
