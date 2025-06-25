package Cesaeland.Views;

import java.util.Scanner;

public class MenuEngenheiroView {
    private Scanner scanner = new Scanner(System.in);

    public void executarMenuEngenheiro() {
        int opcao;

        do {
            System.out.println("\n===== MENU ENGENHEIRO DE MANUTENÇÃO =====");
            System.out.println("1 - Consultar próximas revisões");
            System.out.println("2 - Consultar histórico de revisões");
            System.out.println("0 - Sair");
            System.out.print("Escolha a opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("[FUNCIONALIDADE] Próximas revisões (TOP 3)");
                    // Chamar controlador
                    break;
                    
                case 2:
                    System.out.println("[FUNCIONALIDADE] Histórico de revisões (TOP 3)");
                    // Chamar controlador
                    break;

                case 0:
                    System.out.println("A sair do menu Engenheiro...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);
    }
}