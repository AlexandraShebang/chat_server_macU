import java.awt.*;

public class App {
    public static void main(String[] args) throws Exception {
        Window window = new Window();
        
        Sky sky = new Sky();
        Ground ground = new Ground();

        window.add(sky);
        window.add(ground);

        Sunflower sf = new Sunflower(new Point(80, 40), 80);
        ground.add(sf);

    }
}
