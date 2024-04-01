package Models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

public class Event {
    private UUID id;
    private String name;
    private LocalDate date;
    private String type;
    private ArrayList<User> participants;

    public Event(UUID id, String name, LocalDate date, String type) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.date = date;
        this.type = type;
        this.participants = participants;
    }

    public Event(String name, LocalDate date, String type) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.date = date;
        this.type = type;
        this.participants = participants;
    }

    public Event() {
        this.id = null;
        this.name = null;
        this.date = null;
        this.type = null;
        this.participants = null;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String toString() {
        return id + "," + name + "," + date + "," + type;
    }

    public String toShowList() {
        return name + " \t\t " + date + " \t\t " + type;
    }

    public ArrayList<User> getParticipants() {
        return participants;
    }
}