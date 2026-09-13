package modulo1.exercicios.switchcase;
import java.util.Scanner;

public class SistemaDePedidos {

    static void exibirMenu() {
        System.out.println("\n===== LANCHONETE =====\n" +
                            "\n" +
                            "1 - Adicionar produto\n" +
                            "2 - Ver pedido\n" +
                            "0 - Finalizar pedido");
    }
    static void exibirProdutos() {
        System.out.print("\n===== PRODUTOS =====\n" +
                            "\n" +
                            "1 - Hambúrguer: R$ 18.50\n" +
                            "2 - Batata: R$ 9.00\n" +
                            "3 - Refrigerante: R$ 6.50\n" +
                            "4 - Sobremesa: R$ 12.00\n");
    }

    static void verPedido(double totalPedido, int quantidadeProduto) {
        System.out.printf("%n===== PEDIDO ATUAL =====%n" +
                            "%nQuantidade de itens: %d%n" +
                            "Valor total: R$ %.2f%n",quantidadeProduto,totalPedido);
    }



    public static void main(String[]args) {
        Scanner input = new Scanner(System.in);
        double totalPedido = 0;
        int quantidadeProduto = 0;

        int opc;
        do {
            exibirMenu();
            System.out.print("Digite a opção que deseja: ");
            opc = input.nextInt();
            switch (opc) {
                case 1:
                    exibirProdutos();
                    System.out.print("Digite o produto que deseja: ");
                    int produto = input.nextInt();
                    double preco = 0;
                    String nomeProduto = "";
                    boolean produtoValido = true;
                    switch (produto) {
                        case 1:
                            preco = 18.50;
                            nomeProduto = "Hambúrguer";
                            break;
                        case 2:
                            preco = 9.00;
                            nomeProduto = "Batata";
                            break;
                        case 3:
                            preco = 6.50;
                            nomeProduto = "Refrigerante";
                            break;
                        case 4:
                            nomeProduto = "Sobremesa";
                            preco = 12.00;
                            break;
                        default:
                            System.out.println("Opção inválida.");
                            produtoValido = false;
                            break;
                    }
                    if (produtoValido) {
                        System.out.print("Digite a quantidade desejada: ");
                        int quantidade = input.nextInt();
                        while (quantidade <= 0) {
                            System.out.println("Quantidade inválida.");
                            System.out.print("Digite uma quantidade válida: ");
                            quantidade = input.nextInt();
                        }
                        double subtotal = preco * quantidade;
                        quantidadeProduto += quantidade;
                        totalPedido += subtotal;
                        System.out.printf("Produto %s registrado com sucesso.%n" +
                                        "Subtotal: R$ %.2f%n", nomeProduto, subtotal);
                    }
                    break;
                case 2:
                    verPedido(totalPedido,quantidadeProduto);
                    break;
                case 0:
                    System.out.printf("%n===== PEDIDO FINAL =====%n" +
                            "%nValor total: R$ %.2f%n" +
                            "Quantidade de itens: %d%n" +
                            "Encerrando sistema.%n",totalPedido,quantidadeProduto);
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } while (opc != 0);
        input.close();
    }
}
