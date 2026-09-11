package modulo1.arrays;
import java.util.Arrays;

public class IntroducaoArrays {
    public static void main(String[]args) {

//        int numero1 = 10;
//        int numero2 = 20; // ANTES CRIARIAMOS VALORES int E CADA UM RECEBERIA UM VALOR, AGIRA CRIAMOS UM ARRAY DE TAMANHO 3,
//        int numero3 = 30; // QUE TEM INDICE 0 , 1 E 2

        int[] numeros = {10, 20, 30}; // CRIANDO UM ARRAY
        System.out.println(numeros[2]);

        numeros[1] = 80; // ALTERANDO O VALOR DO INDICE 1 QUE ANTES ERA 20 APARTR DESSA LINHA DO MEU CODIGO, AGORA SERA 80

        System.out.println(numeros[2]);
        System.out.println(numeros.length);
        System.out. println(numeros.length-1); // PARA PEGAR O INDICE DO ULTIMO ELEMENTO

        // CRIANDO ARRAY VAZIO
        int[] valores = new int[5];

        // ADICIONANDO 5 NO INDICE 0 DO ARRAY QUE ANTES ERA VAZIA, AGORA O INDICE 0 TEM VALOR O RESTANTE AINDA NAO
        valores[0] += 5;
        System.out.println(valores[0]);

        // VALORES PADROES
        int[] inteiros = new int[3]; // 0 , 0,  0
        double[] decimais = new double[3]; // 0.0 , 0.0 , 0,0
        boolean[] estados = new boolean[3]; //  false , false , false
        String[] nomes = new String[3]; // null , null , null - SIGNIFICA QUE ESSAS POSICOES NAO ESTA REFERENCIANDO NENHUM OBJETO
        System.out.println(nomes[0]); // VAI RETORNA null
        nomes[0] = "Ana";
        nomes[1] = "Carlos"; // DEPOIS PODEMOS ATRIBUIR VALORES DE Sring NORMALMENTE
        // TERIAMOS nomes[0] = "Ana" , nomes[1] = "Carlos" , nomes[2] = null

        int[] declarar; // APENAS DECLARANDO UM ARRAY
        declarar = new int[5]; // CRIANDO UM ARRAY

        int[] inicializacao = {10, 20, 30, 40, 50}; // INICIALIZACAO COM VALORES

        int[] a = {5, 10}; //
        int[] b = {5, 10}; //
        int[] c = a; //
        // c RECEBE A MESMA REFERENCIA DE a, SAO DUAS VARIAVEIS DIFERENTE, POREM, QUE APONTAM PRO MESMO ENDERECO

        // Arrays.equals(); - COMPARA ARRAYS

        int[] copia = {10, 20, 30};
        int[] copia1 = Arrays.copyOf(copia, copia.length); // PASSAMOS O ARRAY E O SEU TAMANHO PARA COPIA DE FORMA IDENPEDENTE
        int[] copia2 = copia.clone(); // TAMBEM COPIA O ARRAY DE FORMA IDENPEDENTE

    }
}
