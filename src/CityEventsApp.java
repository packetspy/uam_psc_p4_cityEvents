import java.util.Scanner;

import Views.LoginView;
import Views.MainMenuView;

public class CityEventsApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // MainMenuView _mainMenuView = new MainMenuView(scanner);
        LoginView _loginView = new LoginView(scanner);
        _loginView.Show();
    }
}
