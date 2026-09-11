package modulo1.metodos;

public class MetodosCompostos {

    static int somar(int a, int b) {
        return a + b;
    }

    static void mostrarResultado(int a, int b) {
        int resultado = somar(a,b);
        System.out.println(resultado);
    }

    static void mostrarDados(String nome) {
        System.out.println("Nome: "+nome);
    }

    static void mostrarDados(String nome, int idade) {
        System.out.println("Nome: " + nome + " Idade: "+idade);
    }

    static void mostrarDados(String nome, int idade,double altura) {
        System.out.println("Nome: " + nome + " Idade: "+idade + " Altura: " + altura);
    }


    public static void main(String[]args) {
    mostrarResultado(5,10);
    mostrarResultado(50,100);
    mostrarResultado(2,4);

    mostrarDados("Joao");
    mostrarDados("Fernando ",20);
    mostrarDados("Ana ",50,1.54);

    }
}
