package Cesaeland.Views;

import java.util.Scanner;

public class MenuEngenheiroView {
    private Scanner scanner = new Scanner(System.in);

    public int mostrarMenuEngenheiro() {
        System.out.println("\n===== MENU ENGENHEIRO DE MANUTENÇÃO =====");
        System.out.println("1 - Consultar próximas revisões");
        System.out.println("2 - Consultar histórico de revisões");
        System.out.println("0 - Sair");
        System.out.print("Escolha a opção: ");
        return scanner.nextInt();
    }
}