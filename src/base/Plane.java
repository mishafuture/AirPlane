package base;

public record Plane(String name, int speed) {

    public Plane {

        name = name.trim();
        if (!isValid(name, speed)) {
            System.out.println("Введите корректное название самолета\n");
            Plane temp = InputData.plane();
            name = temp.name.trim();
            speed = temp.speed;
        }
        char first = name.charAt(0);
        name = Character.toString(first).toUpperCase() + name.substring(1);
    }

    private boolean isValid(String name, int speed) {

        if (speed <= 0) {
            System.out.println("Скорость самолета отрицательная");
            return false;
        }

        char[] buffer = name.toCharArray();
        int cur = 0, size = buffer.length;

        if (size == 0) return false;

        for (int i = cur; i < size; i++, cur++)
            if (!Character.isAlphabetic(buffer[i]))
                break;

        if (cur == size) return true;

        if (buffer[0] != '-' && buffer[cur] == '-') {
            cur++;
            for (int i = cur + 1; i < size; i++, cur++) {
                if (!Character.isDigit(buffer[i]))
                    break;
            }
        }

        return cur == size - 1;
    }

    @Override
    public String toString() {
        return "Название самолета - " + name + "\n"
                + "Скорость - " + speed + " км/час\n";
    }
}
