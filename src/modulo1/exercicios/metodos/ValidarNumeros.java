package modulo1.exercicios.metodos;

public class ValidarNumeros {

    static void verificarNumero(int a) {
        if(a < 0) {
            System.out.println("Número inválido.");
            return;
        }
        System.out.println("Número válido: " +a);
    }

    public static void main(String[]args) {
        verificarNumero(0);
    }
}
