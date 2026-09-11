package modulo1.exercicios.arrays;

public class SistemaDeEstoque {

    static int produtoTotalUnidades(int[] estoque) {
        int soma = 0;
        for (int i = 0; i <estoque.length; i++) {
            soma += estoque[i];
        }
        return soma;
    }

    static int produtoZerado(int[] estoque) {
        int quantidadeZerado = 0;
        for (int i = 0; i <estoque.length; i++) {
            if (estoque[i] == 0) {
                quantidadeZerado += 1;
            }
        }
        return quantidadeZerado;
    }

    static int produtoEstoqueBaixo(int[] estoque) {
        int estoqueBaixo = 0;
        for (int i = 0; i <estoque.length; i++) {
            if (estoque[i] <= 5 && estoque[i] > 0) {
                estoqueBaixo += 1;
            }
        }
        return estoqueBaixo;
    }

    static int produtoEstoqueNormal(int[] estoque) {
        int estoqueNormal = 0;
        for (int i = 0; i <estoque.length; i++) {
            if (estoque[i] > 5) {
                estoqueNormal += 1;
            }
        }
        return estoqueNormal;
    }

    static int produtoMaiorEstoque(int[]estoque) {
        int maior = estoque[0];
        for (int i = 1; i <estoque.length; i++) {
            if (estoque[i] > maior) {
                maior = estoque[i];
            }
        }
        return maior;
    }

    static int posicaoMaiorEstoque(int[] estoque) {
        int maior = estoque[0];
        int posicaoMaior = 0;
        for (int i = 1; i <estoque.length; i++) {
            if (estoque[i] > maior) {
                maior = estoque[i];
                posicaoMaior = i;
            }
        }
        return posicaoMaior;
    }

    static int produtoMenorEstoque(int[]estoque) {
        int menor = estoque[0];
        for (int i = 1; i <estoque.length; i++) {
            if (estoque[i] < menor) {
                menor = estoque[i];
            }
        }
        return menor;
    }

    static int posicaoMenorEstoque(int[] estoque) {
        int posicaoMenor = 0;
        int menor = estoque[0];
        for (int i = 1; i <estoque.length; i++) {
            if (estoque[i] < menor) {
                menor = estoque[i];
                posicaoMenor = i;
            }
        }
        return posicaoMenor;
    }

    static double mediaUnidadeProduto(int[]estoque,int total) {
        return (double) total / estoque.length;
        }

    static void executarSistema(int total, int estoqueZerado, int estoqueBaixo, int estoqueNormal, int maiorEstoque,int posicaoMaior, int menorEstoque, int posicaoMenor,double media){
        System.out.println("----- RELATÓRIO DE ESTOQUE -----\nTotal de unidades: "+total+"\nProdutos sem estoque: "+estoqueZerado+"\nProdutos com estoque baixo: "+estoqueBaixo+"\nProdutos com estoque normal: "+estoqueNormal+"\nMaior estoque: "+maiorEstoque+" Posição: "+(posicaoMaior+1)+"\nMenor estoque: "+menorEstoque+" Posição: "+(posicaoMenor+1)+"\nMédia de unidades por produto: "+media);
    }

    public static void main(String[]args) {

        int[] estoque = {12, 0, 7, 3, 20, 0, 5, 15};
        int total = produtoTotalUnidades(estoque);
        int estoqueZerado = produtoZerado(estoque);
        int estoqueBaixo = produtoEstoqueBaixo(estoque);
        int estoqueNormal = produtoEstoqueNormal(estoque);
        int maiorEstoque = produtoMaiorEstoque(estoque);
        int posicaoMaior = posicaoMaiorEstoque(estoque);
        int menorEstoque = produtoMenorEstoque(estoque);
        int posicaoMenor = posicaoMenorEstoque(estoque);
        double media = mediaUnidadeProduto(estoque,total);

        executarSistema(total,estoqueZerado,estoqueBaixo,estoqueNormal,maiorEstoque,posicaoMaior,menorEstoque,posicaoMenor,media);

    }
}
