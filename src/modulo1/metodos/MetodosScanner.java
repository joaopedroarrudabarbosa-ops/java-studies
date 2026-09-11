package modulo1.metodos;
import java.util.Scanner;

public class MetodosScanner {

    static double calcularMedia(double nota1, double nota2) {
        return (nota1 + nota2 ) / 2;
    }
    static double lerNota(Scanner scanner) {
        System.out.print("Digite sua nota: ");
        return scanner.nextDouble();
    }

    public static void main(String[]args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("----SISTEMA DE MEDIA----");
        System.out.print("Digite sua primeira nota: ");
        double nota1 = scanner.nextDouble();

        System.out.print("Digite sua segunda nota: ");
        double nota2 = scanner.nextDouble();

        double media = calcularMedia(nota1,nota2);
        System.out.println(media);

        double nota3 = lerNota(scanner);
        double nota4 = lerNota(scanner);
        double media1 = calcularMedia(nota3,nota4);
        System.out.println(media1);

    }
}
