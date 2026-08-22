
public class App {
    public static void main(String[] args) throws Exception {
        Window window = new Window();
        
        Sky sky = new Sky();
        Ground ground = new Ground();

        window.add(sky);
        window.add(ground);
    }
}
