package modulo1.exercicios.repeticoes;
import java.util.Scanner;

public class SistemaDeNotas {
    public static void main(String[]args) {
        Scanner scanner  = new Scanner(System.in);

        System.out.print("Digite as notas: ");
        double notas = scanner.nextDouble();
        if (notas == -1) {
            System.out.println("Nenhuma nota foi informada.");
            return;
        }
        while ((notas > 10 || notas < 0) && notas != -1) {
                System.out.print("Digite um valor de nota válida: ");
                notas = scanner.nextDouble();
        }
        if (notas == -1) {
            System.out.println("Nenhuma nota foi informada.");
            return;
        }

        int quantidade = 1;

        int quantidadeAprovados = 0;
        if (notas >= 6) {
            quantidadeAprovados++;
        }

        int quantidadeReprovados = 0;
        if (notas < 6) {
            quantidadeReprovados++;
        }

        double maiorNota =notas;

        double menorNota = notas;

        double soma = notas;


        while (notas != -1) {
            System.out.print("Digite as notas: ");
            notas = scanner.nextDouble();
            if (notas == -1) {
                break;
            }
            if (notas > 10 || notas < 0) {
                System.out.println("Digite um valor de nota válido.");
                continue;
            }
            if (notas >= 6) {
                quantidadeAprovados++;
            }
            if (notas < 6) {
                quantidadeReprovados++;
            }
            if (maiorNota < notas) {
                maiorNota = notas;
            }
            if (menorNota > notas) {
                menorNota = notas;
            }
            soma += notas;
            quantidade++;
        }
        double media = soma / quantidade;
        System.out.println("----- RELATÓRIO DE NOTAS -----\nQuantidade de notas válidas: "+quantidade+"\nMédia das notas: "+media+"\nQuantidade de aprovados: "+quantidadeAprovados+"\nQuantidade de reprovados: "+quantidadeReprovados+"\nMaior nota: "+maiorNota+"\nMenor nota: "+menorNota);

    }
}
