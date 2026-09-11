package modulo1.exercicios.metodos;

public class CalculadoraMetodos {

    static int somar(int a, int b) {
        int resultado = a + b;
        return resultado;
    }

    static int subtrair(int a, int b) {
        int resultado = a - b;
        return resultado;
    }

    static int multiplicar(int a, int b)  {
        int resultado = a * b;
        return resultado;
    }

    static double dividir(double a, double b) {
        double resultado = a / b;
        return resultado;
    }

    public static void main(String[]args) {
    System.out.println(somar(10,5));
    System.out.println(subtrair(10,5));
    System.out.println(multiplicar(10,5));
    System.out.println(dividir(10,5));
    }
}
