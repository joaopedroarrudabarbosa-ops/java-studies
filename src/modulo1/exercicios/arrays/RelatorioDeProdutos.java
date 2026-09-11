package modulo1.exercicios.arrays;

public class RelatorioDeProdutos {

    static double soma(double[] precos) {
        double soma = 0;
        for (int i = 0; i< precos.length; i++) {
        soma += precos[i];
        }
        return soma;
    }

    static int valorMaisCaro(double[] precos, double valorMaisCaro, int indiceMaisCaro) {
        for (int i = 1; i<precos.length; i++) {
            if (valorMaisCaro < precos[i]) {
                valorMaisCaro = precos[i];
                indiceMaisCaro = i;
            }
        }
        return indiceMaisCaro;
    }

    static int valorMaisBarato(double[] precos, double valorMaisBarato, int indiceMaisBarato) {
        for (int i = 1; i<precos.length; i++) {
            if (valorMaisBarato > precos[i]) {
                valorMaisBarato = precos[i];
                indiceMaisBarato = i;
            }
        }
        return indiceMaisBarato;
    }

    static int quantidadeAcima200(double[]precos) {
        int quantidadeAcima200 = 0;
        for (int i =0;i<precos.length;i++) {
            if (precos[i] > 200) {
                quantidadeAcima200++;
            }
        }
        return quantidadeAcima200;
    }

    static void exibirProdutos(double[] precos, String[] produtos) {
        System.out.println("Produtos: ");
        for (int i = 0;i<precos.length;i++) {
            System.out.println(produtos[i] + " - " +precos[i]);
        }
    }
    static void exibirProdutosMais200(double[] precos, String[] produtos) {
        System.out.println("\nProdutos acima de 200: ");
        for (int i =0;i<precos.length;i++) {
            if (precos[i] > 200) {
                System.out.println(produtos[i] +" - " + precos[i]);
            }
        }
    }

    static void exibirProdutosAtualizados(double[] precos, String[] produtos) {
        System.out.println("\nPreços atualizados: ");
        for (int i = 0;i<precos.length;i++) {
            if (precos[i] < 200) {
                precos[i] *= 1.10;
            }
            System.out.printf("%s - %.2f%n", produtos[i], precos[i]);
        }
    }

    static void exibirResumo(double[] preco, String[] produtos,double soma, double media, int indiceMaisCaro, int indiceMaisBarato, int quantidadeAcima200) {
        System.out.println("\nTotal dos preços: "+soma+"\nMédia dos preços: "+media+"\nProduto mais caro: "+produtos[indiceMaisCaro]+" - "+preco[indiceMaisCaro]+"\nProduto mais barato: "+produtos[indiceMaisBarato]+" - "+preco[indiceMaisBarato]+"\nQuantidade acima de 200: "+quantidadeAcima200);
    }

    public static void main(String[]args) {

        String[] produtos = {"Mouse", "Teclado", "Monitor", "Headset", "Webcam"};
        double[] precos = {90.0, 180.0, 850.0, 250.0, 120.0};

        double soma = soma(precos);
        double media = soma / precos.length;
        double valorMaisCaro = precos[0];
        int indiceMaisCaro = 0;
        indiceMaisCaro = valorMaisCaro(precos, valorMaisCaro, indiceMaisCaro);
        double valorMaisBarato = precos[0];
        int indiceMaisBarato = 0;
        indiceMaisBarato = valorMaisBarato(precos, valorMaisBarato, indiceMaisBarato);
        int quantidadeAcima200 = quantidadeAcima200(precos);

        exibirProdutos(precos,produtos);
        exibirProdutosMais200(precos,produtos);
        exibirResumo(precos,produtos,soma, media, indiceMaisCaro,indiceMaisBarato,quantidadeAcima200);
        exibirProdutosAtualizados(precos,produtos);
    }
}
