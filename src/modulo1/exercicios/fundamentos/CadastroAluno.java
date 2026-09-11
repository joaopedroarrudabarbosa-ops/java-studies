package modulo1.exercicios.fundamentos;

import java.util.Scanner;

public class CadastroAluno {
    public static void main(String[]args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("---DADOS DO ALUNO---");

        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();

        System.out.print("Digite sua idade: ");
        int idade = scanner.nextInt();

        System.out.print("Digite sua nota: ");
        double nota = scanner.nextDouble();

        System.out.println("Nome: "+nome);
        System.out.println("Idade: "+idade+" anos");
        System.out.println("Nota: "+nota);

        if (nota >= 6) {
            System.out.println("Aprovado!");
        }
        else if (nota >= 4) {
            System.out.println("Recuperação!");
        }
        else {
            System.out.println("Reprovado");
        }

    }
}
