package modulo1.consolidacao;

import java.util.Scanner;

public class SistemaDeBiblioteca {

    static void exibirMenu() {
        System.out.println("\n===== BIBLIOTECA =====\n" +
                "\n" +
                "1 - Listar livros\n" +
                "2 - Emprestar livro\n" +
                "3 - Devolver livro\n" +
                "4 - Consultar livro\n" +
                "5 - Exibir relatório\n" +
                "0 - Sair");
    }

    static void listarLivros(String[] livros, boolean[] livrosDisponiveis, int[] codigoLivros) {
        System.out.println("\nLIVROS LISTADOS: ");
        for (int i = 0; i < livros.length; i++) {
            String[] disponibilidade = new String[livros.length];
            if (livrosDisponiveis[i]) {
                disponibilidade[i] = "Disponível";
            } else {
                disponibilidade[i] = "Emprestado";
            }
            System.out.printf("%d - %s - %s%n", codigoLivros[i], livros[i], disponibilidade[i]);
        }
    }

    static void emprestarLivro(Scanner input, int[] codigoLivros, boolean[] livrosDisponiveis, int[] quantidadeEmprestados) {
        System.out.print("\nEMPRESTAR LIVRO\nDigite o código do livro que deseja emprestar: ");
        int codigoLivro = input.nextInt();
        boolean livroEncontrado = false;
        for (int i = 0; i < codigoLivros.length; i++) {
            if (codigoLivro == codigoLivros[i]) {
                livroEncontrado = true;
                if (livrosDisponiveis[i]) {
                    System.out.println("Empréstimo realizado com sucesso.");
                    quantidadeEmprestados[i]++;
                    livrosDisponiveis[i] = false;
                } else {
                    System.out.println("Livro indisponível.");
                    break;
                }
            }
        }
        if (!livroEncontrado) {
            System.out.println("Livro inválido.");
        }
    }

    static void devolverLivro(Scanner input, int[] codigoLivros, boolean[] livrosDisponiveis) {
        System.out.print("\nDEVOLVER LIVRO\nDigite o código do livro que deseja devolver: ");
        int codigoLivro = input.nextInt();
        boolean livroEncontrado = false;
        for (int i = 0; i < codigoLivros.length; i++) {
            if (codigoLivro == codigoLivros[i]) {
                livroEncontrado = true;
                if (livrosDisponiveis[i]) {
                    System.out.println("Esse livro não está emprestado.");
                } else {
                    System.out.println("Devolução realizada com sucesso.");
                    livrosDisponiveis[i] = true;
                }
            }
        }
        if (!livroEncontrado) {
            System.out.println("Livro inválido.");
        }
    }

    static void consultarLivro(Scanner input, int[] codigoLivros, String[] livros, boolean[] livrosDisponiveis, int[] quantidadeEmprestado) {
        System.out.print("\nCONSULTAR LIVRO\nDigite o código do livro que deseja consultar: ");
        int codigoLivro = input.nextInt();
        boolean livroEncontrado = false;
        for (int i = 0; i < codigoLivros.length; i++) {
            String[] disponibilidade = new String[livros.length];
            if (livrosDisponiveis[i]) {
                disponibilidade[i] = "Disponível";
            } else {
                disponibilidade[i] = "Emprestado";
            }
            if (codigoLivro == codigoLivros[i]) {
                livroEncontrado = true;
                System.out.printf("Livro: %s%n" +
                        "Situação: %s%n" +
                        "Total de empréstimo: %d%n", livros[i], disponibilidade[i], quantidadeEmprestado[i]);
            }
        }
        if (!livroEncontrado) {
            System.out.println("Livro inválido.");
        }
    }

    static void exibirRelatorio(boolean[] livrosDisponiveis, int[] quantidadeEmprestados, String[] livros) {
        System.out.println("\nRELATÓRIO FINAL:");
        int quantidadeLivrosDisponiveis = 0;
        int quantidadeLivrosEmprestados = 0;
        int totalEmprestimosRealizados = 0;
        int livroMaisEmprestado = quantidadeEmprestados[0];
        int indiceLivroMaisEmprestado = 0;
        for (int i = 0; i < livrosDisponiveis.length; i++) {
            totalEmprestimosRealizados += quantidadeEmprestados[i];
            if (livrosDisponiveis[i]) {
                    quantidadeLivrosDisponiveis++;
            } else {
                    quantidadeLivrosEmprestados++;
            }
            if (livroMaisEmprestado < quantidadeEmprestados[i]) {
                    livroMaisEmprestado = quantidadeEmprestados[i];
                    indiceLivroMaisEmprestado = i;
            }
        }
        if (totalEmprestimosRealizados <= 0) {
            System.out.println("Nenhum empréstimo realizado.");
        } else {
            System.out.printf("Livros disponíveis: %d%n" + "Livros emprestado: %d%n" + "Total de empréstimo realizados: %d%n" + "Livro mais emprestado: %s%n" + "Quantidade de empréstimos: %d%n", quantidadeLivrosDisponiveis, quantidadeLivrosEmprestados, totalEmprestimosRealizados, livros[indiceLivroMaisEmprestado], quantidadeEmprestados[indiceLivroMaisEmprestado]);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[] livros = {"1984", "O Hobbit", "Dom Casmurro", "Clean Code", "O Pequeno Príncipe"};
        boolean[] livrosDisponiveis = {true, true, true, true, true};
        int[] quantidadeEmprestados = new int[livros.length];
        int[] codigoLivros = {1, 2, 3, 4, 5};

        int opc;
        do {
            exibirMenu();
            System.out.print("Digite a opção que deseja: ");
            opc = input.nextInt();
            switch (opc) {
                case 1:
                    listarLivros(livros, livrosDisponiveis, codigoLivros);
                    break;
                case 2:
                    emprestarLivro(input, codigoLivros, livrosDisponiveis, quantidadeEmprestados);
                    break;
                case 3:
                    devolverLivro(input, codigoLivros, livrosDisponiveis);
                    break;
                case 4:
                    consultarLivro(input, codigoLivros, livros, livrosDisponiveis, quantidadeEmprestados);
                    break;
                case 5:
                    exibirRelatorio(livrosDisponiveis, quantidadeEmprestados, livros);
                    break;
                case 0:
                    System.out.println("Sistema encerrado.");
                    break;
                default:
                    System.out.println("Opcão inválida.");
                    break;
            }
        } while (opc != 0);
        input.close();
    }
}
