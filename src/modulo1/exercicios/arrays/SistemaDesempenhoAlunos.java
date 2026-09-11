package modulo1.exercicios.arrays;

public class SistemaDesempenhoAlunos {

    static double calcularMediaTurma(double[]notas) {
        double soma = 0;
        for (int i = 0; i < notas.length; i++) {
            soma += notas[i];
        }
        return soma/notas.length;
    }

    static int quantidadeAprovados(double[] notas) {
        int quantidade = 0;
        for (int i = 0; i < notas.length; i++) {
            if (notas[i] >= 6) {
                quantidade++;
            }
        }
        return quantidade;
    }

    static int quantidadeReprovados(double[]notas) {
        int quantidade = 0;
        for (int i = 0; i < notas.length; i++) {
            if (notas[i] < 6) {
                quantidade++;
            }
        }
        return quantidade;
    }

    static double maiorNota(double[] notas) {
        double maiorNota = notas[0];
        for (int i = 1; i < notas.length; i++) {
            if (maiorNota < notas[i]) {
                maiorNota = notas[i];
            }
        }
        return maiorNota;
    }

    static int alunoMaiorNota(double[] notas) {
        int alunoMaiorNota = 0;
        double maiorNota = notas[0];
        for (int i = 1; i < notas.length; i++) {
            if (maiorNota < notas[i]) {
                maiorNota = notas[i];
                alunoMaiorNota = i;
            }
        }
        return alunoMaiorNota;
    }

    static int alunoMenorNota(double[] notas) {
        int alunoMenorNota = 0;
        double menorNota = notas[0];
        for (int i = 1; i < notas.length; i++) {
            if (menorNota > notas[i]) {
                menorNota = notas[i];
                alunoMenorNota = i;
            }
        }
        return alunoMenorNota;
    }

    static double menorNota(double[] notas) {
        double menorNota = notas[0];
        for (int i = 1; i < notas.length; i++) {
            if (menorNota > notas[i]) {
                menorNota = notas[i];
            }
        }
        return menorNota;
    }

    static int alunoAcimaMedia(double[] notas, double mediaTurma) {
        int quantidade = 0;
        for (int i = 0; i < notas.length; i++) {
            if (notas[i] > mediaTurma ) {
                quantidade++;
            }
        }
        return quantidade;
    }

    static int alunoAbaixoMedia(double[] notas, double mediaTurma) {
        int quantidade = 0;
        for (int i = 0; i < notas.length; i++) {
            if (notas[i] < mediaTurma ) {
                quantidade++;
            }
        }
        return quantidade;
    }

    static void executarSistema(double mediaTurma,int aprovados,int reprovados,double maiorNota, String[] alunos,int alunoMaiorNota,double menorNota, int alunoMenorNota, int alunoAcimaMedia, int alunoAbaixoMedia) {
        System.out.println("Média da Turma: "+mediaTurma+"\nQuantidade de aprovados: "+aprovados+"\nQuantidade de reprovados: "+reprovados+"\nMaior nota: "+maiorNota+"\nAluno com maior nota: "+alunos[alunoMaiorNota]+"\nMenor nota: "+menorNota+"\nAluno com menor nota: "+alunos[alunoMenorNota]+"\nAlunos acima da média: "+alunoAcimaMedia+"\nAlunos abaixo da média: "+alunoAbaixoMedia);
    }

    public static void main(String[]args) {

        String[] alunos = {"Ana", "Carlos", "João", "Marina", "Lucas", "Beatriz"};
        double[] notas = {8.5, 5.0, 9.5, 6.0, 3.5, 7.0};

        double mediaTurma = calcularMediaTurma(notas);
        int aprovados = quantidadeAprovados(notas);
        int reprovados = quantidadeReprovados(notas);
        double maiorNota = maiorNota(notas);
        int alunoMaiorNota = alunoMaiorNota(notas);
        double menorNota = menorNota(notas);
        int alunoMenorNota = alunoMenorNota(notas);
        int alunoAcimaMedia = alunoAcimaMedia(notas, mediaTurma);
        int alunoAbaixoMedia = alunoAbaixoMedia(notas, mediaTurma);

        executarSistema(mediaTurma,aprovados,reprovados,maiorNota,alunos,alunoMaiorNota,menorNota, alunoMenorNota, alunoAcimaMedia, alunoAbaixoMedia);

    }
}
