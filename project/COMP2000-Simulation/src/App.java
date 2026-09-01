import java.awt.*;

public class App {
    public static void main(String[] args) {
        Window window = new Window();

        int delay = 50; //Refresh 20 times per second

        new Sunflower(new Point(200, 200), window);
    }
}
