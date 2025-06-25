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
}