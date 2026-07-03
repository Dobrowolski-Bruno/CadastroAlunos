import java.util.Scanner;

public class CadastroAlunos {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int qtd;
        System.out.print("Quantos alunos deseja cadastrar? ");
        qtd = sc.nextInt();
        sc.nextLine();

        String[] nomes = new String[qtd];
        double[] nota1 = new double[qtd];
        double[] nota2 = new double[qtd];
        double[] media = new double[qtd];

        for (int i = 0; i < qtd; i++) {
            System.out.println("\n--- Aluno " + (i + 1) + " ---");
            System.out.print("Nome: ");
            nomes[i] = sc.nextLine();

            System.out.print("Nota 1: ");
            nota1[i] = sc.nextDouble();

            System.out.print("Nota 2: ");
            nota2[i] = sc.nextDouble();
            sc.nextLine();

            media[i] = (nota1[i] + nota2[i]) / 2;
        }

        System.out.println("\n===== RESULTADO FINAL =====");
        for (int i = 0; i < qtd; i++) {
            String situacao;
            if (media[i] >= 6) {
                situacao = "APROVADO";
            } else if (media[i] >= 4) {
                situacao = "RECUPERACAO";
            } else {
                situacao = "REPROVADO";
            }

            System.out.printf("%-15s Media: %.1f  Situacao: %s%n", nomes[i], media[i], situacao);
        }

        double soma = 0;
        for (int i = 0; i < qtd; i++) {
            soma = soma + media[i];
        }
        double mediaTurma = soma / qtd;
        System.out.printf("\nMedia geral da turma: %.2f%n", mediaTurma);

        int indiceMaior = 0;
        for (int i = 1; i < qtd; i++) {
            if (media[i] > media[indiceMaior]) {
                indiceMaior = i;
            }
        }
        System.out.println("Aluno com melhor media: " + nomes[indiceMaior]);

        System.out.print("\nDigite um nome para buscar (ou ENTER pra sair): ");
        String busca = sc.nextLine();

        if (!busca.isEmpty()) {
            boolean achou = false;
            for (int i = 0; i < qtd; i++) {
                if (nomes[i].equalsIgnoreCase(busca)) {
                    System.out.println("Encontrado! Media de " + nomes[i] + " = " + media[i]);
                    achou = true;
                    break;
                }
            }
            if (!achou) {
                System.out.println("Aluno nao encontrado.");
            }
        }

        sc.close();
    }
}
