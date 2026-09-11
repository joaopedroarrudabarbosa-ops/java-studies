package modulo1.exercicios.repeticoes;
import java.util.Scanner;

public class SistemaDePedidos{

    static void exibirMenu() {
        System.out.print("----- SISTEMA DE PEDIDOS -----" +
                                "\n1 - Adicionar produto." +
                                "\n2 - Remover valor." +
                                "\n3 - Consultar total." +
                                "\n4 - Exibir resumo." +
                                "\n0 - Finalizar pedido." +
                                "\nEscolha uma opção: ");
    }


    static void exibirResumo(int produtosValidos, double totalProdutos, double media,double maiorValor, double menorValor, int remocoesValidas, double totalRemovido, double totalAtual) {
        System.out.print("----- RESUMO DO PEDIDO -----" +
                        "\nProdutos adicionados: " +produtosValidos+
                        "\nTotal dos produtos: " +totalProdutos+
                        "\nPreço médio: " +media+
                        "\nProduto mais caro: " +maiorValor+
                        "\nProduto mais barato: " +menorValor+
                        "\nRemoções realizadas: " +remocoesValidas+
                        "\nTotal removido: " +totalRemovido+
                        "\nTotal atual: " +totalAtual+"\n");
    }

    static double maiorValor(double maiorValor, double novoMaiorValor) {
        if (maiorValor > novoMaiorValor) {
            novoMaiorValor = maiorValor;
        }
        return novoMaiorValor;
    }

    static double menorValor(double menorValor, double novoMenorValor) {
        if (menorValor < novoMenorValor) {
            novoMenorValor = menorValor;
        }
        return novoMenorValor;
    }

    public static void main(String[]args) {
    Scanner input = new Scanner(System.in);

    double totalProdutos = 0;
    double totalAtual = 0;
    int opc;
    double preco;
    int produtosValidos = 0;
    double maiorValor = 0;
    double menorValor = 0;
    double remover = 0;
    int remocoesValidas = 0;
    double totalRemovido = 0;
    double media = 0;

    do {
        exibirMenu();
        opc = input.nextInt();
        if (opc == 0) {
            System.out.print("Pedido finalizado.");
        } else {
            if (opc == 1) {
                System.out.print("Digite o preço do produto: ");
                preco = input.nextDouble();
                if (preco > 0) {
                    totalAtual += preco;
                    produtosValidos++;
                    if (produtosValidos == 1) {
                        menorValor = preco;
                    }
                    media = totalAtual / produtosValidos;
                    totalProdutos += preco;
                    maiorValor = maiorValor(maiorValor, preco);
                    menorValor = menorValor(menorValor, preco);
                } else {
                    System.out.println("Preço inválido.");
                }
            } else if (opc == 2) {
                System.out.print("Digite um valor para remover do total: ");
                remover = input.nextDouble();
                if (remover > 0) {
                    if (remover > totalProdutos) {
                        System.out.println("Valor maior que o total do pedido.");
                    } else {
                        totalProdutos -= remover;
                        remocoesValidas++;
                        totalRemovido += remover;
                    }
                } else {
                    System.out.println("Valor inválido.");
                }
            } else if (opc == 3) {
                System.out.println(totalProdutos);
            } else if (opc == 4) {
                exibirResumo(produtosValidos, totalAtual, media,maiorValor,menorValor,remocoesValidas,totalRemovido,totalProdutos);
            } else {
                System.out.println("Opção inválida.");
            }
        }
    } while (opc != 0);

    }
}
