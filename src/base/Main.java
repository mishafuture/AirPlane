package base;

public class Main {

    public static void main(String[] args) {

        //Ticket ticket = new Ticket(600, "Харьков", "Киев",
        //        InputData.time(), 30, 61);
        //Plane boeing = new Plane("Боинг-1", 30, 1, ticket);
        Plane boeing = InputData.plane();
        System.out.println(boeing);
        InputData.close();
    }
}
