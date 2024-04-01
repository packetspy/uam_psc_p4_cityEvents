package Services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;
import java.util.ArrayList;

import Models.User;

public class UserService {

    private ArrayList<User> userList = new ArrayList<User>();
    private final String PATH = "src/data/";
    private final String FILE = "users";
    private final String EXTENSION = ".txt";

    public User createUser(String name, String email, LocalDate birthday, String gender, String password) {
        return new User(name, email, birthday, gender, password);
    }

    public void saveUserToFile(User user) {
        try (FileWriter writer = new FileWriter(PATH + FILE + EXTENSION, true)) {
            writer.write(user.toString() + "\n\n");
            System.out.println("Usuário salvo com sucesso.");
        } catch (IOException e) {
            System.err.println("Erro ao salvar usuário: " + e.getMessage());
        }
    }

    public List<User> getAllUsers() {
        loadUsersFromFile();
        return this.userList;
    }

    public boolean checkEmailExists(String email) {
        try (BufferedReader reader = new BufferedReader(new FileReader(PATH + FILE + EXTENSION))) {
            String line;
            while ((line = reader.readLine()) != null) {
                User user = handleUser(line);
                String emailStored = user.getEmail();
                if (emailStored.equals(email)) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
        return false;
    }

    public boolean login(String email, String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader(PATH + FILE + EXTENSION))) {
            String line;
            while ((line = reader.readLine()) != null) {
                User user = handleUser(line);
                if (email.equals(user.getEmail()) && password.equals(user.getPassword())) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
        return false;
    }

    public User getUserByEmailAndPassword(String email, String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader(PATH + FILE +
                EXTENSION))) {
            String line;
            while ((line = reader.readLine()) != null) {

                User user = handleUser(line);
                if (email.equals(user.getEmail()) && password.equals(user.getPassword())) {
                    return user;
                } else {
                    System.out.println("Ocorreu um erro grave!");
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
        return null;
    }

    private void loadUsersFromFile() {
        userList.clear();
        File file = new File(FILE);

        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(PATH + FILE + EXTENSION))) {
                String line;

                while ((line = reader.readLine()) != null) {

                    User user = handleUser(line);
                    if (user.getId() != null) {
                        userList.add(user);
                    } else {
                        System.out.println("Ocorreu um erro grave!");
                    }
                }
            } catch (IOException e) {
                System.out.println("Erro ao ler o arquivo: " + e.getMessage());
            }
        } else {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private User handleUser(String line) {
        String[] userData = line.split(",");
        if (userData.length == 6) {
            UUID id = UUID.fromString(userData[0].trim());
            String name = userData[1].trim();
            String email = userData[2].trim();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate birthday = LocalDate.parse(userData[3].trim(), formatter);
            String gender = userData[4].trim();
            String password = userData[5].trim();

            User user = new User(id, name, email, birthday, gender, password);
            return user;
        } else {
            User user = new User();
            return user;
        }
    }
}