package modulo1.exercicios.repeticoes;
import java.util.Scanner;

public class SistemaDeLogin {

    static boolean verificarSenha(int senha, int senhaCorreta) {
        return senha == senhaCorreta;
    }

    public static void main(String[]args) {
        Scanner scanner = new Scanner(System.in);

        int tentativas = 0;
        int senhaCorreta = 4321;
        int senha;

        do {
            tentativas++;
            System.out.print("Digite a senha: ");
            senha = scanner.nextInt();
            if (verificarSenha(senha,senhaCorreta)) {
                System.out.println("Acesso permitido");
                System.out.println("Tentativas utilizadas: "+tentativas);
                return;
            } else {
                System.out.println("Senha incorreta.");
            }
        } while (tentativas < 3 && !verificarSenha(senha,senhaCorreta));
        System.out.println("Acesso bloqueado.");
        System.out.println("Tentativas utilizadas: "+tentativas);
    }
}
