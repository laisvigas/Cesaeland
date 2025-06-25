package Cesaeland.Views;

import java.util.Scanner;

public class MenuClienteView {
    private Scanner scanner = new Scanner(System.in);

    public int mostrarMenuCliente() {
        System.out.println("\n===== MENU CLIENTE =====");
        System.out.println("1 - Consultar atrações disponíveis");
        System.out.println("2 - Consultar atrações favoritas");
        System.out.println("0 - Sair");
        System.out.print("Escolha a opção: ");
        return scanner.nextInt();
    }
}