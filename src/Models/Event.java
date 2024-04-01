package Models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

public class Event {
    private UUID id;
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private String type;
    private ArrayList<User> participants;

    public Event(String name, LocalDate startDate, LocalDate endDate, String type) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.type = type;
        this.participants = participants;
    }

    public String toString() {
        return id + "," + name + "," + startDate + "," + endDate + "," + type;
    }

    public ArrayList<User> getParticipants() {
        return participants;
    }
}