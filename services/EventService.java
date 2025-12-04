package M13Practice1.services;

import M13Practice1.entity.Event;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EventService {
    private  List<Event> events = new ArrayList<>();
    private int nextId = 1;

    public EventService() {
            addEvent("Конференция Java", LocalDate.now().plusDays(10), "Алматы");
        addEvent("Music Fest", LocalDate.now().plusDays(20), "Астана");
        addEvent("Business Forum", LocalDate.now().plusDays(30), "Шымкент");
    }

    public List<Event> getAllEvents() {
        return events;
    }

    public Event addEvent(String name, LocalDate date, String location) {
        Event e = new Event(nextId++, name, date, location);
        events.add(e);
        return e;
    }

    public boolean deleteEvent(int id) {
        return events.removeIf(e -> e.getId() == id);
    }

    public Optional<Event> findById(int id) {
        return events.stream().filter(e -> e.getId() == id).findFirst();
    }

    public void editEvent(int id, String newName, LocalDate newDate, String newLocation) {
        findById(id).ifPresent(e -> {
            if (newName != null) e.setName(newName);
            if (newDate != null) e.setDate(newDate);
            if (newLocation != null) e.setLocation(newLocation);
        });
    }
}
