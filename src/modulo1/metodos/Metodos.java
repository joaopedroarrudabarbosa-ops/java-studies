// parametro = o que o metodo pede
// argumento = o que você entrega ao chamar

package modulo1.metodos;

public class Metodos {
    static void mostrarMensagem() { // parametros
        System.out.println("Bem-vindo ao sistema!");
    }
    static void mostrarNome(String nome) { // parametros
        System.out.println("Olá " + nome + "!");
    }
    static void mostrarIdade(int idade) { // parametros
        System.out.println("Você tem " + idade + " anos.");
    }
    static void mostrarDados(String nome, int idade) { // parametros
        System.out.println("Olá " + nome + "! Você tem " + idade + " anos.");
    }
    static int multiplicar(int numero1, int numero2) {
        return numero1 * numero2;
    }
    static boolean verificarMaiorIdade(int idade) {
        return idade >= 18;
    }

    public static void main(String[]args){
        mostrarMensagem(); // sem argumentos
        mostrarNome("Joao"); // argumentos
        mostrarNome("Jose"); // argumentos
        mostrarIdade(19); // argumentos
        mostrarIdade(62); // argumentos
        mostrarDados("Joao", 19); // argumentos
        int resultado = multiplicar(2,2);
        System.out.println(resultado);
        boolean maiorDeIdade = verificarMaiorIdade(19);
        System.out.println(maiorDeIdade);

        int numero = 10;
        if (numero > 5) {
            String mensagem = "Numero maior que 5";
            System.out.println(mensagem);
        }
        // System.out.println(mensagem); escopo - erro
        }
    }
