package Controllers;

import java.time.LocalDate;
import java.util.List;

import Models.Event;
import Services.EventService;

public class EventController {

    private EventService eventService;

    public EventController() {
        EventService _eventService = new EventService();
        eventService = _eventService;
    }

    public static Event createEvent(String name, LocalDate date, String type) {
        EventService eventService = new EventService();

        // Create Event
        Event newEvent = eventService.createEvent(name, date, type);

        // Save event to file
        eventService.saveEventToFile(newEvent);

        return newEvent;
    }

    public List<Event> getAllEvents() {
        List<Event> events = eventService.getAllEvents();
        return events;
    }
}