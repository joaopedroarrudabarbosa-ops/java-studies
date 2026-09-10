package exercicios.arrays;
import java.util.Scanner;

public class DesempenhoDeVendedores {

    static int vendedorMaiorValorVendido(double[] vendas, double maiorVenda, int indiceMaiorValorVendido) {
        for (int i =1;i<vendas.length;i++) {
            if (maiorVenda < vendas[i]) {
                maiorVenda = vendas[i];
                indiceMaiorValorVendido = i;
            }
        }
        return indiceMaiorValorVendido;
    }

    static int vendedorMenorValorVendido(double[] vendas, double menorVenda, int indiceMenorValorVendido) {
        for (int i =1;i<vendas.length;i++) {
            if (menorVenda > vendas[i]) {
                menorVenda = vendas[i];
                indiceMenorValorVendido = i;
            }
        }
        return indiceMenorValorVendido;
    }

    static int quantidadeAtingiuMeta(double[] metas, double[] vendas, int quantidadeAtingiuMeta) {
        for (int i =0;i<vendas.length;i++) {
            if (vendas[i] >= metas[i]) {
                quantidadeAtingiuMeta++;
            }
        }
        return quantidadeAtingiuMeta;
    }

    static int quantidadeAbaixoMeta(double[] metas, double[] vendas, int quantidadeAbaixoMeta) {
        for (int i =0;i<vendas.length;i++) {
            if (vendas[i] < metas[i]) {
                quantidadeAbaixoMeta++;
            }
        }
        return quantidadeAbaixoMeta;
    }

    static void atingiramMeta(double[] metas, double[] vendas, String[] vendedores) {
        System.out.println("\nVendedores que atingiram a meta: ");
        for (int i =0;i<vendas.length;i++) {
            if (vendas[i] >= metas[i]) {
                System.out.println(vendedores[i]);
            }
        }
    }

    static void resumoFinal(String[] vendedores, double[] vendas,double totalEquipe, double mediaEquipe, int indiceMaiorVenda, int indiceMenorVenda, int quantidadeAtingiuMeta, int quantidadeAbaixoMeta) {
        System.out.printf("\nTotal vendido: %.2f%nMédia de vendas: %.2f%nMaior venda: %s - %.2f%nMenor venda: %s - %.2f%nQuantidade que atingiu a meta: %d%nQuantidade abaixo da meta: %d%n",
                totalEquipe,mediaEquipe, vendedores[indiceMaiorVenda], vendas[indiceMaiorVenda],vendedores[indiceMenorVenda],vendas[indiceMenorVenda],quantidadeAtingiuMeta,quantidadeAbaixoMeta);
    }

    static void relatorioDesempenho(double[] metas,double[] percentuais, double[] vendas, String[] vendedores) {
        System.out.println("\nRELATÓRIO DE DESEMPENHO");
        for (int i =0;i<vendas.length;i++) {
            if (percentuais[i] >= 120) {
                System.out.printf("%s - Meta: %.2f - Vendas: %.2f - Meta atingida: %.2f%% - Excelente%n",vendedores[i],metas[i],vendas[i],percentuais[i]);
            } else if (percentuais[i] >=100 ) {
                System.out.printf("%s - Meta: %.2f - Vendas: %.2f - Meta atingida: %.2f%% - Meta atingida%n",vendedores[i],metas[i],vendas[i],percentuais[i]);
            } else if (percentuais[i] >= 80) {
                System.out.printf("%s - Meta: %.2f - Vendas: %.2f - Meta atingida: %.2f%% - Próximo da meta%n",vendedores[i],metas[i],vendas[i],percentuais[i]);
            } else {
                System.out.printf("%s - Meta: %.2f - Vendas: %.2f - Meta atingida: %.2f%% - Abaixo da meta%n",vendedores[i],metas[i],vendas[i],percentuais[i]);
            }
        }
    }

    public static void main(String[]args) {
        Scanner input = new Scanner(System.in);

        String[] vendedores = {"Ana", "Carlos", "Pedro", "Maria", "João"};
        double[] metas = {5000.0, 7000.0, 4500.0, 8000.0, 6000.0};
        double[] vendas = new double[5];
        double[] percentuais = new double[5];
        double totalEquipe = 0;

        for (int i = 0;i<vendedores.length;i++) {
            double valorVendido;
            do {
                System.out.print(vendedores[i]+", digite o seu valor vendido: ");
                valorVendido = input.nextDouble();
                if (valorVendido < 0) {
                    System.out.println("Digite um valor válido");
                } else {
                    System.out.println(vendedores[i]+", vendeu: "+valorVendido);
                }
            } while (valorVendido < 0);
            vendas[i] = valorVendido;
            percentuais[i] = vendas[i] / metas[i] * 100;
            totalEquipe += valorVendido;
        }
        double mediaEquipe = totalEquipe / vendas.length;

        double maiorVenda = vendas[0];
        int indiceMaiorVenda = 0;
        indiceMaiorVenda = vendedorMaiorValorVendido(vendas,maiorVenda,indiceMaiorVenda);

        double menorVenda = vendas[0];
        int indiceMenorVenda = 0;
        indiceMenorVenda = vendedorMenorValorVendido(vendas,menorVenda,indiceMenorVenda);

        int quantidadeAtingiuMeta = 0;
        int quantidadeAbaixoMeta = 0;
        quantidadeAtingiuMeta = quantidadeAtingiuMeta(metas,vendas,quantidadeAtingiuMeta);
        quantidadeAbaixoMeta = quantidadeAbaixoMeta(metas,vendas,quantidadeAbaixoMeta);

        relatorioDesempenho(metas,percentuais,vendas,vendedores);
        atingiramMeta(metas,vendas,vendedores);
        resumoFinal(vendedores,vendas,totalEquipe,mediaEquipe,indiceMaiorVenda,indiceMenorVenda,quantidadeAtingiuMeta,quantidadeAbaixoMeta);
    }
}