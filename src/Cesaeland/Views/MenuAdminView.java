package Cesaeland.Views;

import java.util.Scanner;

public class MenuAdminView {
    private Scanner scanner = new Scanner(System.in);

    public void executarMenuAdmin() {
        int opcao;

        do {
            System.out.println("\n===== MENU ADMINISTRADOR =====");
            System.out.println("1 - Consultar total de vendas");
            System.out.println("2 - Consultar lucro total");
            System.out.println("0 - Sair");
            System.out.print("Escolha a opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("[FUNCIONALIDADE] Total de vendas");
                    break;

                case 2:
                    System.out.println("[FUNCIONALIDADE] Lucro total");
                    break;

                case 0:
                    System.out.println("A sair do menu Administrador...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }
}