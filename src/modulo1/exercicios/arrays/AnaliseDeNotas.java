package modulo1.exercicios.arrays;

public class AnaliseDeNotas {

    static double media(double[] notas) {
        double soma = 0;
        for (int i = 0; i < notas.length; i++) {
            soma += notas[i];
        }
        return soma / notas.length;
    }

    static int aprovados(double[] notas) {
        int aprovados = 0;
        for (int i = 0; i < notas.length; i++) {
            if (notas[i] >= 6) {
                aprovados += 1;
            }
        }
        return aprovados;
    }

    static int reprovados(double[] notas) {
        int reprovados = 0;
        for (int i = 0; i < notas.length; i++) {
            if (notas[i] < 6) {
                reprovados += 1;
            }
        }
        return reprovados;
    }

    static double maiorNota(double[] notas) {
        double maiorNota = notas[0];
        for (int i = 1; i < notas.length; i++) {
            if (notas[i]>maiorNota) {
                maiorNota = notas[i];
            }
        }
        return maiorNota;
    }
    static double menorNota(double[] notas) {
        double menorNota = notas[0];
        for (int i = 1; i < notas.length; i++) {
            if (notas[i]<menorNota) {
                menorNota = notas[i];
            }
        }
        return menorNota;
    }

    static void executarSistema(double media, int aprovados, int reprovados, double maiorNota, double menorNota) {
        System.out.println("Média da turma: "+media+"\nQuantidade de aprovados: "+aprovados+"\nQuantidade de reprovados: "+reprovados+"\nMaior nota: "+maiorNota+"\nMenor nota: "+menorNota);

    }

    public static void main(String[]args) {
        double[] notas = {7.5, 4.0, 8.5, 6.0, 3.5, 9.0, 5.5, 10.0};

        double media =  media(notas);
        int aprovados = aprovados(notas);
        int reprovados = reprovados(notas);
        double maiorNota = maiorNota(notas);
        double menorNota = menorNota(notas);
        executarSistema(media,aprovados,reprovados,maiorNota,menorNota);

    }
}
