package modulo1.exercicios.metodos;
import java.util.Scanner;

public class SistemaCadastro {

    static void mostrarIdentificacao(String nome, int idade, double salario, boolean maiorIdade, boolean salarioValido) {
        System.out.println("Nome: "+nome+"\nIdade: "+idade+"\nSalario: "+salario+"\nMaior idade: "+maiorIdade+"\nSalario válido: "+salarioValido);
    }
    static String lerNome(Scanner scanner) {
        System.out.print("Digite seu nome: ");
        return scanner.nextLine();
    }

    static int lerIdade(Scanner scanner) {
        System.out.print("Digite sua idade: ");
        return scanner.nextInt();
    }

    static double lerSalario(Scanner scanner) {
        System.out.print("Digite seu salario: ");
        return scanner.nextDouble();
    }

    static boolean verificarMaiorIdade(int idade) {
        return idade >= 18;
        }

    static boolean verificarSalarioValido(double salario) {
        return salario > 0;
    }

    public static void main(String[]args) {
        Scanner scanner = new Scanner(System.in);

        String nome = lerNome(scanner);

        int idade = lerIdade(scanner);

        double salario = lerSalario(scanner);

        boolean maiorIdade = verificarMaiorIdade(idade);

        boolean salarioValido = verificarSalarioValido(salario);

        mostrarIdentificacao(nome, idade, salario, maiorIdade, salarioValido);
    }
}
