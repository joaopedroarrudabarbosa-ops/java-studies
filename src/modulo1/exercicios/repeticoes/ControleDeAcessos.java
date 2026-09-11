package modulo1.exercicios.repeticoes;
import java.util.Scanner;

public class ControleDeAcessos {

    static int maiorIdade(int maiorIdade, int novaMaiorIdade) {
        if (maiorIdade > novaMaiorIdade) {
            novaMaiorIdade = maiorIdade;
        }
        return novaMaiorIdade;
    }

    static int menorIdade(int menorIdade, int novaMenorIdade) {
        if (menorIdade < novaMenorIdade) {
            novaMenorIdade = menorIdade;
        }
        return novaMenorIdade;
    }

    public static void main(String[]args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite uma idade: ");
        int idade = scanner.nextInt();

        if (idade == -1) {
            System.out.println("Nenhuma idade válida informada.");
            return;
        }

        while ((idade < 0 || idade > 120) && idade != -1) {
            System.out.print("Digite uma idade válida: ");
            idade = scanner.nextInt();
        }
        if (idade == -1) {
            System.out.println("Nenhuma idade válida informada.");
            return;
        }

        int quantidadeValidas = 0;
        if (idade >= 0 && idade <= 120) {
            quantidadeValidas++;
        }
        int quantidadeMaiorIdade = 0;
        int quantidadeMenorIdade = 0;
        if (idade >= 18) {
            quantidadeMaiorIdade++;
        } else {
            quantidadeMenorIdade++;
        }
        int maiorIdade = idade;
        int menorIdade = idade;
        int soma = idade;

        while (idade != -1) {
            System.out.print("Digite uma idade: ");
            idade = scanner.nextInt();
            if (idade == -1) {
                System.out.println("Sistema encerrado.");
                break;
            }
            if (idade < 0 || idade > 120) {
                System.out.println("Idade inválida.");
                continue;
            }
                quantidadeValidas++;
                soma += idade;
                menorIdade = menorIdade(menorIdade,idade);
                maiorIdade = maiorIdade(maiorIdade, idade);
                if (idade >= 18) {
                    quantidadeMaiorIdade++;
                } else {
                    quantidadeMenorIdade++;
            }
        }
        double media = (double) soma /quantidadeValidas;
        System.out.println("----- RELATÓRIO DE ACESSOS -----" +
                "\nQuantidade de idades válidas: " + quantidadeValidas+
                "\nMenores de idade: " + quantidadeMenorIdade+
                "\nAdultos: " + quantidadeMaiorIdade+
                "\nMédia das idades: "  +media+
                "\nMaior idade: " + maiorIdade+
                "\nMenor idade: " + menorIdade);
    }
}
