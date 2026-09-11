package modulo1.fundamentos;

public class OperadoresAritmeticos {
    public static void main(String[]args) {
        int numero1 = 20;
        int numero2 = 6;
        int soma = numero1 + numero2;
        System.out.println(soma);


        int subtracao = numero1 - numero2;
        System.out.println(subtracao);

        int multiplicacao = numero1 * numero2;
        System.out.println(multiplicacao);

        double divisao = (double) numero1 / numero2; // casting
        System.out.println(divisao);
    }
}
