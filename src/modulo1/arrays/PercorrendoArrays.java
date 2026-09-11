// FOR TRADICIONAL PERCORRE O ARRAY SALVANDO O INDICE
// FOR-EACH PERCCORE O ARRAY IMPRIMINDO APENAS O ARRAY, SEM SALVAR INDICE

package modulo1.arrays;

public class PercorrendoArrays {
    public static void main(String[]args) {

        int soma = 0;
        int[] numeros = {10, 20, 30, 40, 50};
        for (int i = 0; i < numeros.length; i++) { // ARRAY CRESCENTE
            System.out.println(numeros[i]);
            soma += numeros[i];
        }

        for (int i = numeros.length-1; i >= numeros.length; i--) { // ARRAY DECRESCENTE
            System.out.println(numeros[i]);
        }
        System.out.println("Soma: "+soma);

        int[] valores = {5, 8, 12, 20, 7};
        int soma1 = 0;
        for (int i = 0; i < valores.length; i++) {
            soma1 += valores[i];
        }
        System.out.println("Soma dos valores: "+soma1);

        int[] numeros1 = {7, 12, 3, 20, 15, 4};
        int quantidade = 0;
        for (int i = 0; i < numeros1.length; i++) {
            if (numeros1[i] > 10) {
                quantidade++;
            }
        }
        System.out.println("Quantidade de valores maiores que 10: "+quantidade);

        int[] numeros2 = {25, 8, 42, 13, 7, 31};
        int maior = numeros2[0];
        int menor = numeros2[0];

        for (int i = 1; i < numeros2.length; i++) {
            if(numeros2[i] > maior) {
                maior = numeros2[i];
            }
            if (menor > numeros2[i]) {
                menor = numeros2[i];
            }
        }
        System.out.println("Maior: "+maior);
        System.out.println("Menor: "+menor);

        String[] nomes = {"Ana", "Carlos", "Pedro", "Maria"};
        for (String nome : nomes) { // USADO PARA QUANDO PRECISAR SO IMPRIMIR A LISTA
            System.out.println(nome); // O NOME SERIA SO UMA VARIAVEL TEMPORARIA, RECEBENDO A CADA VOLTA UM ELEMENTO DO NOMES
        }

        int[] valores1 = {5, 10, 15, 20, 25};
        for (int i = 0; i < valores1.length; i++) {
            valores1[i] += 10;
            System.out.println(valores1[i]);
        }

        int[] numeros4 = {5, 12, 8, 20, 3, 15};
        for (int i = 0; i < numeros4.length; i++) {
            if (numeros4[i] > 10) {
                numeros4[i] *= 2;
            }
            System.out.println(numeros4[i]);
        }

        String[] produtos = {"Mouse", "Teclado", "Monitor", "Headset"};
        double[] precos = {80.0, 150.0, 900.0, 220.0};
        for (int i = 0; i < precos.length; i++) {
            System.out.println(produtos[i] + " custa " + precos[i]);
        }

        double acumulador = 0;
        String[] produtos1 = {"Mouse", "Teclado", "Monitor", "Headset"};
        double[] precos1 = {80.0, 150.0, 900.0, 220.0};
        for (int i = 0; i < precos1.length; i++)  {
            if (precos1[i] > 200) {
                System.out.println(produtos1[i]+" custa " + precos1[i]);
                acumulador += precos1[i];
            }
        }
        System.out.println("Total: "+acumulador);

        String[] produtos2 = {"Mouse", "Teclado", "Monitor", "Headset", "Webcam"};
        double[] precos2 = {90.0, 180.0, 850.0, 250.0, 120.0};
        double total = 0;
        for (int i = 0; i < precos2.length; i++) {
            if (precos2[i] <= 180) {
                System.out.println(produtos2[i]+ " custa "+ precos2[i]);
                total += precos2[i];
            }
        }
        System.out.println("Total: " + total);

        String[] nomes2 = {"Mouse", "Teclado", "Monitor", "Headset", "Webcam"};
        double[] valores2 = {90.0, 180.0, 850.0, 250.0, 120.0};
        double menor1 = valores2[0];
        int indiceMenor = 0;
        for (int i = 1; i < valores2.length; i++) {
            if (valores2[i] < menor1) {
                menor1 = valores2[i];
                indiceMenor = i;
            }
        }
        System.out.println("Produto mais barato: " + nomes2[indiceMenor]);
        System.out.println("Preço: " + menor1);

        String[] produtos3 = {"Mouse", "Teclado", "Monitor", "Headset", "Webcam"};
        double[] precos3 = {90.0, 180.0, 850.0, 250.0, 120.0};
        double total1 = precos3[0];
        double maiorPreco = precos3[0];
        double menorPreco = precos3[0];
        int indiceMaior = 0;
        int indiceMenor2 = 0;

        for (int i = 1; i < precos3.length; i++) {
            if (maiorPreco < precos3[i]) {
                maiorPreco = precos3[i];
                indiceMaior = i;
            }
            if (menorPreco > precos3[i]) {
                menorPreco = precos3[i];
                indiceMenor2 = i;
            }
            total1 += precos3[i];
        }
        System.out.println("Total: " +total1+
                "\nProduto mais caro: " +produtos3[indiceMaior]+
                "\nPreço mais alto: " +precos3[indiceMaior]+
                "\nProduto mais barato: " +produtos3[indiceMenor2]+
                "\nPreço mais baixo: "+precos3[indiceMenor2]);

        String[] alunos = {"Ana", "Carlos", "Pedro", "Maria", "João"};
        double[] notas = {8.5, 6.0, 9.2, 4.5, 7.0};
        double somaNota = 0;
        double maiorNota = notas[0];
        double menorNota = notas[0];
        int indiceMaior1 = 0;
        int indiceMenor1 = 0;
        int aprovados = 0;

        System.out.println("Aprovados: ");
        for (int i = 0; i < notas.length; i++ ) {
            somaNota += notas[i];
            if (maiorNota < notas[i]) {
                maiorNota = notas[i];
                indiceMaior1 = i;
            }
            if (menorNota > notas[i]) {
                menorNota = notas[i];
                indiceMenor1 = i;
            }
            if (notas[i] >= 7) {
                aprovados++;
                System.out.println(alunos[i]);
            }
        }
        double media = somaNota / notas.length;
        System.out.println( "Soma das notas: " +somaNota+
                            "\nMédia da turma: " +media+
                            "\nMaior nota: " +alunos[indiceMaior1]+ " - "+notas[indiceMaior1]+
                            "\nMenor nota: " +alunos[indiceMenor1]+ " - " +notas[indiceMenor1]+
                            "\nQuantidade de aprovados: "+aprovados);
    }
}
