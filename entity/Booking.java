package M13Practice1.entity;

public class Booking {
    private  int id;
    private  User user;
    private  Event event;
    private BookingStatus status;

    public Booking(int id, User user, Event event) {
        this.id = id;
        this.user = user;
        this.event = event;
        this.status = BookingStatus.ACTIVE;
    }

    public int getId() { return id; }
    public User getUser() { return user; }
    public Event getEvent() { return event; }
    public BookingStatus getStatus() { return status; }

    public void cancel() {
        this.status = BookingStatus.CANCELLED;
    }

    @Override
    public String toString() {
        return String.format("Booking{id=%d, user=%s, event=%s, status=%s}",
                id, user.getName(), event.getName(), status);
    }
}