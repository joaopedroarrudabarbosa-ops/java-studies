package modulo1.repeticoes;

public class ForEach {
    public static void main(String[]args) {
        int[] numeros = {10, 20, 30, 40};
        for (int numero : numeros) {
            System.out.println(numero);
        }

        double[] precos = {10, 20, 30};
        double total = 0;
        for (double preco : precos) {
            total += preco;
        }
        System.out.println(total);

        for (double preco : precos) {
            if (preco >= 20) {
                System.out.println(preco);
            }
        }

        int[] numeros1 = {8, 3, 12, 5};
        int maior = numeros1[0];

        for (int numero : numeros1) {
            if (numero > maior) {
                maior = numero;
            }
        }
        System.out.println(maior);
    }
}
