package modulo1.exercicios.repeticoes;

public class AnaliseDeTemperaturas {
    public static void main(String[]args) {

        double[] temperaturas = {21.5, 27.8, 30.2, 18.9, 25.0, 32.4, 23.7};
        double soma = 0;
        int temperaturaMaior25 = 0;
        int temperaturaMenor25 = 0;
        double maiorTemperatura = temperaturas[0];
        double menorTemperatura = temperaturas[0];
        System.out.printf("Temperaturas: \n");
        for (double temperatura : temperaturas) {
            System.out.printf("%.2f°C%n",temperatura);
            soma += temperatura;
            if (temperatura >= 25) {
                temperaturaMaior25++;
            } else {
                temperaturaMenor25++;
            }
            if (maiorTemperatura < temperatura) {
                maiorTemperatura = temperatura;
            }
            if (menorTemperatura > temperatura) {
                menorTemperatura = temperatura;
            }
        }
        double media = soma / temperaturas.length;
        System.out.printf("\nRelatório:%n%n" +
                "Média: %.2f°C%n" +
                "Maior temperatura: %.2f°C%n" +
                "Menor temperatura: %.2f°C%n" +
                "Temperaturas >= 25°C: %d%n" +
                "Temperaturas < 25°C: %d%n",media,maiorTemperatura,menorTemperatura,temperaturaMaior25,temperaturaMenor25);
    }
}
