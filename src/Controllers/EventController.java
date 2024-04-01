package Controllers;

import java.time.LocalDate;

import Models.Event;
import Services.EventService;

public class EventController {

    public static Event createEvent(String name, LocalDate startDate, LocalDate endDate, String type) {
        EventService eventService = new EventService();

        // Create Event
        Event newEvent = eventService.createEvent(name, startDate, endDate, type);

        // Save event to file
        eventService.saveEventToFile(newEvent);

        return newEvent;
    }
}