package modulo1.exercicios.repeticoes;
import java.util.Scanner;

public class SistemaDeCaixa {
    public static void main(String[]args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o valor de uma venda: ");
        double vendas = scanner.nextDouble();

        if (vendas == 0) {
            System.out.println("Nenhuma venda foi informada.");
            return;
        }

        while (vendas<0) {
            System.out.print("Valor inválido.\nDigite um valor válido: ");
            vendas = scanner.nextDouble();
        }
        if (vendas == 0) {
            System.out.println("Nenhuma venda foi realizada.");
            return;
        }

        int quantidadeVendas = 1;

        double valorTotal = vendas;
        double maiorVenda = vendas;
        double menorVenda = vendas;

        int vendasAcima100 = 0;
        int vendasAte100 = 0;
        if (vendas > 100) {
            vendasAcima100++;
        } else {
            vendasAte100++;
        }


        while (vendas != 0) {
            System.out.print("Digite o valor de uma venda: ");
            vendas = scanner.nextDouble();
            if (vendas == 0) {
                break;
            }
            if (vendas < 0) {
                System.out.println("Valor inválido.");
                continue;
            }
            quantidadeVendas++;
            valorTotal += vendas;
            if (maiorVenda < vendas) {
                maiorVenda = vendas;
            }
            if (menorVenda > vendas) {
                menorVenda = vendas;
            }
            if (vendas > 100) {
                vendasAcima100++;
            } else {
                vendasAte100++;
            }
        }
        double media = valorTotal / quantidadeVendas;
        System.out.println("----- RELATÓRIO DE CAIXA -----\nQuantidade de vendas: "+quantidadeVendas+"\nTotal vendido: "+valorTotal+"\nMédia das vendas: "+media+"\nMaior venda: "+maiorVenda+"\nMenor venda: "+menorVenda+"\nVendas acima de R$100,00: "+vendasAcima100+"\nVendas de até R$100,00: "+vendasAte100);
    }
}
