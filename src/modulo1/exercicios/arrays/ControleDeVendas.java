package modulo1.exercicios.arrays;
import java.util.Scanner;

public class ControleDeVendas {

    static int maiorQuantidadeVendida(int[] quantidadeVendidas, int maiorQuantidade, int indiceMaiorQuantidade) {
        for (int i = 1;i<quantidadeVendidas.length;i++) {
            if (maiorQuantidade < quantidadeVendidas[i]) {
                maiorQuantidade = quantidadeVendidas[i];
                indiceMaiorQuantidade = i;
            }
        }
        return indiceMaiorQuantidade;
    }

    static int produtoMaiorFaturamento(double[] faturamentos,double maiorFaturamento, int indiceMaiorFaturamento) {
        for (int i =1;i<faturamentos.length;i++) {
            if (maiorFaturamento < faturamentos[i]) {
                maiorFaturamento = faturamentos[i];
                indiceMaiorFaturamento = i;
            }
        }
        return indiceMaiorFaturamento;
    }

    static int produtoMenorEstoque(int[] estoques, int menorEstoque, int indiceMenorEstoque) {
        for (int i =1;i<estoques.length;i++) {
            if (menorEstoque > estoques[i]) {
                menorEstoque = estoques[i];
                indiceMenorEstoque = i;
            }
        }
        return indiceMenorEstoque;
    }

    static int quantidadeEstoqueBaixo(int[] estoques, int quantidadeEstoqueBaixo) {
        for (int i =0;i<estoques.length;i++) {
            if (estoques[i] <= 5) {
                quantidadeEstoqueBaixo++;
            }
        }
        return quantidadeEstoqueBaixo;
    }

    static void exibirRelatoriosVendas(String[] produtos,int[] quantidadeVendidas,int[] estoques, double[] faturamentos) {
        System.out.println("\nRELATÓRIO DE VENDAS");
        for (int i = 0;i<produtos.length;i++) {
            System.out.printf("%s - Vendidos: %d - Estoque restante: %d - Faturamento: %.2f%n", produtos[i], quantidadeVendidas[i], estoques[i], faturamentos[i]);
        }
    }

    static void exibirEstoqueBaixo(int[] estoques, String[] produtos) {
        System.out.println("\nProdutos com estoque baixo: ");
        for (int i =0;i<estoques.length;i++) {
            if (estoques[i] <= 5) {
                System.out.println(produtos[i]);
            }
        }
    }

    static void exibirResumo(String[]produtos,int[] quantidadeVendidas,double[] faturamentos,int[] estoques,int totalUnidadesVendidas,double faturamentoTotal, double faturamentoMedio,int indiceMaiorQuantidade,int indiceMaiorFaturamento,int indiceMenorEstoque, int quantidadeEstoqueBaixa) {
        System.out.println("\nTotal de unidades vendidas: " +totalUnidadesVendidas+
                "\nFaturamento total: " +faturamentoTotal+
                "\nFaturamento médio por produto: " +faturamentoMedio+
                "\nProduto com mais unidades vendidas: " +produtos[indiceMaiorQuantidade]+" - "+quantidadeVendidas[indiceMaiorQuantidade]+
                "\nProduto com maior faturamento: " +produtos[indiceMaiorFaturamento]+" - "+faturamentos[indiceMaiorFaturamento]+
                "\nProduto com menor estoque: " +produtos[indiceMenorEstoque]+ " - "+estoques[indiceMenorEstoque]+
                "\nQuantidade de produtos com estoque baixo: "+quantidadeEstoqueBaixa);
    }

    public static void main(String[]args) {
        Scanner input = new Scanner(System.in);

        String[] produtos = {"Mouse", "Teclado", "Monitor", "Headset", "Webcam"};
        double[] precos = {80.0, 150.0, 900.0, 220.0, 120.0};
        int[] estoques = {20, 12, 5, 18, 15};
        int[] quantidadeVendidas = new int[5];
        double[] faturamentos = new double[5];

        int totalUnidadesVendidas = 0;
        double faturamentoTotal = 0;

        for (int i =0;i<estoques.length;i++) {
            int quantidade;
            do {
                System.out.print("Digite a quantidade vendida de " + produtos[i] + ": ");
                quantidade = input.nextInt();
                if (quantidade < 0 || quantidade > estoques[i]) {
                    System.out.println("Digite uma quantidade válida.");
                } else {
                    System.out.println("Quantidade vendida: "+quantidade);
                }
            } while (quantidade < 0 || quantidade > estoques[i]);
            quantidadeVendidas[i] = quantidade;
            faturamentos[i] = quantidade * precos[i];
            estoques[i] -= quantidade;
            totalUnidadesVendidas += quantidade;
            faturamentoTotal += faturamentos[i];
        }

        int maiorQuantidade = quantidadeVendidas[0];
        int indiceMaiorQuantidade = 0;
        indiceMaiorQuantidade = maiorQuantidadeVendida(quantidadeVendidas,maiorQuantidade,indiceMaiorQuantidade);

        double maiorFaturamento = faturamentos[0];
        int indiceMaiorFaturamento = 0;
        indiceMaiorFaturamento = produtoMaiorFaturamento(faturamentos,maiorFaturamento,indiceMaiorFaturamento);

        int menorEstoque = estoques[0];
        int indiceMenorEstoque = 0;
        indiceMenorEstoque = produtoMenorEstoque(estoques,menorEstoque,indiceMenorEstoque);

        int quantidadeEstoqueBaixo = 0;
        quantidadeEstoqueBaixo = quantidadeEstoqueBaixo(estoques,quantidadeEstoqueBaixo);

        double faturamentoMedio = faturamentoTotal / produtos.length;

        exibirRelatoriosVendas(produtos,quantidadeVendidas,estoques,faturamentos);
        exibirEstoqueBaixo(estoques,produtos);
        exibirResumo(produtos,quantidadeVendidas,faturamentos,estoques,totalUnidadesVendidas,faturamentoTotal,faturamentoMedio,indiceMaiorQuantidade,indiceMaiorFaturamento,indiceMenorEstoque,quantidadeEstoqueBaixo);
    }
}