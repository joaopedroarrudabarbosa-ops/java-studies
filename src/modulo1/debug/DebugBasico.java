package modulo1.debug;

public class DebugBasico {

    static int somar(int a, int b) {
        int resultado = a + b;
        return resultado;
    }

    public static void main(String[]args) {

        int a = 10;          // breakpoint 1
        int b = 20;
        int soma = a + b;
        System.out.println(soma); // breakpoint 2

    }
}
