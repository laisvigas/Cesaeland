package Cesaeland.Views;

import java.util.Scanner;

public class MenuLoginView {
    private Scanner scanner = new Scanner(System.in);

    public int mostrarMenuLogin() {
        System.out.println("\n===== CESAELAND LOGIN =====");
        System.out.println("1 - Cliente");
        System.out.println("2 - Engenheiro de Manutenção");
        System.out.println("3 - Administrador");
        System.out.println("0 - Sair");
        System.out.print("Escolha a opção: ");
        return scanner.nextInt();
    }

    public String lerUsername() {
        System.out.print("Username: ");
        return scanner.next();
    }

    public String lerPassword() {
        System.out.print("Password: ");
        return scanner.next();
    }

    public void executarMenuLogin() {
        int opcao;

        do {
            opcao = mostrarMenuLogin();

            switch (opcao) {
                case 1:
                    System.out.println("[LOGIN] A entrar como Cliente (sem autenticação)...");
                    // Chamar menu do Cliente
                    break;
                case 2:
                    System.out.println("[LOGIN] Engenheiro selecionado.");
                    // Fazer autenticação
                    break;
                case 3:
                    System.out.println("[LOGIN] Administrador selecionado.");
                    // Fazer autenticação
                    break;
                case 0:
                    System.out.println("A sair da aplicação...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 0);
    }
}