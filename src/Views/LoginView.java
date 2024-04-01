package Views;

import java.util.InputMismatchException;
import java.util.Scanner;
import Utils.Screen;

public class LoginView {

    private Scanner scanner;
    private UserMenuView userMenuView;
    private EventMenuView eventMenuView;

    public LoginView(Scanner _scanner) {
        UserMenuView _userMenuView = new UserMenuView(_scanner);
        EventMenuView _eventMenuView = new EventMenuView(_scanner);

        scanner = _scanner;
        userMenuView = _userMenuView;
        eventMenuView = _eventMenuView;
    }

    public void Show() {
        try {
            while (true) {
                System.out.println("Menu:");
                System.out.println("1. Login");
                System.out.println("2. Criar Usuário");
                System.out.println("3. Exit");

                try {
                    if (scanner.hasNextInt()) {
                        System.out.println("Selecione uma opção:");
                        int choice = scanner.nextInt();
                        scanner.nextLine();

                        switch (choice) {
                            case 1:
                                Screen.clear();
                                userMenuView.showLoginEntry();
                                break;
                            case 2:
                                Screen.clear();
                                userMenuView.showNewUserEntry();
                                break;
                            case 3:
                                System.out.println("Exiting...");
                                System.exit(0);
                                break;
                            default:
                                System.out.println("Opção incorrenta, tente novamente.");
                                break;
                        }

                    } else {
                        System.out.println("Por favor, digite um número válido.");
                        scanner.next();
                    }

                } catch (InputMismatchException e) {
                    System.out.println(e);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}