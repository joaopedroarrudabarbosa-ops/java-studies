package modulo1.exercicios.repeticoes;
import java.util.Scanner;

public class ControleDeEstoque {

    static void exibirMenu() {
        System.out.print("----- CONTROLE DE ESTOQUE -----" +
                            "\n1 - Consultar estoque" +
                            "\n2 - Adicionar unidades" +
                            "\n3 - Retirar unidades" +
                            "\n4 - Exibir relatório" +
                            "\n0 - Encerrar\n" +
                            "Escolha uma opção: ");
    }

    static int maiorUnidade(int maiorUnidade, int novoMaiorUnidade) {
        if (maiorUnidade > novoMaiorUnidade) {
            novoMaiorUnidade = maiorUnidade;
        }
        return novoMaiorUnidade;
    }

    static void exibirResumo(int totalUnidadeEstoque,int unidadesAdicionadasValidas, int totalUnidadesAdicionadaEstoque, int maiorUnidadeDepositada,int unidadesRetiradasValidas,int totalUnidadesRetiradas,int maiorUnidadeRetirada) {
        System.out.println("----- RELATÓRIO DO ESTOQUE -----" +
                                "\nEstoque atual: " +totalUnidadeEstoque+
                                "\nQuantidade de adições: " +unidadesAdicionadasValidas+
                                "\nTotal de unidades adicionadas: " +totalUnidadesAdicionadaEstoque+
                                "\nMaior adição: " +maiorUnidadeDepositada+
                                "\nQuantidade de retiradas: " +unidadesRetiradasValidas+
                                "\nTotal de unidades retiradas: " +totalUnidadesRetiradas+
                                "\nMaior retirada: "+maiorUnidadeRetirada);
    }

    public static void main(String[]args) {
        Scanner input = new Scanner(System.in);

        int totalUnidadeEstoque = 20;
        int opc;
        int unidadeEstoqueAdicionada;
        int totalUnidadesAdicionadaEstoque = 0;
        int unidadesAdicionadasValidas = 0;
        int maiorUnidadeDepositada = 0;
        int unidadesEstoqueRetiradas;
        int unidadesRetiradasValidas = 0;
        int totalUnidadesRetiradas = 0;
        int maiorUnidadeRetirada = 0;

        do {
            exibirMenu();
            opc = input.nextInt();
            if (opc == 0) {
                System.out.println("Controle de estoque encerrado.");
            } else if (opc == 1) {
                System.out.println(totalUnidadeEstoque);
            } else if (opc == 2) {
                System.out.print("Digite a quantidade de unidades que deseja adicionar do estoque: ");
                unidadeEstoqueAdicionada = input.nextInt();
                if (unidadeEstoqueAdicionada > 0) {
                    unidadesAdicionadasValidas++;
                    totalUnidadesAdicionadaEstoque += unidadeEstoqueAdicionada;
                    totalUnidadeEstoque += unidadeEstoqueAdicionada; // ESQUECI DE COLOCAR UNIDADES NOVA NO ESTOQUE ATUAL
                    maiorUnidadeDepositada = maiorUnidade(maiorUnidadeDepositada, unidadeEstoqueAdicionada);
                } else {
                    System.out.println("Valor adicionado ao estoque é inválido.");
                }
            } else if (opc == 3) {
                System.out.print("Digite a quantidade de unidades que deseja retirar do estoque: ");
                unidadesEstoqueRetiradas = input.nextInt();
                if (unidadesEstoqueRetiradas <=  0) { // O REQUISITO PEEDIA <= 0
                    System.out.println("Valor de retirada inválido.");
                } else if (unidadesEstoqueRetiradas > totalUnidadeEstoque) {
                    System.out.println("Valor de retirada maior que o estoque atual.");
                } else {
                    unidadesRetiradasValidas++;
                    totalUnidadesRetiradas += unidadesEstoqueRetiradas;
                    totalUnidadeEstoque -= unidadesEstoqueRetiradas;
//                    if (unidadesAdicionadasValidas == 1) {
//                        maiorUnidadeRetirada = unidadesEstoqueRetiradas;
//                    }
//                    maiorUnidadeRetirada = maiorUnidade(maiorUnidadeRetirada,unidadesEstoqueRetiradas);
                    maiorUnidadeRetirada = maiorUnidade(maiorUnidadeRetirada, unidadesEstoqueRetiradas);
                }
            } else if (opc == 4) {
                exibirResumo(totalUnidadeEstoque, unidadesAdicionadasValidas, totalUnidadesAdicionadaEstoque,maiorUnidadeDepositada, unidadesRetiradasValidas, totalUnidadesRetiradas, maiorUnidadeRetirada);
            } else {
                System.out.println("Valor digitado inválido.");
            }
        } while (opc != 0);
    }
}
