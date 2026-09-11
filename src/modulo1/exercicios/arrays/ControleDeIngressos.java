package modulo1.exercicios.arrays;
import java.util.Scanner;

public class ControleDeIngressos {

    static void exibirMenu() {
        System.out.println("1 - Registrar venda" +
                           "\n2 - Consultar filme" +
                           "\n3 - Exibir relatório parcial" +
                           "\n0 - Encerrar");
    }

    static void consultarFilme(Scanner input,String[] filmes,double[] precos,int[] capacidades, int[] ingressosVendidos,double[] faturamentos) {
        input.nextLine();
        System.out.print("Digite o nome do filme que deseja consultar: ");
        String nomeCunsulta = input.nextLine();
        boolean encontrado = false;
        for (int i = 0; i < filmes.length; i++) {
            double ocupacao = (double) ingressosVendidos[i] / capacidades[i] * 100;
            int lugaresDisponiveis = capacidades[i] - ingressosVendidos[i];
            if (nomeCunsulta.equalsIgnoreCase(filmes[i])) {
                encontrado = true;
                System.out.printf("Filme: %s%n Preço: %.2f%n Capacidade: %d%n Ingresso vendido: %d%n Lugares restantes: %d%n Faturamento: %.2f%n Ocupação: %.2f%%%n", filmes[i], precos[i], capacidades[i],ingressosVendidos[i],lugaresDisponiveis, faturamentos[i], ocupacao);
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Filme não encontrado.");
        }
    }

    static void exibirRelatorioParcial(String[] filmes, double[] precos,int[] capacidades,int[] ingressosVendidos,double[] faturamentos) {
        for (int i = 0; i<filmes.length;i++) {
            double ocupacao = (double) ingressosVendidos[i] / capacidades[i] * 100;
            int lugaresDisponiveis = capacidades[i] - ingressosVendidos[i];
            String classificacao;
            if (ocupacao >= 80) {
                classificacao = "Alta ocupação.";
            } else if (ocupacao >= 50) {
                classificacao = "Média ocupação.";
            } else {
                classificacao = "Baixa ocupação.";
            }
            System.out.printf("%nFilme: %s%n " +
                    "Preço: %.2f%n " +
                    "Capacidade: %d%n " +
                    "Ingresso vendido: %d%n " +
                    "Lugares restantes: %d%n " +
                    "Faturamento: %.2f%n " +
                    "Ocupação: %.2f%%%n " +
                    "Classificação: %s%n", filmes[i], precos[i], capacidades[i],ingressosVendidos[i],lugaresDisponiveis, faturamentos[i], ocupacao, classificacao);
        }
    }

    static void exibirRelatorioFinal(int[] ingressosVendidos,double[] faturamentos,String[]filmes,int[] capacidades) {
        int totalIngressosVendidos = 0;
        double totalFaturado = 0;
        int maiorIngressoVendido = ingressosVendidos[0];
        int indiceMaiorIngressoVendido = 0;
        double maiorFaturamento = faturamentos[0];
        int indiceMaiorFaturamento = 0;
        int filmePoucosLugares = 0;
        double[] ocupacao = new double[filmes.length];
        double maiorOcupacao = (double) ingressosVendidos[0] / capacidades[0] * 100;
        int indiceMaiorOcupacao = 0;
        for (int i = 0;i<ingressosVendidos.length;i++) {
            int lugaresDisponiveis = capacidades[i] - ingressosVendidos[i];
            ocupacao[i] = (double) ingressosVendidos[i] / capacidades[i] * 100;
            if (lugaresDisponiveis <= 5) {
                filmePoucosLugares++;
            }
            if (maiorOcupacao < ocupacao[i]) {
                maiorOcupacao = ocupacao[i];
                indiceMaiorOcupacao = i;
            }
            totalIngressosVendidos+=ingressosVendidos[i];
            totalFaturado += faturamentos[i];
            if (ingressosVendidos[i] > maiorIngressoVendido) {
                maiorIngressoVendido = ingressosVendidos[i];
                indiceMaiorIngressoVendido = i;
            }
            if (faturamentos[i] > maiorFaturamento) {
                maiorFaturamento = faturamentos[i];
                indiceMaiorFaturamento = i;
            }
        }
        double mediaFaturada = totalFaturado / faturamentos.length;
        System.out.printf("%nTotal de ingressos vendidos: %d%n Faturamento total: %.2f%n Faturamento médio por filme: %.2f%n Filme com mais ingressos vendidos: %s - %d%n Filme com maior faturamento: %s - %.2f%n Filme com maior ocupação: %s - %.2f%%%n Filmes com 5 lugares ou menos disponíveis: %d%n ",totalIngressosVendidos,totalFaturado,mediaFaturada,filmes[indiceMaiorIngressoVendido],ingressosVendidos[indiceMaiorIngressoVendido],filmes[indiceMaiorFaturamento],maiorFaturamento,filmes[indiceMaiorOcupacao],ocupacao[indiceMaiorOcupacao],filmePoucosLugares);
    }

    public static void main(String[]args) {
        Scanner input = new Scanner(System.in);

        String[] filmes = {"Interestelar", "Matrix", "Duna", "Avatar"};
        double[] precos = {30.0, 25.0, 35.0, 28.0};
        int[] capacidades = {50, 40, 40, 35};
        int[] ingressosVendidos = new int[4];
        double[] faturamentos = new double[4];

        int opc;
        do {
            exibirMenu();
            System.out.print("Digite a opção que deseja: ");
            opc = input.nextInt();
            if (opc == 0) {
                System.out.println("\nRELATÓRIO FINAL");
                exibirRelatorioParcial(filmes, precos, capacidades, ingressosVendidos, faturamentos);
                exibirRelatorioFinal(ingressosVendidos,faturamentos,filmes,capacidades);
                System.out.println("\nEncerrando sistema.");
            }
            else if (opc == 1) {
                input.nextLine();
                System.out.print("Digite o nome do filme: ");
                String nomeFilme = input.nextLine();
                boolean encontrado = false;
                for (int i = 0; i < filmes.length; i++) {
                    if (nomeFilme.equalsIgnoreCase(filmes[i])) {
                        encontrado = true;
                        int lugaresDisponiveis = capacidades[i] - ingressosVendidos[i];
                        int ingressos;
                        do {
                            System.out.print("Digite a quantidade de ingressos: ");
                            ingressos = input.nextInt();
                            if (ingressos <= 0 || ingressos > lugaresDisponiveis) {
                                System.out.println("Digite uma quantidade de ingresso válida.");
                            }
                        } while (ingressos <= 0 || ingressos > lugaresDisponiveis);
                        ingressosVendidos[i] += ingressos;
                        faturamentos[i] += ingressos * precos[i];
                        break;
                    }
                }
                if (!encontrado) {
                    System.out.println("Filme não encontrado.");
                }
            }
            else if (opc == 2) {
                consultarFilme(input, filmes, precos, capacidades, ingressosVendidos, faturamentos);
            }
            else if (opc == 3) {
                exibirRelatorioParcial(filmes, precos, capacidades, ingressosVendidos, faturamentos);
            }
            else if (opc != 1 && opc != 2 && opc != 3 && opc != 0) {
                System.out.println("Opção inválida.");
            }
        } while (opc != 0);
        input.close();
    }
}
