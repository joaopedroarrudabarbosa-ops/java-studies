package modulo1.exercicios.arrays;

public class AnaliseDeVendas {

    static double totalVendido(double[] vendas) {
        double soma = 0;
        for (int i = 0; i < vendas.length; i++) {
            soma += vendas[i];
        }
        return soma;
    }

    static double mediaVendas(double[] vendas, double total) {
        return total / vendas.length;
    }

    static double maiorVenda(double[] vendas) {
        double maior = vendas[0];
        for (int i = 1; i < vendas.length; i++) {
            if (maior < vendas[i]) {
                maior = vendas[i];
            }
        }
        return maior;
    }

    static double menorVenda(double[] vendas) {
        double menor = vendas[0];
            for (int i = 1; i < vendas.length; i++) {
            if (menor > vendas[i]) {
                menor = vendas[i];
            }
        }
            return menor;
    }

    static int acimaMedia(double[] vendas, double media) {
        int acimaMedia = 0;
        for (int i = 0; i < vendas.length; i++) {
            if (vendas[i] > media) {
                acimaMedia += 1;
            }
        }
        return acimaMedia;
    }

    static int abaixoMedia(double[] vendas, double media) {
        int abaixoMedia = 0;
        for (int i = 0; i < vendas.length; i++) {
            if (vendas[i] < media) {
                abaixoMedia += 1;
            }
        }
        return abaixoMedia;
    }

    static void executarSistema(double total, double media, double maior, double menor, int acimaMedia, int abaixoMedia) {
        System.out.println("Total vendido: "+total+"\nMédia de vendas: "+media+"\nMaior venda: "+maior+"\nMenor venda: "+menor+"\nVendas acima da média: "+acimaMedia+"\nVendas abaixo da média: "+abaixoMedia);
    }

    public static void main(String[]args) {

        double[] vendas = {150.0, 80.0, 220.0, 50.0, 300.0, 175.0, 90.0, 400.0};

        double total = totalVendido(vendas);
        double media = mediaVendas(vendas, total);
        double maior = maiorVenda(vendas);
        double menor = menorVenda(vendas);
        int acimaMedia = acimaMedia(vendas, media);
        int abaixoMedia = abaixoMedia(vendas, media);

        executarSistema(total,media,maior,menor,acimaMedia,abaixoMedia);


    }
}
