package M13Practice1;

import M13Practice1.entity.Booking;
import M13Practice1.entity.Event;
import M13Practice1.entity.Role;
import M13Practice1.entity.User;
import M13Practice1.services.BookingService;
import M13Practice1.services.EventService;

import java.time.LocalDate;

public class DemoApp {
    public static void main(String[] args) {
        EventService eventService = new EventService();
        BookingService bookingService = new BookingService();

        User guest = new User(1, "GuestUser", Role.GUEST);
        User user = new User(2, "RegularUser", Role.USER);
        User admin = new User(3, "AdminUser", Role.ADMIN);

        System.out.println("=== Просмотр мероприятий (гость) ===");
        eventService.getAllEvents().forEach(System.out::println);

        System.out.println("\n=== Пользователь бронирует мероприятие ===");
        Event event1 = eventService.findById(1).orElseThrow();
        Booking booking1 = bookingService.createBooking(user, event1);
        System.out.println("Создано бронирование: " + booking1);

        System.out.println("\n=== Пользователь отменяет своё бронирование ===");
        bookingService.cancelBooking(booking1.getId(), user);
        bookingService.getBookingsForUser(user).forEach(System.out::println);

        System.out.println("\n=== Администратор добавляет новое мероприятие ===");
        Event newEvent = eventService.addEvent(
                "VIP Meetup", LocalDate.now().plusDays(5), "Онлайн");
        System.out.println("Добавлено: " + newEvent);

        System.out.println("\n=== Администратор редактирует мероприятие ===");
        eventService.editEvent(newEvent.getId(), "VIP Meetup PRO",
                newEvent.getDate().plusDays(1), "Zoom");
        eventService.getAllEvents().forEach(System.out::println);

        System.out.println("\n=== Администратор удаляет мероприятие id=2 ===");
        eventService.deleteEvent(2);
        eventService.getAllEvents().forEach(System.out::println);

        System.out.println("\n=== Администратор смотрит все бронирования ===");
        bookingService.getAllBookings().forEach(System.out::println);
    }
}
