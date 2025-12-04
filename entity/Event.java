package M13Practice1.entity;

import java.time.LocalDate;

public class Event {
    private  int id;
    private String name;
    private LocalDate date;
    private String location;

    public Event(int id, String name, LocalDate date, String location) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.location = location;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public LocalDate getDate() { return date; }
    public String getLocation() { return location; }

    public void setName(String name) { this.name = name; }
    public void setDate(LocalDate date) { this.date = date; }
    public void setLocation(String location) { this.location = location; }

    @Override
    public String toString() {
        return String.format("Event{id=%d, name='%s', date=%s, location='%s'}",
                id, name, date, location);
    }
}