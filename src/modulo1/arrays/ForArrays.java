package modulo1.arrays;

public class ForArrays {
    public static void main(String[]args) {
        int[] idades = {18, 21, 16, 30, 17};
        for (int i = 0; i < idades.length; i++) {
            System.out.println("Indice " + i + ": " + idades[i]);
        }

        int quantidadeMaiores = 0;
        int quantidadeMenores = 0;
        int[] idades1 = {18, 21, 16, 30, 17, 15, 42, 19};
        for (int i = 0; i < idades1.length; i++) {
            if (idades1[i] >= 18) {
                quantidadeMaiores += 1;
            }
            else {
                quantidadeMenores+= 1;
            }
        }
        System.out.println("Maior idade: " + quantidadeMaiores);
        System.out.println("Menor idade: " + quantidadeMenores);

        double soma = 0;
        double[] notas = {7.5, 8.0, 6.0, 9.5, 5.0};
        for (int i = 0; i < notas.length; i++) {
            soma += notas[i];
        }
        double media = soma / notas.length;
        System.out.println(soma);
        System.out.println(media);


        int[] numeros = {12, 5, 27, 8, 41, 3, 19};
        int maior = numeros[0];
        int menor = numeros[0];
        for (int i = 1; i < numeros.length; i++) {
            if (numeros[i] > maior) {
                maior = numeros[i];
            }
            if (numeros[i] < menor) {
                menor = numeros[i];
            }
        }
        System.out.println(maior);
        System.out.println(menor);
    }
}
