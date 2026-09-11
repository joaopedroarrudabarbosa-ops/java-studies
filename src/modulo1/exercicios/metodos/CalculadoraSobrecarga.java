package modulo1.exercicios.metodos;

public class CalculadoraSobrecarga {

    static int calcularArea(int lado) {
        return lado * lado;
    }

    static double calcularArea(double base,double altura) {
        return base * altura;
    }

    static double calcularArea(double raio) {
        return 3.14 * raio * raio;
    }

    public static void main(String[]args) {
        int quadrado = calcularArea(5);
        System.out.println(quadrado);

        double retangulo = calcularArea(10.0,5.0);
        System.out.println(retangulo);

        double circulo = calcularArea(3.0);
        System.out.println(circulo);
    }
}
