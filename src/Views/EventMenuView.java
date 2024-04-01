package Views;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import Controllers.EventController;

public class EventMenuView {
    private Scanner scanner;

    public EventMenuView(Scanner _scanner) {
        scanner = _scanner;
    }

    public void showNewEventEntry() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");

        System.out.println("Enter Name Event:");
        String name = scanner.nextLine().replace(",", "");

        System.out.println("Enter Start Date (dd/mm/yyyy):");
        LocalDate startDate = LocalDate.parse(scanner.nextLine().replace(",", ""), formatter);

        System.out.println("Enter End Date (dd/mm/yyyy):");
        LocalDate endDate = LocalDate.parse(scanner.nextLine().replace(",", ""), formatter);

        System.out.println("Enter Type (Show/Parade):");
        String type = scanner.nextLine().replace(",", "");

        EventController.createEvent(name, startDate, endDate, type);
    }
}
