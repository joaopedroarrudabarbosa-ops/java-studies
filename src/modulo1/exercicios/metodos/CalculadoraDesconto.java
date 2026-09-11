package modulo1.exercicios.metodos;

public class CalculadoraDesconto {

    static double calcularDesconto(double preco, double porcentagem) {
        return preco - (preco * porcentagem / 100);
    }

    public static void main(String[]args) {
        double precoFinal = calcularDesconto(200,10);
        System.out.println("Preco final será de: R$"+precoFinal);
    }
}
