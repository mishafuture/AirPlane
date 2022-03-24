package base;

import java.util.function.Function;
import java.util.function.Predicate;

public record Time(int hour, int minute, int second) {
    public Time {
        if (!isValid(hour, minute, second)) {
            Time temp = InputData.time();
            hour = temp.getHour();
            minute = temp.getMinute();
            second = temp.getSecond();
        }
    }

    private static boolean isValid(int hour, int minute, int second) {
        try {
            if (hour > 23 || hour < 0)
                throw new TimeNotValidException("Время введено не корректно", hour, "hour");
            else if (minute > 59 || minute < 0)
                throw new TimeNotValidException("Время введено не корректно", minute, "minute");
            else if (second > 59 || second < 0)
                throw new TimeNotValidException("Время введено не корректно", second, "second");
            else
                return true;
        } catch (TimeNotValidException ex) {
            System.out.println(ex.getMessage());
            System.out.println(ex.getNumber() + " " + ex.getUnit());
            System.out.println("Введите корректное время!");
        }
        return false;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }

    @Override
    public String toString() {
        String newHour;
        String newMinute;
        String newSecond;

        Predicate<Integer> isDoubleDigit = x -> x > 10;
        Function<Integer, String> convert = x -> "0" + x;

        if (!isDoubleDigit.test(hour))
            newHour = convert.apply(hour);
        else
            newHour = Integer.toString(hour);
        if (!isDoubleDigit.test(minute))
            newMinute = convert.apply(minute);
        else
            newMinute = Integer.toString(minute);
        if (!isDoubleDigit.test(second))
            newSecond = convert.apply(second);
        else
            newSecond = Integer.toString(second);

        return newHour + " : " + newMinute + " : " + newSecond;
    }
}
