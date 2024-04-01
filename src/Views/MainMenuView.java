package Views;

import java.util.InputMismatchException;
import java.util.Scanner;

import Models.User;
import Utils.Screen;

public class MainMenuView {

    private Scanner scanner;
    private User loggedUser;
    private UserMenuView userMenuView;
    private EventMenuView eventMenuView;

    public MainMenuView(Scanner _scanner, User _loggedUser) {
        UserMenuView _userMenuView = new UserMenuView(_scanner);
        EventMenuView _eventMenuView = new EventMenuView(_scanner);

        scanner = _scanner;
        loggedUser = _loggedUser;
        userMenuView = _userMenuView;
        eventMenuView = _eventMenuView;
    }

    public void Show() {
        try {
            while (true) {
                System.out.println(" == Menu ==");
                System.out.println("Usuário: " + loggedUser.getName() + ". Selecione uma opção:");
                System.out.println("1. Criar Usuário");
                System.out.println("2. Listar Usuários");
                System.out.println("3. Criar Evento");
                System.out.println("4. Listar Eventos");
                System.out.println("5. Exit");

                try {
                    if (scanner.hasNextInt()) {
                        System.out.println("Selecione uma opção:");
                        int choice = scanner.nextInt();
                        scanner.nextLine();

                        switch (choice) {
                            case 1:
                                Screen.clear();
                                userMenuView.showNewUserEntry();
                                break;
                            case 2:
                                Screen.clear();
                                userMenuView.listUsers();
                                break;
                            case 3:
                                Screen.clear();
                                eventMenuView.showNewEventEntry();
                                break;
                            case 4:
                                Screen.clear();
                                eventMenuView.listEvents();
                            case 5:
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