package modulo1.exercicios.metodos;

public class SistemaAlunos {

    static double calcularMedia(double a,double b) {
        return (a+b) / 2;
    }

    static boolean verificarAprovacao(double media) {
        return media >= 6;
        }

    static void mostrarSituacao(String nome, boolean aprovado) {
        if (aprovado) {
            System.out.println(nome + " foi aprovado.");
        }
        else {
            System.out.println(nome + " foi reprovado.");
        }
    }

    public static void main(String[]args) {

    double media = calcularMedia(5,5);
    System.out.println(media);

    boolean aprovado = verificarAprovacao(media);
    System.out.println(aprovado);

    mostrarSituacao("Joao", aprovado);
    }
}
