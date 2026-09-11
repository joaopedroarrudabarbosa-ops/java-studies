package modulo1.exercicios.arrays;
import java.util.Scanner;

public class SistemaDeReservas {

    static void exibirMenu() {
        System.out.println("1 - Fazer reserva\n" +
                           "2 - Cancelar reserva\n" +
                           "3 - Consultar quarto\n" +
                           "4 - Exibir quartos\n" +
                           "5 - Relatório\n" +
                           "0 - Encerrar");
    }

    static void fazerReserva(Scanner input,int[]quartos,boolean[]ocupados,String[]hospedes,int[]diasReservados,double[]precosDiaria,double[]valoresReservas) {
        System.out.print("Digite o número do quarto que deseja: ");
        int numeroQuarto = input.nextInt();
        boolean encontrado = false;
        for (int i = 0;i<quartos.length;i++) {
            if (numeroQuarto == quartos[i]) {
                encontrado = true;
                if (ocupados[i]) {
                    System.out.println("Quarto já ocupado.");
                    break;
                }
                input.nextLine();
                System.out.print("Digite seu nome: ");
                String nome = input.nextLine();
                System.out.print("Digite a quantidade de dias que deseja: ");
                int dias = input.nextInt();
                do {
                    if (dias <= 0) {
                        System.out.println("Digite uma quantidade válida.");
                        System.out.print("Digite a quantidade de dias que deseja: ");
                        dias = input.nextInt();
                    }
                } while (dias <= 0);
                ocupados[i] = true;
                hospedes[i] = nome;
                diasReservados[i] = dias;
                valoresReservas[i] = precosDiaria[i] * dias;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Quarto não encontrado.");
        }
    }

    static void cancelarReserva(Scanner input,int[]quartos,boolean[]ocupados,String[]hospedes,int[]diasReservados,double[]valoresReservas) {
        System.out.print("Digite o número do quarto que deseja cancelar: ");
        int numeroQuarto = input.nextInt();
        boolean encontrado = false;
        for (int i = 0;i<quartos.length;i++) {
            if (numeroQuarto == quartos[i]) {
                encontrado= true;
                if (ocupados[i]) {
                    System.out.println("Reserva cancelada.");
                    ocupados[i] = false;
                    hospedes[i] = null;
                    diasReservados[i] = 0;
                    valoresReservas[i] = 0;
                } else {
                    System.out.println("Não existe reserva para cancelar.");
                }
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Quarto não encontrado.");
        }
    }

    static void consultarQuarto (Scanner input, int[]quartos,String[]tipos,double[]precosDiaria,boolean[]ocupados,String[]hospedes,int[]diasReservados,double[]valoresReservas) {
        System.out.print("Digite o quarto que deseja consultar: ");
        int numeroQuarto = input.nextInt();
        boolean encontrado = false;
        for (int i =0;i<quartos.length;i++) {
            String status;
            String nomeHospede;
            if (ocupados[i]) {
                status = "Ocupado";
            } else {
                status = "Disponível";
            }
            if (hospedes[i] == null) {
                nomeHospede = "Nenhum";
            } else {
                nomeHospede = hospedes[i];
            }
            if (numeroQuarto == quartos[i]) {
                encontrado = true;
                System.out.printf("%nQuarto: %d%n" +
                        "Tipo: %s%n" +
                        "Preço da diária: %.2f%n" +
                        "Status: %s%n" +
                        "Hóspede: %s%n" +
                        "Dias reservados: %d%n" +
                        "Valor da reserva: %.2f%n%n",
                        quartos[i],tipos[i],precosDiaria[i],status,nomeHospede,diasReservados[i],valoresReservas[i]);
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Quarto não encontrado.");
        }
    }

    static void exibirQuartos(int[]quartos,String[]tipos,double[]precosDiaria,boolean[]ocupados) {
        String[] ocupado = new String[quartos.length];
        for (int i =0;i<quartos.length;i++) {
            if (ocupados[i] == true) {
                ocupado[i] = "Ocupado";
            } else {
                ocupado[i] = "Disponível";
            }
            System.out.printf("%d - %s - %.2f - %s%n",quartos[i],tipos[i],precosDiaria[i],ocupado[i]);
        }
    }

    static void exibirRelatorio(int[]quartos,boolean[]ocupados,double[]valoresReservas,int[]diasReservados,String[]hospedes,String[]tipos) {
        System.out.println("\nRELATÓRIO DO HOTEL\n");
        int quantidadeOcupados = 0;
        int quantidadeDisponivel = 0;
        double totalReservas = 0;
        double maiorReserva = valoresReservas[0];
        int indiceMaiorReserva = 0;
        int maiorDiaReservado = diasReservados[0];
        int indiceMaiorDiaReservado = 0;
        int quantidadeLuxoSuite = 0;
        for(int i =0;i<ocupados.length;i++) {
            if (ocupados[i]) {
                quantidadeOcupados++;
            } else {
                quantidadeDisponivel++;
            }
            if (maiorReserva < valoresReservas[i]) {
                maiorReserva = valoresReservas[i];
                indiceMaiorReserva = i;
            }
            if (maiorDiaReservado < diasReservados[i]) {
                maiorDiaReservado = diasReservados[i];
                indiceMaiorDiaReservado = i;
            }
            if (ocupados[i] && (tipos[i].equalsIgnoreCase("Luxo") || tipos[i].equalsIgnoreCase("Suite"))) {
                quantidadeLuxoSuite++;
            }
            totalReservas+=valoresReservas[i];
        }
        double ocupacaoHotel = (double) quantidadeOcupados / ocupados.length * 100;
        double mediaReservas = 0;
        if (quantidadeOcupados > 0) {
            mediaReservas = totalReservas / quantidadeOcupados;
        }
        System.out.printf("Quartos ocupados: %d%n" +
                "Quartos disponíveis: %d%n" +
                "Ocupação do hotel: %.2f%%%n" +
                "Valor total das reservas: %.2f%n" +
                "Valor médio das reservas: %.2f%n" +
                "Maior reserva: Quarto %d - %.2f%n" +
                "Maior quantidade de dias: Quarto %d - %d dias%n" +
                "Quartos Luxo/Suites ocupados: %d%n",
                quantidadeOcupados,quantidadeDisponivel,ocupacaoHotel,totalReservas,mediaReservas,quartos[indiceMaiorReserva],valoresReservas[indiceMaiorReserva],quartos[indiceMaiorDiaReservado],diasReservados[indiceMaiorDiaReservado],quantidadeLuxoSuite);

        System.out.println("\nHóspedes atuais: ");
        boolean ocupado = false;
        for (int i = 0;i<quartos.length;i++) {
            if (ocupados[i]) {
                ocupado = true;
                System.out.printf("Quarto %d - %s%n%n",quartos[i],hospedes[i]);
            }
        }
        if (!ocupado) {
            System.out.println("Não ha hóspedes no momento.\n");
        }
    }

    public static void main(String[]args) {
        Scanner input = new Scanner(System.in);

        int[] quartos = {101, 102, 103, 104, 105};
        String[] tipos = {"Standard", "Standard", "Luxo", "Luxo", "Suite"};
        double[] precosDiaria = {180.0, 180.0, 300.0, 300.0, 500.0};
        boolean[] ocupados = new boolean[quartos.length];
        String[] hospedes = new String[quartos.length];
        int[] diasReservados = new int[quartos.length];
        double[] valoresReservas = new double[quartos.length];

        int opc;
        do {
            exibirMenu();
            System.out.print("Digite a opção que deseja: ");
            opc = input.nextInt();
            if (opc == 0) {
                System.out.println("Encerrando sistema.");
            } else if (opc == 1) {
                fazerReserva(input,quartos,ocupados,hospedes,diasReservados,precosDiaria,valoresReservas);
            } else if (opc == 2) {
                cancelarReserva(input,quartos,ocupados,hospedes,diasReservados,valoresReservas);
            } else if (opc == 3) {
                consultarQuarto(input,quartos,tipos,precosDiaria,ocupados,hospedes,diasReservados,valoresReservas);
            } else if (opc == 4) {
                exibirQuartos(quartos,tipos,precosDiaria,ocupados);
            } else if (opc == 5) {
                exibirRelatorio(quartos,ocupados,valoresReservas,diasReservados,hospedes,tipos);
            } else {
                System.out.println("Opção inválida.");
            }
        } while (opc != 0);
        input.close();
    }
}
