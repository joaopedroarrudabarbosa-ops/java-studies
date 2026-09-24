package modulo1.consolidacao;
import java.util.Scanner;

public class SistemaDeEventos {

    static void exibirMenu() {
        System.out.println("===== EVENTOS =====\n" +
                "\n" +
                "1 - Realizar inscrição\n" +
                "2 - Listar inscrições ativas\n" +
                "3 - Utilizar ingresso\n" +
                "4 - Cancelar inscrição\n" +
                "5 - Consultar inscrição\n" +
                "6 - Exibir relatório\n" +
                "0 - Sair");
    }

    static void exibirIngressos () {
        System.out.println("1 - Standard - R$ 120,00\n" +
                "2 - VIP      - R$ 250,00\n" +
                "3 - Premium  - R$ 400,00");
    }

    static void exibirFormaPagamento () {
        System.out.println("1 - PIX\n" +
                "2 - Débito\n" +
                "3 - Crédito");
    }

    static int realizarInscricao (Scanner input,int quantidadeInscricoes,int[]codigoIngresso,String[]nomeParticipante,String[]tipoIngresso,String[]formaPagamento,double[]valorFinalPago,String[]situacaoInscricao) {
        if (quantidadeInscricoes == codigoIngresso.length) {
            System.out.println("Limite de inscrições atingido.");
            return quantidadeInscricoes;
        }

        System.out.print("Código: ");
        int codigo = input.nextInt();
        for (int i = 0; i < quantidadeInscricoes; i++) {
            if (codigo == codigoIngresso[i]) {
                System.out.println("Código já cadastrado.");
                return quantidadeInscricoes;
            }
        }

        input.nextLine();
        System.out.print("Nome: ");
        String nome = input.nextLine();

        exibirIngressos();
        System.out.print("Tipo de ingresso: ");
        int ingresso = input.nextInt();
        if (ingresso < 1 || ingresso > 3) {
            System.out.println("Tipo de ingresso inválido.");
            return quantidadeInscricoes;
        }

        exibirFormaPagamento();
        System.out.print("Forma de pagamento: ");
        int pagamento = input.nextInt();
        if (pagamento < 1 || pagamento > 3) {
            System.out.println("Forma de pagamento inválida.");
            return quantidadeInscricoes;
        }

        double ingressoValor;
        if (ingresso == 1) {
            ingressoValor = 120;
            tipoIngresso[quantidadeInscricoes] = "Standard";
        } else if (ingresso == 2) {
            ingressoValor = 250;
            tipoIngresso[quantidadeInscricoes] = "VIP";
        } else {
            ingressoValor = 400;
            tipoIngresso[quantidadeInscricoes] = "Premium";
        }

        if (pagamento == 1) {
            formaPagamento[quantidadeInscricoes] = "PIX";
            valorFinalPago[quantidadeInscricoes] = ingressoValor - (ingressoValor * 5 / 100);
        } else if (pagamento == 2) {
            formaPagamento[quantidadeInscricoes] = "Débito";
            valorFinalPago[quantidadeInscricoes] = ingressoValor;
        } else {
            formaPagamento[quantidadeInscricoes] = "Crédito";
            valorFinalPago[quantidadeInscricoes] = ingressoValor + (ingressoValor * 10 / 100);
        }

        codigoIngresso[quantidadeInscricoes] = codigo;
        nomeParticipante[quantidadeInscricoes] = nome;
        situacaoInscricao[quantidadeInscricoes] = "Ativa";

        System.out.println("Inscrição realizada com sucesso.");

        return quantidadeInscricoes+1;
    }

    static void listarInscricoesAtivas (int quantidadeInscricoes,int[]codigoIngresso,String[]nomeParticipante,String[]tipoIngresso,String[]formaPagamento,double[]valorFinalPago,String[]situacaoInscricao) {
        boolean situacaoAtiva = false;
        for (int i = 0; i < quantidadeInscricoes; i++) {
            if (situacaoInscricao[i].equals("Ativa")) {
                situacaoAtiva = true;
                System.out.printf("%d - %s - %s - %s - R$ %.2f%n",codigoIngresso[i],nomeParticipante[i],tipoIngresso[i],formaPagamento[i],valorFinalPago[i]);
            }
        }
        if (!situacaoAtiva) {
            System.out.println("Nenhuma inscrição ativa.");
        }
    }

    static void utilizarIngresso (Scanner input,int quantidadeInscricoes, int[]codigoIngresso,String[]situacaoInscricao) {
        System.out.print("Código: ");
        int codigo = input.nextInt();
        boolean codigoEncontrado = false;
        for (int i = 0; i < quantidadeInscricoes; i++) {
            if (codigo == codigoIngresso[i]) {
                codigoEncontrado = true;
                if (situacaoInscricao[i].equals("Cancelada")) {
                    System.out.println("Inscrição cancelada.");
                }
                if (situacaoInscricao[i].equals("Utilizada")) {
                    System.out.println("Ingresso já utilizado.");
                }
                if (situacaoInscricao[i].equals("Ativa")) {
                    System.out.println("Ingresso utilizado com sucesso.");
                    situacaoInscricao[i] = "Utilizada";
                }
            }
        }
        if (!codigoEncontrado) {
            System.out.println("Inscrição não encontrada.");
        }
    }

    static void cancelarInscricao (Scanner input, int quantidadeInscricoes, int[]codigoIngresso,String[]situacaoInscricao) {
        System.out.print("Código: ");
        int codigo = input.nextInt();
        boolean codigoEncontrado = false;
        for (int i = 0; i < quantidadeInscricoes; i++) {
            if (codigo == codigoIngresso[i]) {
                codigoEncontrado = true;
                if (situacaoInscricao[i].equals("Cancelada")) {
                    System.out.println("Inscrição já está cancelada.");
                }
                if (situacaoInscricao[i].equals("Utilizada")) {
                    System.out.println("Não é possível cancelar um ingresso utilizado.");
                }
                if (situacaoInscricao[i].equals("Ativa")) {
                    System.out.println("Inscrição cancelada com sucesso.");
                    situacaoInscricao[i] = "Cancelada";
                }
            }
        }
        if (!codigoEncontrado) {
            System.out.println("Inscrição não encontrada.");
        }
    }

    static void consultarInscricao (Scanner input, int quantidadeInscricoes,int[]codigoIngresso,String[]nomeParticipante,String[]tipoIngresso,String[]formaPagamento,double[]valorFinalPago,String[]situacaoInscricao) {
        System.out.print("Código: ");
        int codigo = input.nextInt();
        boolean codigoEncontrado = false;
        for(int i = 0; i < quantidadeInscricoes; i++) {
            if (codigo == codigoIngresso[i]) {
                codigoEncontrado = true;
                System.out.printf("Código: %d%n" +
                        "Participante: %s%n" +
                        "Ingresso: %s%n" +
                        "Pagamento: %s%n" +
                        "Valor pago: R$ %.2f%n" +
                        "Situação: %s%n",codigoIngresso[i],nomeParticipante[i],tipoIngresso[i],formaPagamento[i],valorFinalPago[i],situacaoInscricao[i]);
            }
        }
        if (!codigoEncontrado) {
            System.out.println("Inscrição não encontrada.");
        }
    }

    static void exibirRelatorio (int quantidadeInscricoes,String[]situacaoInscricao,double[]valorFinalPago,String[]formaPagamento,String[]nomeParticipante) {
        int totalInscricoesCadastradas = 0;
        totalInscricoesCadastradas += quantidadeInscricoes;
        int inscricoesAtivas = 0;
        int inscricoesUtilizadas = 0;
        int inscricoesCanceladas = 0;
        double faturamentoRealizado = 0;
        int quantidadePix = 0;
        int quantidadeDebito = 0;
        int quantidadeCredito = 0;
        double inscricaoMaiorValor = 0;
        int indiceInscricaoMaiorValor = -1;
        for (int i = 0; i < quantidadeInscricoes; i++) {

            if (situacaoInscricao[i].equals("Ativa")) {
                inscricoesAtivas++;
            }
            if (situacaoInscricao[i].equals("Utilizada")) {
                inscricoesUtilizadas++;
            }
            if (situacaoInscricao[i].equals("Cancelada")) {
                inscricoesCanceladas++;
            }

            if (situacaoInscricao[i].equals("Ativa") || situacaoInscricao[i].equals("Utilizada")) {
                faturamentoRealizado += valorFinalPago[i];
                if (formaPagamento[i].equals("PIX")) {
                    quantidadePix++;
                }
                if (formaPagamento[i].equals("Débito")) {
                    quantidadeDebito++;
                }
                if (formaPagamento[i].equals("Crédito")) {
                    quantidadeCredito++;
                }
                if (inscricaoMaiorValor < valorFinalPago[i]) {
                    inscricaoMaiorValor = valorFinalPago[i];
                    indiceInscricaoMaiorValor = i;
                }
            }
        }

        if (quantidadeInscricoes == 0) {
            System.out.println("Nenhuma inscrição cadastrada.");
        } else {
                System.out.printf("Total de inscrições cadastradas: %d%n" +
                                "Inscrições ativas: %d%n" +
                                "Ingressos utilizados: %d%n" +
                                "Inscrições canceladas: %d%n" +
                                "Faturamento realizado: R$ %.2f%n" +
                                "Quantidade de pagamentos em PIX: %d%n" +
                                "Quantidade de pagamentos em Débito: %d%n" +
                                "Quantidade de pagamentos em Crédito: %d%n", totalInscricoesCadastradas, inscricoesAtivas, inscricoesUtilizadas, inscricoesCanceladas, faturamentoRealizado,
                        quantidadePix, quantidadeDebito, quantidadeCredito);
                int inscricoesValidas = inscricoesAtivas + inscricoesUtilizadas;
            if (inscricoesValidas == 0) {
                System.out.println("Nenhuma inscrição válida.");
            } else {
                double media = faturamentoRealizado / inscricoesValidas;
                System.out.printf("Inscrição de maior valor: R$ %.2f%n" +
                                "Participante responsável pela maior inscrição: %s%n" +
                                "Média dos valores válidos: R$ %.2f%n",valorFinalPago[indiceInscricaoMaiorValor], nomeParticipante[indiceInscricaoMaiorValor],media);
            }
        }
    }

    public static void main(String[]args) {
        Scanner input = new Scanner(System.in);

        int[]codigoInscricao = new int[8];
        String[]nomeParticipante = new String[codigoInscricao.length];
        String[]tipoIngresso = new String[codigoInscricao.length];
        String[]formaPagamento = new String[codigoInscricao.length];
        double[]valorFinalPago = new double[codigoInscricao.length];
        String[]situacaoInscricao = new String[codigoInscricao.length];

        int quantidadeInscricoes = 0;

        int opc;
        do {
            exibirMenu();
            System.out.print("Digite a opção que deseja: ");
            opc = input.nextInt();
            switch (opc) {
                case 1:
                    quantidadeInscricoes = realizarInscricao(input,quantidadeInscricoes,codigoInscricao,nomeParticipante,tipoIngresso,formaPagamento,valorFinalPago,situacaoInscricao);
                    break;
                case 2:
                    listarInscricoesAtivas(quantidadeInscricoes,codigoInscricao,nomeParticipante,tipoIngresso,formaPagamento,valorFinalPago,situacaoInscricao);
                    break;
                case 3:
                    utilizarIngresso(input,quantidadeInscricoes,codigoInscricao,situacaoInscricao);
                    break;
                case 4:
                    cancelarInscricao(input,quantidadeInscricoes,codigoInscricao,situacaoInscricao);
                    break;
                case 5:
                    consultarInscricao(input,quantidadeInscricoes,codigoInscricao,nomeParticipante,tipoIngresso,formaPagamento,valorFinalPago,situacaoInscricao);
                    break;
                case 6:
                    exibirRelatorio(quantidadeInscricoes,situacaoInscricao,valorFinalPago,formaPagamento,nomeParticipante);
                    break;
                case 0:
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