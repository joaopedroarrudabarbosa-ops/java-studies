package modulo1.exercicios.metodos;

public class Conversor {

    static int conversor(int horas) {
        return horas * 60;
    }

    static double conversor(double quilometros) {
        return quilometros * 1000;
    }

    static int conversor(int horas, int minutos) {
        return (horas * 60) + minutos;
    }

    public static void main(String[]args) {

        int minutos = conversor(2);
        System.out.println(minutos);
        double metros = conversor(1.5);
        System.out.println(metros);
        int horasMinutos = conversor(2,30);
        System.out.println(horasMinutos);


    }
}
