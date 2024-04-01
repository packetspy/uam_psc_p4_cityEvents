package Views;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import Controllers.EventController;
import Models.Event;

public class EventMenuView {
    private Scanner scanner;
    private EventController eventController;

    public EventMenuView(Scanner _scanner) {
        EventController _eventController = new EventController();

        scanner = _scanner;
        eventController = _eventController;
    }

    public void showNewEventEntry() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");

        System.out.println("Enter Name Event:");
        String name = scanner.nextLine().replace(",", "");

        System.out.println("Enter Start Date (dd/mm/yyyy):");
        LocalDate date = LocalDate.parse(scanner.nextLine().replace(",", ""), formatter);

        System.out.println("Enter Type (Show/Parade):");
        String type = scanner.nextLine().replace(",", "");

        EventController.createEvent(name, date, type);
    }

    public void listEvents() {
        List<Event> events = eventController.getAllEvents();

        for (Event event : events) {
            System.out.println("Event: \t" + event.toShowList());
        }
        System.out.println("\n");
    }
}
