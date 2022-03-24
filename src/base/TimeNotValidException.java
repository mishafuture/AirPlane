package base;

public class TimeNotValidException extends Exception {
    private final int number;
    private final String unit;

    public TimeNotValidException(String message, int number, String unit) {

        super(message);
        this.number = number;
        if (Math.abs(number) > 1)
            unit = String.join("", unit, "s");
        this.unit = unit;
    }

    public String getUnit() {
        return unit;
    }

    public int getNumber() {
        return number;
    }
}
