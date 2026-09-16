package modulo1.exercicios.switchcase;
import java.util.Scanner;

public class SistemaDeViagens {

    static void exibirMenu() {
        System.out.println("===== AGÊNCIA DE VIAGENS =====\n" +
                                "\n" +
                                "1 - Registrar pacote\n" +
                                "2 - Ver resumo\n" +
                                "0 - Encerrar");
    }

    static void exibirDestino() {
        System.out.println("===== DESTINOS =====\n" +
                "\n" +
                "1 - Rio de Janeiro    R$ 800.00 por pessoa\n" +
                "2 - Foz do Iguaçu     R$ 1000.00 por pessoa\n" +
                "3 - Gramado            R$ 1200.00 por pessoa\n" +
                "4 - Salvador           R$ 900.00 por pessoa");
    }

    static void exibirHospedagem() {
        System.out.println("===== HOSPEDAGEM =====\n" +
                "\n" +
                "1 - Econômica\n" +
                "2 - Conforto\n" +
                "3 - Premium");
    }

    static void exibirTransporte() {
        System.out.println("===== TRANSPORTE =====\n" +
                "\n" +
                "1 - Rodoviário\n" +
                "2 - Aéreo");
    }

    static void exibirPagamentos() {
        System.out.println("===== PAGAMENTO =====\n" +
                "\n" +
                "1 - PIX\n" +
                "2 - Débito\n" +
                "3 - Crédito");
    }

    static void exibirResumo(int quantidadeVendidos, int quantidadePessoas, double faturamentoTotal, int quantidadePix, int quantidadeCredito, int quantidadeDebito, int quantidadeTransporteAereo) {
        if (quantidadeVendidos == 0) {
            System.out.println("Nenhum pacote registrado.");
        } else {
            double faturamentoMedio = faturamentoTotal / quantidadeVendidos;
            System.out.printf("%n===== RESUMO =====%n" +
                    "%nPacotes vendidos: %d%n" +
                    "Total de viajantes: %d%n" +
                    "Faturamento total: R$ %.2f%n" +
                    "Valor médio por pacote: R$ %.2f%n" +
                    "%nPagamentos via PIX: %d%n" +
                    "Pagamentos via Débito: %d%n" +
                    "Pagamentos via Crédito: %d%n" +
                    "%nPacotes com transporte aéreo: %d%n", quantidadeVendidos, quantidadePessoas, faturamentoTotal, faturamentoMedio, quantidadePix, quantidadeDebito, quantidadeCredito, quantidadeTransporteAereo);
        }
    }

    public static void main(String[]args) {
        Scanner input  = new Scanner(System.in);

        double faturamentoTotal = 0;
        int  quantidadePessoas = 0;
        int quantidadeVendidos = 0;
        int quantidadePix = 0;
        int quantidadeDebito = 0;
        int quantidadeCredito = 0;
        int quantidadeTransporteAereo = 0;

        int opc;
        do {
            exibirMenu();
            System.out.print("Digite a opção que deseja: ");
            opc = input.nextInt();
            switch (opc) {
                case 1:
                    exibirDestino();
                    System.out.println("Digite o destino que deseja: ");
                    int destino = input.nextInt();
                    double valorDestino = 0;
                    double subtotal = 0;
                    double preco = 0;
                    int pessoas = 0;
                    String destinoNome = "";
                    boolean destinoCorreto = true;
                    switch (destino) {
                        case 1:
                            destinoNome = "Rio de Janeiro";
                            preco = 800;
                            break;
                        case 2:
                            destinoNome = "Foz do Iguaçu";
                            preco = 1000;
                            break;
                        case 3:
                            destinoNome = "Gramado";
                            preco = 1200;
                            break;
                        case 4:
                            destinoNome = "Salvador";
                            preco = 900;
                            break;
                        default:
                            destinoCorreto = false;
                    }
                    if (destinoCorreto) {
                        System.out.print("Digite a quantidade de pessoas: ");
                        pessoas = input.nextInt();
                        do {
                            if (pessoas <=0) {
                                System.out.print("Digite uma quantidade de pessoas válida: ");
                                pessoas = input.nextInt();
                            }
                        } while (pessoas<=0);
                        valorDestino = preco * pessoas;
                        exibirHospedagem();
                        System.out.print("Digite a categoria que deseja: ");
                        int hospedagem = input.nextInt();
                        double taxa = 0;
                        double hospedagemTotal = 0;
                        boolean hospedagemValida = true;
                        switch (hospedagem) {
                            case 1:
                                System.out.println("Econômica - Sem acréscimo.");
                                break;
                            case 2:
                                taxa = 0.20;
                                hospedagemTotal = taxa * valorDestino;
                                break;
                            case 3:
                                taxa = 0.40;
                                hospedagemTotal = valorDestino * taxa;
                                break;
                            default:
                                hospedagemValida = false;
                                System.out.println("Hospedagem inválida.");
                                break;
                        } if (hospedagemValida) {
                            exibirTransporte();
                            System.out.print("Digite o transporte que deseja: ");
                            int transporte = input.nextInt();
                            double transporteTotal = 0;
                            boolean transporteValido = true;
                            switch (transporte) {
                                case 1:
                                    System.out.println("Rodoviário = Sem custo adicional.");
                                    break;
                                case 2:
                                    transporteTotal = 300 * pessoas;
                                    break;
                                default:
                                    transporteValido = false;
                                    System.out.println("Transporte inválido.");
                            } if (transporteValido) {
                                subtotal += valorDestino + hospedagemTotal + transporteTotal;
                                exibirPagamentos();
                                System.out.print("Digite a forma de pagamento: ");
                                int pagamento = input.nextInt();
                                double valorFinal = 0;
                                boolean pagamentoValida = true;
                                switch (pagamento) {
                                    case 1:
                                        taxa = 0.05;
                                        valorFinal = subtotal - (subtotal * taxa);
                                        break;
                                    case 2:
                                        valorFinal = subtotal;
                                        System.out.println("Débito - Sem alteração no valor.");
                                        break;
                                    case 3:
                                        taxa = 0.10;
                                        valorFinal = subtotal + (subtotal * taxa);
                                        break;
                                    default:
                                        pagamentoValida = false;
                                        System.out.println("Forma de pagamento inválida.");
                                        break;
                            } if (pagamentoValida) {
                                    faturamentoTotal += valorFinal;
                                    quantidadeVendidos++;
                                    if (pagamento == 1) {
                                        quantidadePix++;
                                    } else if (pagamento == 2) {
                                        quantidadeDebito++;
                                    } else if (pagamento == 3) {
                                        quantidadeCredito++;
                                    }
                                    if (transporte == 2) {
                                        quantidadeTransporteAereo++;
                                    }
                                    quantidadePessoas += pessoas;
                                    System.out.printf("%n===== PACOTE REGISTRADO =====%n" +
                                            "%nDestino: %s%n" +
                                            "Viajantes: %d%n" +
                                            "Subtotal: R$ %.2f%n" +
                                            "Valor final: R$ %.2f%n" +
                                            "Pacote registrado com sucesso.",destinoNome,pessoas,subtotal,valorFinal);
                                }
                        }
                    } else {
                        System.out.println("Destino inválido.");
                        }
                    }
                    break;
                case 2:
                    exibirResumo(quantidadeVendidos,quantidadePessoas,faturamentoTotal,quantidadePix,quantidadeCredito,quantidadeDebito,quantidadeTransporteAereo);
                    break;
                case 0:
                    exibirResumo(quantidadeVendidos,quantidadePessoas,faturamentoTotal,quantidadePix,quantidadeCredito,quantidadeDebito,quantidadeTransporteAereo);
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
