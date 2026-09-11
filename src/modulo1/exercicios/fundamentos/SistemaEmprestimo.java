package modulo1.exercicios.fundamentos;

public class SistemaEmprestimo {
    public static void main(String[]args) {
        int idade = 20;
        int salario = 2500;
        boolean nomeNegativado = false;

        if (idade >= 18 && salario >= 2000 && !nomeNegativado) {
            System.out.println("Empréstimo aprovado!");
        }
        else {
            System.out.println("Empréstimo Negado!");
        }
    }
}
