package modulo1.exercicios.metodos;
import java.util.Scanner;

public class SistemaDeLoja {
    static String lerNome(Scanner scanner) {
        System.out.print("Digite seu nome: ");
        return scanner.nextLine();
    }

    static int lerIdade(Scanner scanner) {
        System.out.print("Digite sua idade: ");
        return scanner.nextInt();
    }

    static boolean verificarMaiorIdade(int idade) {
        return idade >= 18;
    }

    static String lerProduto(Scanner scanner) {
        System.out.print("Digite o nome do produto: ");
        return scanner.nextLine();
    }

    static double lerPreco(Scanner scanner) {
        System.out.print("Digite o preço do produto: ");
        return scanner.nextDouble();
    }

    static int lerQuantidade(Scanner scanner) {
        System.out.print("Digite a quantidade do produto: ");
        return scanner.nextInt();
    }

    static double lerSubtotal(double precoProduto,int quantidadeProduto) {
        return precoProduto * quantidadeProduto;
    }

    static int lerDesconto(double subtotal) {
        if (subtotal >= 200) {
            int desconto = 10;
            return desconto;
        }
        else {
            int desconto = 0;
            return desconto;
        }
    }

    static double valorFinal(double subtotal, double desconto) {
        return subtotal - (subtotal * desconto /100);
    }

    static void mostrarIdentificacao(String nome, int idade, boolean maiorIdade) {
        System.out.println("---- RESUMO DA COMPRA ----"+"\nNOME: "+nome+"\nIDADe: "+idade+"\nMAIOR DE IDADE: "+maiorIdade);
    }

    static void mostrarResumo(String nomeProduto,double precoProduto,int quantidadeProduto,double subtotal, int desconto, double valorFinal) {
        System.out.println("PRODUTO: " + nomeProduto + "\nPREÇO UNITÁRIO: " + precoProduto + "\nQUANTIDADE: " + quantidadeProduto + "\nSUBTOTAL: " + subtotal + "\nDESCONTO: " + desconto + "%" + "\nTOTAL: " + valorFinal);
    }

    static void main(String[]args) {
        Scanner scanner = new Scanner(System.in);

        String nome = lerNome(scanner);
        int idade = lerIdade(scanner);
        boolean maiorIdade = verificarMaiorIdade(idade);

        scanner.nextLine();

        String nomeProduto = lerProduto(scanner);
        double precoProduto = lerPreco(scanner);
        int quantidadeProduto = lerQuantidade(scanner);
        if (quantidadeProduto <=0) {
            System.out.println("Quantidade Inválida.");
            return;
        }
        double subtotal = lerSubtotal(precoProduto,quantidadeProduto);
        int desconto = lerDesconto(subtotal);
        double valorFinal = valorFinal(subtotal,desconto);

        mostrarIdentificacao(nome,idade,maiorIdade);
        mostrarResumo(nomeProduto,precoProduto,quantidadeProduto,subtotal,desconto,valorFinal);
    }
}
