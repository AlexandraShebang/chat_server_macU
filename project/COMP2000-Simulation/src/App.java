import java.awt.*;

public class App {
    public static void main(String[] args) {
        Window window = new Window();

        int delay = 50; //Refresh 20 times per second
        Controller controller = new Controller(window); //starts controller and weather timer

        //TODO: needs refresh rate code here or in controller - Allie

        new Sunflower(new Point(200, 200), window);
    }
}
