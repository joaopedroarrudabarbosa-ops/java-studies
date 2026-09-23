package modulo1.consolidacao;
import java.util.Scanner;

public class SistemaDeHotel {

    static void exibirMenu() {
        System.out.println("===== HOTEL =====\n" +
                "\n" +
                "1 - Fazer reserva\n" +
                "2 - Listar reservas ativas\n" +
                "3 - Finalizar estadia\n" +
                "4 - Cancelar reserva\n" +
                "5 - Consultar reserva\n" +
                "6 - Exibir relatório\n" +
                "0 - Sair");
    }

    static void exibirQuartos() {
        System.out.println("1 - Standard - R$ 180,00 por noite\n" +
                "2 - Luxo     - R$ 300,00 por noite\n" +
                "3 - Suíte    - R$ 500,00 por noite");
    }

    static int fazerReserva(int quantidadeReservas,Scanner input,int[]codigoReservas,String[]nomeHospedes,String[]tipoQuartos,int[]quantidadeNoites,String[]situacaoReserva,double[] valorTotalReserva) {
        if (quantidadeReservas == codigoReservas.length) {
            System.out.println("Limite de reservas atingido.");
            return quantidadeReservas;
        }

        System.out.print("Código da reserva: ");
        int codigo = input.nextInt();
        for (int i = 0;i < quantidadeReservas;i++) {
            if (codigo == codigoReservas[i]) {
                System.out.println("Código de reserva já cadastrado.");
                return quantidadeReservas;
            }
        }

        input.nextLine();
        System.out.print("Nome do hóspede: ");
        String hospede = input.nextLine();

        exibirQuartos();
        System.out.print("Tipo do quarto: ");
        int quarto = input.nextInt();
        if (quarto < 1 || quarto > 3) {
            System.out.println("Tipo de quarto inválido.");
            return quantidadeReservas;
        }

        System.out.print("Quantidade de noites: ");
        int noites = input.nextInt();
        if (noites <= 0) {
            System.out.println("Quantidade de noites inválida.");
            return quantidadeReservas;
        }

        codigoReservas[quantidadeReservas] = codigo;
        nomeHospedes[quantidadeReservas] = hospede;

        if (quarto == 1) {
            tipoQuartos[quantidadeReservas] = "Standard";
            valorTotalReserva[quantidadeReservas] = noites * 180;
        } else if (quarto == 2) {
            tipoQuartos[quantidadeReservas] = "Luxo";
            valorTotalReserva[quantidadeReservas] = noites * 300;
        } else {
            tipoQuartos[quantidadeReservas] = "Suíte";
            valorTotalReserva[quantidadeReservas] = noites * 500;
        }

        quantidadeNoites[quantidadeReservas] = noites;
        situacaoReserva[quantidadeReservas] = "Ativa";

        System.out.println("Reserva realizada com sucesso.");

        return quantidadeReservas+1;
    }

    static void listarReservasAtivas(int quantidadeReservas,String[]situacaoReserva,int[] codigoReservas,String[] nomeHospedes, String[] tipoQuartos,int[] quantidadeNoites,double[] valorTotalReserva) {
        boolean reservaAtiva = false;
        for (int i = 0; i < quantidadeReservas; i++) {
            if (situacaoReserva[i].equals("Ativa")) {
                reservaAtiva = true;
                System.out.printf("%d - %s - %s - %d noites - R$ %.2f%n",codigoReservas[i],nomeHospedes[i],tipoQuartos[i],quantidadeNoites[i],valorTotalReserva[i]);
            }
        }
        if (!reservaAtiva) {
            System.out.println("Nenhuma reserva ativa.");
        }
    }

    static void finalizarEstadia(Scanner input,int quantidadeReservas, int[]codigoReservas,String[]situacaoReserva) {
        System.out.print("Código da reserva: ");
        int codigo = input.nextInt();
        boolean reservaEncontrada = false;
        for (int i = 0; i < quantidadeReservas; i++) {
            if (codigo == codigoReservas[i]) {
                reservaEncontrada = true;
                if (situacaoReserva[i].equals("Cancelada")) {
                    System.out.println("Reserva cancelada.");
                }
                if (situacaoReserva[i].equals("Finalizada")) {
                    System.out.println("Estadia já finalizada.");
                }
                if (situacaoReserva[i].equals("Ativa")) {
                    System.out.println("Estadia finalizada com sucesso.");
                    situacaoReserva[i] = "Finalizada";

                }
            }
        }
        if (!reservaEncontrada) {
            System.out.println("Reserva não encontrada.");
        }
    }

    static void cancelarReserva(Scanner input, int[]codigoReservas,int quantidadeReservas,String[]situacaoReserva) {
        System.out.print("Código da reserva: ");
        int codigo = input.nextInt();
        boolean codigoEncontrado = false;
        for (int i = 0; i < quantidadeReservas; i++) {
            if (codigo == codigoReservas[i]) {
                codigoEncontrado = true;
                if (situacaoReserva[i].equals("Cancelada")) {
                    System.out.println("Reserva já está cancelada.");
                }
                if (situacaoReserva[i].equals("Finalizada")) {
                    System.out.println("Não é possível cancelar uma estadia finalizada.");
                }
                if (situacaoReserva[i].equals("Ativa")) {
                    System.out.println("Reserva cancelada com sucesso.");
                    situacaoReserva[i] = "Cancelada";
                }
            }
        }
        if (!codigoEncontrado) {
            System.out.println("Reserva não encontrada.");
        }
    }

    static void consultarReserva(Scanner input,int quantidadeReservas,int[]codigoReservas,String[]nomeHospede,String[]tipoQuartos,int[]quantidadeNoites,double[] valorTotalReserva,String[] situacaoReserva) {
        System.out.print("Código da reserva: ");
        int codigo = input.nextInt();
        boolean codigoEncontrado = false;
        for (int i = 0; i < quantidadeReservas; i++) {
            if (codigo == codigoReservas[i]) {
                codigoEncontrado = true;
                System.out.printf("Código: %d%n" +
                        "Hóspede: %s%n" +
                        "Quarto: %s%n" +
                        "Noites: %d%n" +
                        "Valor: R$ %.2f%n" +
                        "Situação: %s%n",codigoReservas[i],nomeHospede[i],tipoQuartos[i],quantidadeNoites[i],valorTotalReserva[i],situacaoReserva[i]);
            }
        }
        if (!codigoEncontrado) {
            System.out.println("Reserva não encontrada.");
        }
    }

    static void exibirRelatorio(int quantidadeReservas,String[]situacaoReservas,double[]valorTotalReserva,int[]quantidadeNoites,String[]nomeHospedes) {
        int totalReservasCadastradas = 0;
        totalReservasCadastradas += quantidadeReservas;
        int reservasAtivas = 0;
        int reservasFinalizadas = 0;
        int reservasCanceladas = 0;
        int totalNoitesReservadas = 0;
        double faturamentoRealizado = 0;
        double maiorReserva = valorTotalReserva[0];
        int indiceMaiorReserva = 0;

        for (int i = 0;i < quantidadeReservas; i++) {
            if (situacaoReservas[i].equals("Ativa")) {
                reservasAtivas++;
            }
            if (situacaoReservas[i].equals("Cancelada")) {
                reservasCanceladas++;
            }
            if (situacaoReservas[i].equals("Finalizada")) {
                faturamentoRealizado += valorTotalReserva[i];
                reservasFinalizadas++;
            }

            totalNoitesReservadas += quantidadeNoites[i];

            if (maiorReserva < valorTotalReserva[i]) {
                maiorReserva = valorTotalReserva[i];
                indiceMaiorReserva = i;
            }
            }
        if (quantidadeReservas == 0) {
            System.out.println("Nenhuma reserva cadastrada.");
        } else {
            System.out.printf("Total de reservas cadastradas: %d%n" +
                    "Reservas ativas: %d%n" +
                    "Reservas finalizadas: %d%n" +
                    "Reservas canceladas: %d%n" +
                    "Quantidade total de noites reservadas: %d%n" +
                    "Faturamento realizado: R$ %.2f%n" +
                    "Maior reserva: R$ %.2f%n" +
                    "Hóspede responsável: %s%n",totalReservasCadastradas,reservasAtivas,reservasFinalizadas,reservasCanceladas,totalNoitesReservadas,faturamentoRealizado,valorTotalReserva[indiceMaiorReserva],nomeHospedes[indiceMaiorReserva]);
        }
    }

    public static void main(String[]args) {
        Scanner input  = new Scanner(System.in);

        int[] codigoReservas = new int[6];
        String[] nomeHospedes = new String[codigoReservas.length];
        String[] tipoQuartos = new String[codigoReservas.length];
        int[] quantidadeNoites = new int[codigoReservas.length];
        double[] valorTotalReserva = new double[codigoReservas.length];
        String[] situacaoReserva = new String[codigoReservas.length];

        int quantidadeReservas = 0;

        int opc;
        do {
            exibirMenu();
            System.out.print("Digite a opção que deseja: ");
            opc = input.nextInt();
            switch (opc) {
                case 1:
                    quantidadeReservas = fazerReserva(quantidadeReservas,input,codigoReservas,nomeHospedes,tipoQuartos,quantidadeNoites,situacaoReserva,valorTotalReserva);
                    break;
                case 2:
                    listarReservasAtivas(quantidadeReservas,situacaoReserva,codigoReservas,nomeHospedes,tipoQuartos,quantidadeNoites,valorTotalReserva);
                    break;
                case 3:
                    finalizarEstadia(input,quantidadeReservas,codigoReservas,situacaoReserva);
                    break;
                case 4:
                    cancelarReserva(input,codigoReservas,quantidadeReservas,situacaoReserva);
                    break;
                case 5:
                    consultarReserva(input,quantidadeReservas,codigoReservas,nomeHospedes,tipoQuartos,quantidadeNoites,valorTotalReserva,situacaoReserva);
                    break;
                case 6:
                    exibirRelatorio(quantidadeReservas,situacaoReserva,valorTotalReserva,quantidadeNoites,nomeHospedes);
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
