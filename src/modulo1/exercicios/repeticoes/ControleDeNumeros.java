package modulo1.exercicios.repeticoes;
import java.util.Scanner;

public class ControleDeNumeros {
    public static void main(String[]args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um número: ");
        int numeros = scanner.nextInt();
        int quantidade = 0;
        int soma = numeros;
        int quantidadeNegativo = 0;
        int quantidadePositivo = 0;
        int maiorNumero = numeros;
        int menorNumero = numeros;
        if(numeros == 0) {
            System.out.println("Nenhum número foi informado.");
            return;
        }
        quantidade = 1;
        if (numeros < 0) {
            quantidadeNegativo = 1;
        }

        if (numeros > 0) {
            quantidadePositivo = 1;
        }

        while(numeros !=0) {
            System.out.print("Digite um número: ");
            numeros = scanner.nextInt();
            if (numeros == 0) {
                break;
            }
            if (numeros > 0) {
                quantidadePositivo++;
            }
            else if (numeros < 0) {
                quantidadeNegativo++;
            }
            if (maiorNumero < numeros) {
                maiorNumero = numeros;
            }
            if (menorNumero > numeros) {
                menorNumero = numeros;
            }
            soma += numeros;
            quantidade++;
        }
        System.out.println("Quantidade: "+quantidade+"\nSoma: "+soma+"\nQuantidade positivo: "+quantidadePositivo+"\nQuantidade negativo: "+quantidadeNegativo+"\nMaior número: "+maiorNumero+"\nMenor número: "+menorNumero);
    }
}
