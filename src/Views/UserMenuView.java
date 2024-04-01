package Views;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import Controllers.UserController;
import Models.User;
import Utils.Screen;

public class UserMenuView {

    private Scanner scanner;
    private UserController userController;

    public UserMenuView(Scanner _scanner) {
        UserController _usercController = new UserController();

        scanner = _scanner;
        userController = _usercController;
    }

    public void showLoginEntry() {
        Screen.clear();
        System.out.println("Email:");
        String email = scanner.nextLine().replace(",", "");

        if (userController.checkEmailExists(email)) {
            System.out.print("Senha: ");
            String password = scanner.nextLine().replace(",", "");

            if (userController.login(email, password)) {
                Screen.clear();
                System.out.println("Login bem sucedido. Seja bem vindo!");
                User loggedUser = userController.getUserByEmailAndPassword(email, password);
                MainMenuView _mainMenuView = new MainMenuView(scanner, loggedUser);
                _mainMenuView.Show();
            } else {
                System.out.println("Email não cadastrado.");
                System.out.println("\n");
            }
        } else {
            System.out.println("E-mail não cadastrado.");
        }
    }

    public void showNewUserEntry() {
        System.out.println("Nome:");
        String name = scanner.nextLine().replace(",", "");

        System.out.println("Email:");
        String email = scanner.nextLine().replace(",", "");

        System.out.println("Aniversário (dd/mm/yyyy):");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        LocalDate birthday = LocalDate.parse(scanner.nextLine().replace(",", ""), formatter);

        System.out.println("Gênero (Masculino/Feminino/Outros):");
        String gender = scanner.nextLine().replace(",", "");

        System.out.println("Senha:");
        String password = scanner.nextLine().replace(",", "");

        userController.createUser(name, email, birthday, gender, password);
    }

    public void listUsers() {
        List<User> users = userController.getAllUsers();

        for (User user : users) {
            System.out.println("User: \t" + user.toShowList());
        }
        System.out.println("\n");
    }
}
