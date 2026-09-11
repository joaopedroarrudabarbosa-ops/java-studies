package modulo1.repeticoes.revisao;
import java.util.Scanner;

public class While {
    public static void main(String[]args) {
        Scanner scanner = new Scanner(System.in);

        int contador = 0;
        while (contador <= 5 ) {
            System.out.println(contador);
            contador++;
        }

        int cont = 10;
        while (cont >= 0) {
            System.out.println(cont);
            cont--;
        }

        int par = 2;
        while (par <= 20) {
            System.out.println(par);
            par += 2;
        }

        int acumulador = 0;
        int cont1 = 10;
        while (cont1>=1) {
            acumulador += cont1;
            cont1--;
        }
        System.out.println(acumulador);

        int quantidade = 0;
        int parametro = 1;
        while (parametro <= 30) {
            if (parametro % 4 == 0) {
                quantidade++;
            }
            parametro++;
        }
        System.out.println(quantidade);

        int soma = 0;
        int numero = -1;
        while (numero != 0) {
            System.out.print("Digite um número: ");
            numero = scanner.nextInt();
            soma += numero;
        }
        System.out.println(soma);

        int soma1 = 0;
        int numeroNegativo = 0;
        int numeroPositivo = 0;
        int numero1 = -1;
        while (numero1 != 0) {
            System.out.print("Digite um número: ");
            numero1 = scanner.nextInt();
            if (numero1 < 0) {
                numeroNegativo++;
            }
            else if (numero1 > 0 ) {
                numeroPositivo++;
            }
            soma1 += numero1;
        }
        System.out.println("Soma: "+soma1+"\nQuantidade positivo: "+numeroPositivo+"\nQuantidade negativo: "+numeroNegativo);

        System.out.print("Digite um número: ");
        int numero2 = scanner.nextInt();
        int maiorNumero = numero2;
        while (numero2 != 0) {
            System.out.print("Digite um número: ");
            numero2 = scanner.nextInt();
            if (numero2 > maiorNumero) {
                maiorNumero = numero2;
            }
        }
        System.out.println("Maior numero: "+maiorNumero);

        System.out.print("Digite uma idade: ");
        int idade = scanner.nextInt();
        while (idade < 0 || idade > 120) {
            System.out.print("Digite uma idade válida: ");
            idade = scanner.nextInt();
        }
        System.out.print("Idade válida: "+idade);

    }
}
