package M13Practice1.services;

import M13Practice1.entity.Booking;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import M13Practice1.entity.Booking;
import M13Practice1.entity.Event;
import M13Practice1.entity.Role;
import M13Practice1.entity.User;

public class BookingService {
    private  List<Booking> bookings = new ArrayList<>();
    private int nextId = 1;

    public Booking createBooking(User user, Event event) {
        Booking booking = new Booking(nextId++, user, event);
        bookings.add(booking);
        return booking;
    }

    public boolean cancelBooking(int bookingId, User user) {
        Optional<Booking> opt = bookings.stream()
                .filter(b -> b.getId() == bookingId)
                .findFirst();
        if (opt.isEmpty()) return false;

        Booking booking = opt.get();
        if (user.getRole() != Role.ADMIN && booking.getUser().getId() != user.getId()) {
            System.out.println("Нельзя отменять чужие бронирования.");
            return false;
        }
        booking.cancel();
        return true;
    }

    public List<Booking> getBookingsForUser(User user) {
        return bookings.stream()
                .filter(b -> b.getUser().getId() == user.getId())
                .collect(Collectors.toList());
    }

    public List<Booking> getAllBookings() {
        return bookings;
    }
}