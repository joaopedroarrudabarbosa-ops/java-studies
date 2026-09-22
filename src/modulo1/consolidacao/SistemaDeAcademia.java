package modulo1.consolidacao;
import java.util.Scanner;

public class SistemaDeAcademia {

    static void exibirMenu() {
        System.out.println("===== ACADEMIA =====\n" +
                            "\n" +
                            "1 - Cadastrar aluno\n" +
                            "2 - Listar alunos ativos\n" +
                            "3 - Registrar treino\n" +
                            "4 - Cancelar matrícula\n" +
                            "5 - Consultar aluno\n" +
                            "6 - Exibir relatório\n" +
                            "0 - Sair");
    }
    static void exibirPlanos() {
        System.out.println("1 - Basic   - R$ 89,90\n" +
                "2 - Plus    - R$ 129,90\n" +
                "3 - Premium - R$ 179,90");
    }

    static int cadastrarAluno(Scanner input,int[]codigoAlunos,String[]nomeAlunos,String[]planoAlunos,boolean[]situacaoMatricula,int quantidadeAlunos) {
        if (quantidadeAlunos == codigoAlunos.length) {
            System.out.println("Limite de alunos atingido.");
            return quantidadeAlunos;
        }

        System.out.print("Digite o código do aluno: ");
        int codigoAluno = input.nextInt();
        for (int i = 0; i < quantidadeAlunos; i++) {
            if (codigoAluno == codigoAlunos[i]) {
                System.out.println("Código já cadastrado.");
                return quantidadeAlunos;
            }
        }

        input.nextLine();
        System.out.print("Digite o nome: ");
        String nomeAluno = input.nextLine();
        exibirPlanos();
        System.out.print("Digite o plano: ");
        int planoAluno = input.nextInt();
        if (planoAluno < 1 || planoAluno > 3) {
            System.out.println("Plano inválido.");
            return quantidadeAlunos;
        }

        codigoAlunos[quantidadeAlunos] = codigoAluno;
        nomeAlunos[quantidadeAlunos] = nomeAluno;
        situacaoMatricula[quantidadeAlunos] = true;

        if (planoAluno == 1) {
            planoAlunos[quantidadeAlunos] = "Basic";
        } else if (planoAluno == 2) {
            planoAlunos[quantidadeAlunos] = "Plus";
        } else {
            planoAlunos[quantidadeAlunos] = "Premium";
        }

        System.out.println("Aluno cadastrado com sucesso.");
        return quantidadeAlunos+1;
    }


    static void exibirAlunosAtivos(int quantidadeAlunos,boolean[] situacaoMatricula, int[]codigoAlunos,String[]nomeAlunos,String[]planoAlunos,int[]quantidadeTreinosRealizados) {
        boolean alunoAtivo = false;
        for (int i = 0;i<quantidadeAlunos;i++) {
            if (situacaoMatricula[i]) {
                alunoAtivo = true;
                System.out.printf("%d - %s - %s - Treinos: %d%n",codigoAlunos[i],nomeAlunos[i],planoAlunos[i],quantidadeTreinosRealizados[i]);
            }
        }
        if (!alunoAtivo) {
            System.out.println("Nenhum aluno ativo.");
        }
    }

    static void registrarTreino(int quantidadeAlunos,Scanner input,int[]codigoAlunos,boolean[]situacaoMatricula,int[]quantidadeTreinosRealizados) {
        boolean alunoRegistrado = false;
        boolean matriculaInativa = false;
        System.out.print("Digite o seu código: ");
        int codigoAluno = input.nextInt();
        for (int i = 0;i<quantidadeAlunos;i++) {
            if (codigoAluno == codigoAlunos[i]) {
                alunoRegistrado = true;
                if (!situacaoMatricula[i]) {
                    matriculaInativa = true;
                } else {
                    System.out.println("Treino registrado com sucesso.");
                    quantidadeTreinosRealizados[i]++;
                }
            }
        }
        if (!alunoRegistrado) {
            System.out.println("Aluno não encontrado.");
        }
        if (matriculaInativa) {
            System.out.println("Matrícula inativa.");
        }
    }

    static void cancelarMatricula(int quantidadeAlunos,Scanner input,int[]codigoAlunos,boolean[]situacaoMatricula) {
        boolean alunoEncontrado = false;
        boolean matriculaInativa = false;
        System.out.print("Digite o seu código: ");
        int codigoAluno = input.nextInt();
        for (int i = 0;i<quantidadeAlunos;i++) {
            if (codigoAluno == codigoAlunos[i]) {
                alunoEncontrado = true;
                if (!situacaoMatricula[i]) {
                    matriculaInativa = true;
                } else {
                    System.out.println("Matrícula cancelada com sucesso.");
                    situacaoMatricula[i] = false;
                }
            }
        }
        if (!alunoEncontrado) {
            System.out.println("Aluno não encontrado.");
        }
        if (matriculaInativa) {
            System.out.println("Matrícula já está inativa.");
        }
    }

    static void consultarAluno(int quantidadeAlunos,Scanner input,int[]codigoAlunos,boolean[]situacaoMatricula,String[]nomeAlunos,String[]planoAlunos,int[]quantidadeTreinosRealizados) {
        boolean codigoEncontrado = false;
        String matricula;
        System.out.print("Digite o código do aluno que deseja consultar: ");
        int codigoAluno = input.nextInt();
        for (int i = 0;i<quantidadeAlunos;i++) {
            if (codigoAluno == codigoAlunos[i]) {
                codigoEncontrado = true;
                if (situacaoMatricula[i]) {
                    matricula = "Ativa";
                } else {
                    matricula = "Inativa";
                }
                System.out.printf("Código: %d%n" +
                        "Nome: %s%n" +
                        "Plano: %s%n" +
                        "Situação: %s%n" +
                        "Treinos realizados: %d%n",codigoAlunos[i],nomeAlunos[i],planoAlunos[i],matricula,quantidadeTreinosRealizados[i]);
            }
        }
        if (!codigoEncontrado) {
            System.out.println("Aluno não encontrado.");
        }
    }

    static void exibirRelatorio(int quantidadeAlunos, int[] quantidadeTreinosRealizados, boolean[] situacaoMatricula, String[] planoAlunos, String[] nomeAlunos) {
        int quantidadeAlunosAtivos = 0;
        int quantidadeAlunosInativos = 0;
        int totalTreinosRealizados = 0;
        int maisTreinosRealizados = quantidadeTreinosRealizados[0];
        int indiceMaisTreino = 0;
        double receitaMensal = 0;
        for (int i = 0; i < quantidadeAlunos; i++) {
            if (situacaoMatricula[i]) {
                quantidadeAlunosAtivos++;
                if (planoAlunos[i].equals("Basic")) {
                    receitaMensal += 89.90;
                } else if (planoAlunos[i].equals("Plus")) {
                    receitaMensal += 129.90;
                } else if (planoAlunos[i].equals("Premium")) {
                    receitaMensal += 179.90;
                }
            } else {
                quantidadeAlunosInativos++;
            }
            totalTreinosRealizados += quantidadeTreinosRealizados[i];
            if (maisTreinosRealizados < quantidadeTreinosRealizados[i]) {
                maisTreinosRealizados = quantidadeTreinosRealizados[i];
                indiceMaisTreino = i;
            }
        }
        if (totalTreinosRealizados == 0) {
            System.out.printf("Nenhum treino realizado." +
                    "%nTotal de alunos cadastrados: %d%n" +
                    "Alunos ativos: %d%n" +
                    "Alunos inativos: %d%n" +
                    "Total de treinos realizados: %d%n" +
                    "Receita mensal atual: R$ %.2f%n", quantidadeAlunos, quantidadeAlunosAtivos, quantidadeAlunosInativos,totalTreinosRealizados,receitaMensal);
        } else {
            System.out.printf("Total de alunos cadastrados: %d%n" +
                    "Alunos ativos: %d%n" +
                    "Alunos inativos: %d%n" +
                    "Total de treinos realizados: %d%n" +
                    "Aluno com mais treinos: %s%n" +
                    "Quantidade de treinos: %d%n" +
                    "Receita mensal atual: R$ %.2f%n", quantidadeAlunos, quantidadeAlunosAtivos, quantidadeAlunosInativos, totalTreinosRealizados, nomeAlunos[indiceMaisTreino], quantidadeTreinosRealizados[indiceMaisTreino], receitaMensal);
        }
    }

    public static void main(String[]args) {
        Scanner input = new Scanner(System.in);

        int[] codigoAlunos = new int[5];
        String[] nomeAlunos = new String[codigoAlunos.length];
        String[] planoAlunos = new String[codigoAlunos.length];
        boolean[] situacaoMatricula = new boolean[codigoAlunos.length];
        int[] quantidadeTreinosRealizados = new int[codigoAlunos.length];

        int quantidadeAlunos = 0;

        int opc;
        do {
            exibirMenu();
            System.out.print("Digite a opção que deseja: ");
            opc = input.nextInt();
            switch (opc) {
                case 1:
                    quantidadeAlunos = cadastrarAluno(input,codigoAlunos,nomeAlunos,planoAlunos,situacaoMatricula,quantidadeAlunos);
                    break;
                case 2:
                    exibirAlunosAtivos(quantidadeAlunos,situacaoMatricula,codigoAlunos,nomeAlunos,planoAlunos,quantidadeTreinosRealizados);
                    break;
                case 3:
                    registrarTreino(quantidadeAlunos,input,codigoAlunos,situacaoMatricula,quantidadeTreinosRealizados);
                    break;
                case 4:
                    cancelarMatricula(quantidadeAlunos,input,codigoAlunos,situacaoMatricula);
                    break;
                case 5:
                    consultarAluno(quantidadeAlunos,input,codigoAlunos,situacaoMatricula,nomeAlunos,planoAlunos,quantidadeTreinosRealizados);
                    break;
                case 6:
                    exibirRelatorio(quantidadeAlunos,quantidadeTreinosRealizados,situacaoMatricula,planoAlunos,nomeAlunos);
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
