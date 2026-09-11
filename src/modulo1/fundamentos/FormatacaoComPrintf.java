package modulo1.fundamentos;

public class FormatacaoComPrintf {
    public static void main(String[]args) {

        String produto1 = "Mouse";
        double preco1 = 99.0;
        System.out.println("Produto: " + produto1 + " - Preço: " + preco1);
        System.out.printf("Produto: %s - Preço: %.2f%n", produto1, preco1);
        // %s - RECEBE STRING
        // %.2f  - RECEBE UM NUMERO DECIMAL E MOSTRA 2 CASAS
        // %n - PULA PARA A PROXIMA LINHA

        String produto = "Mouse";
        String marca = "Logitech";
        int quantidade = 5;
        int estoque = 20;
        double preco = 99.90;
        double desconto = 10.00;
        System.out.printf("Produto: %s - Marca: %s - Quantidade: %d - Estoque: %d - Preço: %.2f - Desconto: %.2f%n",produto,marca,quantidade,estoque,preco,desconto);

    }
}
