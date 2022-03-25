package base;

import java.io.IOException;
import java.util.function.Function;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class InputData {
    private static BufferedReader sReader;
    private static long number = 0;

    static public Time time() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            Function<String, Integer> convert = Integer::parseInt;
            System.out.println("Точное время отправки самолета");
            System.out.print("Введите количество часов ");
            int hour = convert.apply(reader.readLine().trim());
            System.out.print("Введите количество минут ");
            int minute = convert.apply(reader.readLine().trim());
            System.out.print("Введите количество секунд ");
            int second = convert.apply(reader.readLine().trim());
            sReader = reader;
            return new Time(hour, minute, second);
        }
        catch (NumberFormatException ex) {
            System.out.println("Получен " + ex.getMessage() + " при вводе данных");
            System.out.println("Введите корректное время!");
            return InputData.time();
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
            return InputData.time();
        }
    }

    static public Plane plane() {
        number++;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            Function<String, Integer> convert = Integer::parseInt;
            System.out.print("Введите название самолета ");
            String name = reader.readLine();
            System.out.print("введите скорость самолета в км/час ");
            int speed = convert.apply(reader.readLine().trim());
            sReader = reader;
            return new Plane(name, speed);
        }
        catch (IOException ioe) {
            System.out.println(ioe.getMessage());
            return InputData.plane();
        }
    }

    static void close() {
        try {
            sReader.close();
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
