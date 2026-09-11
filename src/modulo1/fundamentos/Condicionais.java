package modulo1.fundamentos;

public class Condicionais {
    public static void main(String[]args) {
        double nota1 = 7.5;
        if (nota1 >= 6) {
            System.out.println("Aprovado!");
        }
        else if (nota1 >= 4) {
            System.out.println("Recuperação!");
        }
        else {
            System.out.println("Reprovado!");
        }

        double nota2 = 8.0;
        int frequencia = 60;

        if (nota2 >= 6 && frequencia >= 75) {
            System.out.println("Aprovado!");
        }
        else {
            System.out.println("Reprovado!");
        }

        boolean estudante = false;
        int idade = 65;

        if (estudante || idade > 60) {
            System.out.println("Tem direito a desconto!");
        }
        else {
            System.out.println("Não tem direito a desconto!");
        }
    }
}
