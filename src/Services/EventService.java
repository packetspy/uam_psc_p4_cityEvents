package Services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import Models.Event;

public class EventService {

    private ArrayList<Event> eventList = new ArrayList<Event>();
    private final String PATH = "src/data/";
    private final String FILE = "events";
    private final String EXTENSION = ".txt";

    public Event createEvent(String name, LocalDate date, String type) {
        return new Event(name, date, type);
    }

    public void saveEventToFile(Event event) {
        try (FileWriter writer = new FileWriter(PATH + FILE + EXTENSION, true)) {
            writer.write(event.toString() + "\n\n");
            System.out.println("Evento salvo com sucesso.");
        } catch (IOException e) {
            System.err.println("Erro ao salvar evento: " + e.getMessage());
        }
    }

    public List<Event> getAllEvents() {
        loadEventsFromFile();
        return this.eventList;
    }

    private void loadEventsFromFile() {
        eventList.clear();
        File file = new File(FILE);

        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(PATH + FILE + EXTENSION))) {
                String line;

                while ((line = reader.readLine()) != null) {

                    Event event = handleEvent(line);
                    if (event.getId() != null) {
                        eventList.add(event);
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

    private Event handleEvent(String line) {
        String[] eventData = line.split(",");
        if (eventData.length == 4) {
            UUID id = UUID.fromString(eventData[0].trim());
            String name = eventData[1].trim();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate date = LocalDate.parse(eventData[2].trim(), formatter);
            String type = eventData[3].trim();

            Event event = new Event(id, name, date, type);
            return event;
        } else {
            Event event = new Event();
            return event;
        }
    }

}
