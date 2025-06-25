package Cesaeland.Views;

import java.util.Scanner;

public class MenuAdminView {
    private Scanner scanner = new Scanner(System.in);

    public int mostrarMenuAdmin() {
        System.out.println("\n===== MENU ADMINISTRADOR =====");
        System.out.println("1 - Consultar total de vendas");
        System.out.println("2 - Consultar total de lucro");
        System.out.println("3 - Consultar vendas e lucro por mês");
        System.out.println("4 - Atração mais procurada (adultos)");
        System.out.println("5 - Atração mais procurada (crianças)");
        System.out.println("6 - Atração mais procurada (geral)");
        System.out.println("7 - Atração mais lucrativa");
        System.out.println("8 - Atração menos lucrativa");
        System.out.println("9 - Atração com melhor preço/tempo");
        System.out.println("10 - Adicionar novo login");
        System.out.println("0 - Sair");
        System.out.print("Escolha a opção: ");
        return scanner.nextInt();
    }
}