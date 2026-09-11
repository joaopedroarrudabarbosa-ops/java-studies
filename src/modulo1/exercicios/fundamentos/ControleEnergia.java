package modulo1.exercicios.fundamentos;

public class ControleEnergia {
    public static void main(String[]args) {
        int energia = 5;
        while (energia > 0) {
            System.out.println("Você tem "+energia+" de energia.");
            energia--;
        }
        if (energia == 0) {
            System.out.println("Sem energia.");
        }
    }
}
