package modulo1.exercicios.switchcase;
import java.util.Scanner;

public class SistemaDeVendas {

    static void exibirMenu() {
        System.out.println("\n===== SISTEMA DE VENDAS =====\n" +
                                "\n1 - Registrar venda\n" +
                                "2 - Ver resumo\n" +
                                "0 - Encerrar");
    }

    static void exibirRegristarVenda() {
        System.out.println("\n===== PRODUTOS =====\n" +
                            "\n1 - Camiseta    R$ 79.90\n" +
                            "2 - Calça       R$ 129.90\n" +
                            "3 - Tênis       R$ 249.90\n" +
                            "4 - Boné        R$ 59.90");
    }

    static void exibirPagamentos() {
        System.out.println("===== PAGAMENTO =====\n" +
                            "\n" +
                            "1 - PIX\n" +
                            "2 - Débito\n" +
                            "3 - Crédito");
    }

    public static void main(String[]args) {
        Scanner input = new Scanner(System.in);

        int quantidadeVendas = 0;
        int quantidadeItens = 0;
        double faturamentoTotal = 0;
        int opc;
        do {
            exibirMenu();
            System.out.print("Digite a opção que deseja: ");
            opc = input.nextInt();
            switch (opc) {
                case 1:
                    exibirRegristarVenda();
                    System.out.print("Digite o produto que deseja: ");
                    int produto = input.nextInt();
                    double produtoPreco = 0;
                    boolean produtoValido = true;
                    int quantidade = 0;
                    switch (produto) {
                        case 1:
                            produtoPreco = 79.90;
                            break;
                        case 2:
                            produtoPreco = 129.90;
                            break;
                        case 3:
                            produtoPreco = 249.90;
                            break;
                        case 4:
                            produtoPreco = 59.90;
                            break;
                        default:
                            produtoValido = false;
                            break;
                    }
                    if (produtoValido) {
                        System.out.print("Digite a quantidade que deseja: ");
                        quantidade = input.nextInt();
                        do {
                            if (quantidade <= 0) {
                                System.out.print("Digite uma quantidade válida: ");
                                quantidade = input.nextInt();
                            }
                        } while (quantidade <= 0);
                        double subtotal = produtoPreco * quantidade;
                        exibirPagamentos();
                        System.out.print("Digite a forma de pagamento: ");
                        int opcPagamento = input.nextInt();
                        double valorFinal = 0;
                        boolean pagamentoValido = true;
                        switch (opcPagamento) {
                            case 1:
                                valorFinal = subtotal - (subtotal *5/100);
                                break;
                            case 2:
                                valorFinal = subtotal;
                                break;
                            case 3:
                                valorFinal = subtotal + (subtotal * 10 / 100);
                                break;
                            default:
                                pagamentoValido = false;
                        }
                        if (pagamentoValido) {
                            System.out.printf("Subtotal: R$ %.2f%n" +
                                    "Valor final: R$ %.2f%n" +
                                    "Venda regristada com sucesso.%n", subtotal,valorFinal);
                            quantidadeVendas++;
                            quantidadeItens += quantidade;
                            faturamentoTotal += valorFinal;
                        } else {
                            System.out.println("Forma de pagamento inválido.");
                        }
                    } else {
                        System.out.println("Produto inválido.");
                    }
                    break;
                case 2:
                    if (quantidadeVendas == 0) {
                        System.out.println("Nenhuma venda regristrada.");
                    } else {
                        double faturamentoMedio = faturamentoTotal / quantidadeVendas;
                        System.out.printf("\n===== RESUMO =====\n" +
                                "\nVendas realizadas: %d%n" +
                                "Itens vendidos: %d%n" +
                                "Faturamento total: R$ %.2f%n" +
                                "Valor médio por venda: R$ %.2f%n",quantidadeVendas,quantidadeItens,faturamentoTotal,faturamentoMedio);
                    }
                    break;
                case 0:
                    if (quantidadeVendas == 0) {
                        System.out.println("Nenhuma venda regristrada.");
                    } else {
                        double faturamentoMedio = faturamentoTotal / quantidadeVendas;
                        System.out.printf(
                                "%n===== RESUMO FINAL =====%n" +
                                        "%nVendas realizadas: %d%n" +
                                        "Itens vendidos: %d%n" +
                                        "Faturamento total: R$ %.2f%n" +
                                        "Valor médio por venda: R$ %.2f%n",
                                quantidadeVendas,
                                quantidadeItens,
                                faturamentoTotal,
                                faturamentoMedio
                        );
                    }
                    System.out.println("Sistema encerrado.");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } while (opc != 0);
        input.close();
    }
}
