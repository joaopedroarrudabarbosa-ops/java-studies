package modulo1.consolidacao;
import java.util.Scanner;

public class SistemaDeOficina {

    static void exibirMenu () {
        System.out.println("\n===== OFICINA =====\n" +
                "\n" +
                "1 - Abrir ordem de serviço\n" +
                "2 - Listar ordens abertas\n" +
                "3 - Finalizar ordem\n" +
                "4 - Cancelar ordem\n" +
                "5 - Consultar ordem\n" +
                "6 - Exibir relatório\n" +
                "0 - Sair");
    }

    static void exibirServicos () {
        System.out.println("\n1 - Revisão      - R$ 200,00\n" +
                "2 - Freios       - R$ 350,00\n" +
                "3 - Suspensão    - R$ 500,00");
    }

    static int abrirOrdem (int quantidadeOrdens, Scanner input, int[]codigoOrdem,String[]tipoServico,String[]nomeCliente,double[] valorPecas,double[] valorTotal,String[] situacaoOrdem) {

        if (quantidadeOrdens == codigoOrdem.length) {
            System.out.println("Limite de ordens atingido.");
            return quantidadeOrdens;
        }

        System.out.print("\nCódigo da ordem: ");
        int codigo = input.nextInt();
        for (int i = 0; i < quantidadeOrdens; i++) {
            if (codigo == codigoOrdem[i]) {
                System.out.println("Código de ordem já cadastrado.");
                return quantidadeOrdens;
            }
        }

        input.nextLine();
        System.out.print("Nome do cliente: ");
        String nome = input.nextLine();

        exibirServicos();
        System.out.print("Tipo de serviço: ");
        int servico = input.nextInt();
            if (servico < 1 || servico > 3) {
                System.out.println("Tipo de serviço inválido.");
                return quantidadeOrdens;
            }

        System.out.print("Valor das peças: ");
        double valor = input.nextDouble();
        if (valor < 0 ) {
            System.out.println("Valor das peças inválido.");
            return quantidadeOrdens;
        }

        double valorServico;
        if (servico == 1) {
            valorServico = 200;
            tipoServico[quantidadeOrdens] = "Revisão";
            valorTotal[quantidadeOrdens] = valorServico + valor;
        } else if (servico == 2) {
            valorServico = 350;
            tipoServico[quantidadeOrdens] = "Freios";
            valorTotal[quantidadeOrdens] = valorServico + valor;
        } else {
            valorServico = 500;
            tipoServico[quantidadeOrdens] = "Suspensão";
            valorTotal[quantidadeOrdens] = valorServico + valor;
        }

        codigoOrdem[quantidadeOrdens]  = codigo;
        nomeCliente[quantidadeOrdens] = nome;
        valorPecas[quantidadeOrdens] = valor;
        situacaoOrdem[quantidadeOrdens] = "Aberta";

        System.out.println("\nOrdem aberta com sucesso.");
        System.out.printf("Serviço: %s%n" +
                "Valor do serviço: %.2f%n" +
                "Peças: %.2f%n" +
                "%nValor total: %.2f%n",tipoServico[quantidadeOrdens],valorServico,valor,valorTotal[quantidadeOrdens]);

        return quantidadeOrdens+1;
    }

    static void listarOrdem (Scanner input, int quantidadeOrdens, String[]situacaoOrdem,int[]codigoOrdem,String[]nomeCliente,String[]tipoServico,double[]valorTotal) {
        boolean ordemEncontrada = false;
        for (int i = 0; i < quantidadeOrdens; i++) {
            if (situacaoOrdem[i].equals("Aberta")) {
                ordemEncontrada = true;
                System.out.printf("%n%d - %s - %s - R$ %.2f%n",codigoOrdem[i],nomeCliente[i],tipoServico[i],valorTotal[i]);
            }
        }
        if (!ordemEncontrada) {
            System.out.println("\nNenhuma ordem aberta.");
        }
    }

    static void finalizarOrdem (Scanner input, int quantidadeOrdens, int[]codigoOrdem,String[]situacaoOrdem) {
        System.out.print("\nCódigo da ordem: ");
        int codigo = input.nextInt();
        boolean ordemEncontrada = false;
        for (int i = 0; i < quantidadeOrdens; i++) {
            if (codigo == codigoOrdem[i]) {
                ordemEncontrada = true;
                if (situacaoOrdem[i].equals("Cancelada")) {
                    System.out.println("Ordem cancelada.");
                }
                if (situacaoOrdem[i].equals("Finalizada")) {
                    System.out.println("Ordem já finalizada.");
                }
                if (situacaoOrdem[i].equals("Aberta")) {
                    System.out.println("Ordem finalizada com sucesso.");
                    situacaoOrdem[i] = "Finalizada";
                }
            }
        }

        if (!ordemEncontrada) {
            System.out.println("Ordem não encontrada.");
        }
    }

    static void cancelarOrdem (Scanner input, int quantidadeOrdens, int[]codigoOrdem,String[]situacaoOrdem) {
        System.out.print("Código da ordem: ");
        int codigo = input.nextInt();
        boolean ordemEncontrada = false;
        for (int i = 0; i < quantidadeOrdens; i++) {
            if (codigo == codigoOrdem[i]) {
                ordemEncontrada = true;
                if (situacaoOrdem[i].equals("Cancelada")) {
                    System.out.println("Ordem já está cancelada.");
                }
                if (situacaoOrdem[i].equals("Finalizada")) {
                    System.out.println("Não é possível cancelar uma ordem finalizada.");
                }
                if (situacaoOrdem[i].equals("Aberta")) {
                    System.out.println("Ordem cancelada com sucesso.");
                    situacaoOrdem[i] = "Cancelada";
                }
            }
        }

        if (!ordemEncontrada) {
            System.out.println("Ordem não encontrada.");
        }
    }

    static void consultarOrdem (Scanner input, int quantidadeOrdens, int[]codigoOrdem,String[]nomeCliente,String[]tipoServico,double[]valorPecas,double[]valorTotal,String[]situacaoOrdem) {
        System.out.print("\nCódigo da ordem: ");
        int codigo = input.nextInt();
        boolean ordemEncontrada = false;
        for (int i = 0; i < quantidadeOrdens; i++) {
            if (codigo == codigoOrdem[i]) {
                ordemEncontrada = true;
                System.out.printf("Código: %d%n" +
                        "Cliente: %s%n" +
                        "Serviço: %s%n" +
                        "Peças: %.2f%n" +
                        "Valor total: %.2f%n" +
                        "Situação: %s%n",codigoOrdem[i],nomeCliente[i],tipoServico[i],valorPecas[i],valorTotal[i],situacaoOrdem[i]);
            }
        }

        if (!ordemEncontrada) {
            System.out.println("Ordem não encontrada.");
        }
    }

    static void exibirRelatorio (int quantidadeOrdens,double[]valorTotal,String[]situacaoOrdem,double[]valorPecas,String[]nomeCliente) {
        int totalOrdemCadastradas = 0;
        totalOrdemCadastradas += quantidadeOrdens;
        int ordemAbertas = 0;
        int ordemFinalizadas = 0;
        int ordemCanceladas = 0;
        double valorTotalPecas = 0;
        double faturamentoRealizado = 0;
        double maiorOrdemCadastrada = valorTotal[0];
        int indiceMaiorOrdemCadastrada = 0;

        for (int i = 0; i < quantidadeOrdens; i++) {
            if (situacaoOrdem[i].equals("Aberta")) {
                ordemAbertas++;
            }
            if (situacaoOrdem[i].equals("Cancelada")) {
                ordemCanceladas++;
            }
            if (situacaoOrdem[i].equals("Finalizada")) {
                ordemFinalizadas++;
                faturamentoRealizado += valorTotal[i];
            }
            valorTotalPecas += valorPecas[i];

            if (maiorOrdemCadastrada < valorTotal[i]) {
                maiorOrdemCadastrada = valorTotal[i];
                indiceMaiorOrdemCadastrada = i;
            }
        }

        if (quantidadeOrdens == 0) {
            System.out.println("\nNenhuma ordem cadastrada.");
        } else {
            System.out.printf("%nTotal de ordens cadastradas: %d%n" +
                    "Ordens abertas: %d%n" +
                    "Ordens finalizadas: %d%n" +
                    "Ordens canceladas: %d%n" +
                    "Valor total gasto em peças: R$ %.2f%n" +
                    "Faturamento realizado: R$ %.2f%n" +
                    "Maior ordem cadastrada: R$ %.2f%n" +
                    "Cliente responsável pela maior ordem: %s%n",totalOrdemCadastradas,ordemAbertas,ordemFinalizadas,ordemCanceladas,
                    valorTotalPecas,faturamentoRealizado,valorTotal[indiceMaiorOrdemCadastrada],nomeCliente[indiceMaiorOrdemCadastrada]);
            if (ordemFinalizadas == 0) {
                System.out.println("Nenhuma ordem finalizada.");
            } else {
                double media = faturamentoRealizado / ordemFinalizadas;
                System.out.printf("Média das ordens finalizadas: R$ %.2f%n",media);
            }
        }
    }

    public static void main(String[]args) {
        Scanner input = new Scanner(System.in);

        int[] codigoOrdem = new int[6];
        String[] nomeCliente = new String[codigoOrdem.length];
        String[] tipoServico = new String[codigoOrdem.length];
        double[] valorPecas = new double[codigoOrdem.length];
        double[] valorTotal = new double[codigoOrdem.length];
        String[] situacaoOrdem = new String[codigoOrdem.length];

        int quantidadeOrdens = 0;
        int opc;

        do {
            exibirMenu();
            System.out.print("Digite a opção que deseja: ");
            opc = input.nextInt();
            switch (opc) {
                case 1:
                    quantidadeOrdens = abrirOrdem(quantidadeOrdens,input,codigoOrdem,tipoServico,nomeCliente,valorPecas,valorTotal,situacaoOrdem);
                    break;
                case 2:
                    listarOrdem(input,quantidadeOrdens,situacaoOrdem,codigoOrdem,nomeCliente,tipoServico,valorTotal);
                    break;
                case 3:
                    finalizarOrdem(input,quantidadeOrdens,codigoOrdem,situacaoOrdem);
                    break;
                case 4:
                    cancelarOrdem(input,quantidadeOrdens,codigoOrdem,situacaoOrdem);
                    break;
                case 5:
                    consultarOrdem(input,quantidadeOrdens,codigoOrdem,nomeCliente,tipoServico,valorPecas,valorTotal,situacaoOrdem);
                    break;
                case 6:
                    exibirRelatorio(quantidadeOrdens,valorTotal,situacaoOrdem,valorPecas,nomeCliente);
                    break;
                case 0:
                    System.out.println("Sistema encerrado.");
                    break;
                default:
                    System.out.println("\nOpção inválida.");
                    break;
            }
        } while (opc != 0);
        input.close();
    }
}