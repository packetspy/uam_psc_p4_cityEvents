package Services;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

import Models.Event;

public class EventService {

    public Event createEvent(String name, LocalDate startDate, LocalDate endDate, String type) {
        return new Event(name, startDate, endDate, type);
    }

    public void saveEventToFile(Event event) {
        try (FileWriter writer = new FileWriter("src/data/events.txt", true)) {
            writer.write(event.toString() + "\n\n");
            System.out.println("Event saved successfully.");
        } catch (IOException e) {
            System.err.println("Error saving event: " + e.getMessage());
        }
    }

}
