package modulo1.repeticoes.revisao;
import java.util.Scanner;

public class For {
    public static void main(String[]args) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 1; i<=10; i++) {
            System.out.println(i);
        }

        for (int i = 10; i >= 0;i--) {
            System.out.println(i);

        }

        for (int i = 2; i <=20; i+=2) {
            System.out.println(i);
        }
        int acrescentar = 0;
        for (int i = 1; i <= 5; i++) {
            acrescentar += i;
        }
        System.out.println(acrescentar);


        int soma = 0;
        for (int i = 2; i<=10; i+=2) {
            soma += i;
        }
        System.out.println(soma);

        int acumulador = 0;
        for(int i = 1; i <=20; i++) {
            if (i % 3 == 0) {
                acumulador += i;
            }
        }
        System.out.println(acumulador);

        int quantidade = 0;
        for (int i = 1; i <= 30; i++) {
            if (i % 4 == 0) {
                quantidade += 1;
            }
        }
        System.out.println(quantidade);

        int acumulador1 = 0;
        int quantidade1 = 0;
        for (int i = 1; i <= 50; i++) {
            if (i % 5 == 0) {
                acumulador1 += i;
                quantidade1 += 1;
            }
        }
        System.out.println(acumulador1);
        System.out.println(quantidade1);

        System.out.print("Digite 1 numero e verifique o maior entre eles:");
        int maior = scanner.nextInt();;
        int guardar = maior;
        for (int i = 2; i<= 5; i++) {
            System.out.print("Digite "+i +" numero e verifique o maior entre eles: ");
            maior = scanner.nextInt();
            if (guardar < maior) {
                guardar = maior;
            }
        }
        System.out.println(guardar);

        for (int i = 1; i <=20; i++) {
            if ( i == 14) {
                break;
            }
            if ( i % 3 == 0) {
                continue;
            }
            System.out.println(i);
        }

    }

}

