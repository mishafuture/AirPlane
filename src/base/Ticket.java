package base;

public record Ticket(String price, String toCity, String fromCity,
                     Time departureTime, Time arriveTime) {
}
