import java.awt.*;

public class App {
    public static void main(String[] args) throws Exception {
        Window window = new Window();

        Sunflower sf = new Sunflower(new Point(50, 50), 80);
        window.addToGround(sf, null);
    }
}
