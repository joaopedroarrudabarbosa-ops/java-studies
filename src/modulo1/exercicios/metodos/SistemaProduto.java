package modulo1.exercicios.metodos;

public class SistemaProduto {

    static double calcularDesconto(double preco, double porcentagem) {
        return preco - (preco * porcentagem / 100);
    }

    static boolean verificarPromocao(double precoFinal) {
        return precoFinal < 100;
    }

    static void mostrarProduto(String nome, double precoFinal, boolean verificarPromocao) {
        if (verificarPromocao) {
            System.out.println("Produto: " + nome + " Preço final: " + precoFinal + " Produto dentro da promoção.");
            return;
        }
        System.out.println("Produto: " + nome+ " Preço final: "+ precoFinal+ " Produto fora da promoção.");
    }


    public static void main(String[]args) {

        double precoFinal = calcularDesconto(120,0);
        System.out.println(precoFinal);
        boolean emPromocao = verificarPromocao(precoFinal);
        System.out.println(emPromocao);
        mostrarProduto("Mouse Gamer", precoFinal, emPromocao);

    }
}
