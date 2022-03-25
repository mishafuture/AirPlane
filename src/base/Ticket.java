package base;

public class Ticket {
    private final int price;
    private final String toCity;
    private final String fromCity;
    private final Time departureTime;
    private final Time arriveTime;
    private final long seconds;

    public Ticket(int price, String toCity, String fromCity,
                Time departureTime, int speed, int distance) {
        this.price = price;
        this.toCity = toCity;
        this.fromCity = fromCity;
        this.departureTime = departureTime;
        this.seconds = Math.round(distance * 3600 / speed);
        arriveTime = null;
    }

    @Override
    public String toString() {
        return "Цена: " + price + " гривен\n"
                + "Город отправления - " + toCity + "\n"
                + "Город прибытия - " + fromCity + "\n"
                + "Время отбытия - " + departureTime + "\n"
                + "Время прибытия - " + arriveTime + "\n"
                + "Время в секундах - " + seconds + "\n";
    }

}
