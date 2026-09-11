package modulo1.fundamentos;

public class OperadoresComparacao {
    public static void main(String[]args) {
        // == igual
        // != diferente
        // > maior
        // < menor
        // >= maior ou igual
        // <= menor ou igual

        int numero1 = 15;
        int numero2 = 20;

        System.out.println(numero1 > numero2);
        System.out.println(numero1 != numero2);
        System.out.println(numero1 <= numero2);
        System.out.println(numero2 == 20);

        int idade = 19;
        System.out.println(idade >= 18);

        // && E
        // || Ou
        // ! Inverte

        boolean temIngresso = true;
        System.out.println(idade >= 18 && temIngresso);

        boolean estudante = true;
        System.out.println(idade < 18 || estudante);

        boolean contaBloqueada = false;
        System.out.println(!contaBloqueada);


    }
}
