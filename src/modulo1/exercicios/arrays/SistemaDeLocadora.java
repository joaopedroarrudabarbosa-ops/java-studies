package modulo1.exercicios.arrays;
import java.util.Scanner;

public class SistemaDeLocadora {

    static void exibirMenu() {
        System.out.println("1 - Registrar locação\n" +
                "2 - Devolver veículo\n" +
                "3 - Consultar veículo\n" +
                "4 - Exibir veículos\n" +
                "5 - Relatório\n" +
                "0 - Encerrar");
    }

    static void regristrarLocacao(Scanner input, String[]codigos,boolean[]alugados, String[] clientes,int[] diasAlugados,double[] precosDiaria,double[] valoresLocacaoAtual,int[] quantidadeLocacoes,double[] faturamentoAcumulado) {
        input.nextLine();
        System.out.print("Digite o código do veículo que deseja alugar: ");
        String codigoVeiculo = input.nextLine();
        boolean encontrado = false;
        for (int i = 0;i<codigos.length;i++) {
            if (codigoVeiculo.equalsIgnoreCase(codigos[i])) {
                encontrado = true;
                if (alugados[i]) {
                    System.out.println("Veículo já alugado.");
                } else {
                    System.out.print("Digite seu nome: ");
                    String nome = input.nextLine();
                    System.out.print("Digite a quantidade de dias: ");
                    int dias = input.nextInt();
                    do {
                        if (dias <= 0 ){
                            System.out.println("Quantidade inválida de dias.");
                            System.out.print("Digite a quantidade de dias válida: ");
                            dias = input.nextInt();
                        }
                    } while (dias <= 0);
                    System.out.println("Veículo alugado com sucesso.");
                    alugados[i] = true;
                    clientes[i] = nome;
                    diasAlugados[i] = dias;
                    valoresLocacaoAtual[i] = dias * precosDiaria[i];
                    quantidadeLocacoes[i]++;
                    faturamentoAcumulado[i] += valoresLocacaoAtual[i];
                }
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Veículo não encontrado.");
        }
    }

    static void devolverVeiculo(Scanner input,String[]codigos,boolean[] alugados,String[]clientes,int[] diasAlugados,double[] valoresLocacaoAtual) {
        input.nextLine();
        System.out.print("Digite o código do veículo que deseja devolver: ");
        String codigoVeiculo = input.nextLine();
        boolean encontrado = false;
        for (int i = 0;i<codigos.length;i++) {
            if (codigoVeiculo.equalsIgnoreCase(codigos[i])) {
                encontrado = true;
                if (!alugados[i]) {
                    System.out.println("Não existe locação ativa para este veículo.");
                } else {
                    System.out.println("Veículo devolvido com sucesso.");
                    alugados[i] = false;
                    clientes[i] = null;
                    diasAlugados[i] = 0;
                    valoresLocacaoAtual[i] = 0;
                }
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Veículo não encontrado.");
        }
    }

    static void consultarVeiculo(Scanner input,String[]codigos,String[]modelos,String[]categorias,double[] precosDiaria,boolean[] alugados,String[] clientes,int[] diasAlugados,double[] valoresLocacaoAtual,int[] quantidadeLocacoes,double[] faturamentoAcumulado) {
        input.nextLine();
        System.out.print("Digite o código do veículo que deseja verificar: ");
        String codigoVeiculo = input.nextLine();
        boolean encontrado = false;
        for (int i=0;i<codigos.length;i++) {
            String status;
            String nomeAlugador;
            if (codigoVeiculo.equalsIgnoreCase(codigos[i])) {
                encontrado = true;
                if (alugados[i]) {
                    status = "Alugado";
                } else {
                    status = "Disponível";
                }
                if (clientes[i] == null) {
                    nomeAlugador = "Nenhum";
                } else {
                    nomeAlugador = clientes[i];
                }
                System.out.printf("%nCódigo: %s%n" +
                        "Modelo: %s%n" +
                        "Categoria: %s%n" +
                        "Diária: %.2f%n" +
                        "Status: %s%n" +
                        "Cliente: %s%n" +
                        "Dias de locação atual: %d%n" +
                        "Valor da locação atual: %.2f%n" +
                        "Quantidade histórica de alocações: %d%n" +
                        "Faturamento acumulado: %.2f%n%n",codigos[i],modelos[i],categorias[i],precosDiaria[i],status,nomeAlugador,diasAlugados[i],valoresLocacaoAtual[i],quantidadeLocacoes[i],faturamentoAcumulado[i]);
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Veículo não encontrado.");
        }
    }

    static void exibirVeiculos(String[]codigos,String[]modelos,String[]categorias,double[]precosDiaria,boolean[]alugados) {
        for (int i =0;i<codigos.length;i++) {
            String status;
            if (alugados[i]) {
                status = "Alugado";
            } else {
                status = "Disponível";
            }
            System.out.printf("%nCódigo: %s%n" +
                    "Modelo: %s%n" +
                    "Categoria: %s%n" +
                    "Preço da diária: %.2f%n" +
                    "%s%n",codigos[i],modelos[i],categorias[i],precosDiaria[i],status);
        }
    }

    static void exibirRelatorio(String[]codigos,boolean[]alugados,double[] valoresLocacaoAtual,double[] faturamentoAcumulado,int[] quantidadeLocacoes,int[] diasAlugados,String[] modelos,String[] categorias,String[] clientes) {
        System.out.println("RELATÓRIO DA LOCADORA\n");
        int quantidadeAlugados = 0;
        int quantidadeDisponivel = 0;
        double valoresLocacaoAtiva = 0;
        double faturamentoTotal = 0;
        int totalLocacoesRegristradas =0;
        int maiorLocacao = quantidadeLocacoes[0];
        int indiceMaiorLocacao = 0;
        double maiorFaturamento = faturamentoAcumulado[0];
        int indiceMaiorFaturamento = 0;
        int maiorPeriodoLocacao = diasAlugados[0];
        int indiceMaiorPeriodoLocacao = 0;
        int quantidadeSuv = 0;
        for(int i =0;i<codigos.length;i++) {
            if (alugados[i]) {
                quantidadeAlugados++;
            } else {
                quantidadeDisponivel++;
            }
            if (maiorLocacao < quantidadeLocacoes[i]) {
                maiorLocacao = quantidadeLocacoes[i];
                indiceMaiorLocacao = i;
            }
            if (maiorFaturamento < faturamentoAcumulado[i]) {
                maiorFaturamento = faturamentoAcumulado[i];
                indiceMaiorFaturamento = i;
            }
            if (maiorPeriodoLocacao < diasAlugados[i]) {
                maiorPeriodoLocacao = diasAlugados[i];
                indiceMaiorPeriodoLocacao = i;
            }
            if (alugados[i] && categorias[i].equalsIgnoreCase("SUV")) {
                quantidadeSuv++;
            }
            totalLocacoesRegristradas += quantidadeLocacoes[i];
            valoresLocacaoAtiva += valoresLocacaoAtual[i];
            faturamentoTotal += faturamentoAcumulado[i];
        }
        double porcentagemAlugada = (double) quantidadeAlugados / codigos.length * 100;
        System.out.printf("Veículos alugados: %d%n" +
                        "Veículos disponíveis: %d%n" +
                        "Frota alugada: %.2f%%%n%n" +
                        "Valor das locações ativas: %.2f%n" +
                        "Faturamento acumulado: %.2f%n" +
                        "Total de locações registradas: %d%n" +
                        "SUVs atualmente alugados: %d%n%n",quantidadeAlugados,quantidadeDisponivel,porcentagemAlugada,
                valoresLocacaoAtiva,faturamentoTotal,totalLocacoesRegristradas, quantidadeSuv);

        if (totalLocacoesRegristradas > 0) {
            double valorMediaLocacao = faturamentoTotal / totalLocacoesRegristradas;
            System.out.printf("Valor médio por locação: %.2f%n" +
                            "Veículo com mais locações: %s - %d%n" +
                            "Maior faturamento acumulado: %s - %.2f%n",
                    valorMediaLocacao, modelos[indiceMaiorLocacao], quantidadeLocacoes[indiceMaiorLocacao], modelos[indiceMaiorFaturamento], faturamentoAcumulado[indiceMaiorFaturamento]);
        } else {
            System.out.println("Nenhuma locação registrada.");
        }

        if (quantidadeAlugados > 0) {
            System.out.printf("Maior período de locação atual: %s - %d dias%n", modelos[indiceMaiorPeriodoLocacao], diasAlugados[indiceMaiorPeriodoLocacao]);

        } else {
            System.out.println("Nenhum veículo alugado no momento.");
        }

        System.out.println("Clientes atuais: ");
        boolean encontrado = false;
        for (int i = 0;i<codigos.length;i++) {
            if(alugados[i]) {
                encontrado = true;
                System.out.printf("%s - %s - %s%n",codigos[i],modelos[i],clientes[i]);
            }
        }
        if (!encontrado) {
            System.out.println("Nenhum cliente com locação ativa.");
        }
    }

    public static void main(String[]args) {
        Scanner input  = new Scanner(System.in);

        String[] codigos = {"V101", "V102", "V103", "V104", "V105"};
        String[] modelos = {"Onix", "Corolla", "Compass", "Civic", "SW4"};
        String[] categorias = {"Economico", "Sedan", "SUV", "Sedan", "SUV"};
        double[] precosDiaria = {120.0, 200.0, 280.0, 220.0, 350.0};

        boolean[] alugados = new boolean[codigos.length];
        String[] clientes = new String[codigos.length];
        int[] diasAlugados = new int[codigos.length];
        double[] valoresLocacaoAtual = new double[codigos.length];

        int[] quantidadeLocacoes = new int[codigos.length];
        double[] faturamentoAcumulado = new double[codigos.length];

        int opc;
        do {
            exibirMenu();
            System.out.print("Digite a opção que deseja: ");
            opc = input.nextInt();
            if (opc == 0) {
                System.out.println("Sistema encerrado.");
            } else if (opc == 1) {
                regristrarLocacao(input,codigos,alugados,clientes,diasAlugados,precosDiaria,valoresLocacaoAtual,quantidadeLocacoes,faturamentoAcumulado);
            } else if (opc == 2) {
                devolverVeiculo(input,codigos,alugados,clientes,diasAlugados,valoresLocacaoAtual);
            } else if (opc == 3) {
                consultarVeiculo(input,codigos,modelos,categorias,precosDiaria,alugados,clientes,diasAlugados,valoresLocacaoAtual,quantidadeLocacoes,faturamentoAcumulado);
            } else if (opc == 4) {
                exibirVeiculos(codigos,modelos,categorias,precosDiaria,alugados);
            } else if (opc == 5) {
                exibirRelatorio(codigos,alugados,valoresLocacaoAtual,faturamentoAcumulado,quantidadeLocacoes,diasAlugados,modelos,categorias,clientes);
            } else {
                System.out.println("Opção inválida.");
            }
        } while (opc != 0);
        input.close();
    }
}