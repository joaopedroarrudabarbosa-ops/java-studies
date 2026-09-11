package modulo1.exercicios.metodos;

public class Metodos {
    static double calcularMetade(double numero) {
        return numero / 2;
    }
    static String criarSaudacao(String nome) {
        return "Olá " + nome;
    }
    static boolean ehPar(int numero) {
        return numero % 2 == 0;
    }
    public static void main(String[]args) {
    System.out.println(calcularMetade(5));
    String saudacao = criarSaudacao("Joao");
    System.out.println(saudacao);
    System.out.println(ehPar(7));
    }
}
