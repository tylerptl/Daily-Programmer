import java.io.IOException;

public class Driver {
    public static void main(String... args) throws IOException {
        Commission logic = new Commission();
        logic.fillTable();
        logic.printCommission();
    }
}
