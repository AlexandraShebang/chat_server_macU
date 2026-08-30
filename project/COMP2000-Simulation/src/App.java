import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class App {
    public static void main(String[] args) throws Exception {
        Window window = new Window();

        int delay = 50; //Refresh 20 times per second

        Sunflower sf = new Sunflower(new Point(50, 50), 80);
        window.addToGround(sf, null);

        Timer timer = new Timer();
        TimerTask task = new TimerTask(){
            @Override
            public void run(){
                //Put methods to call each frame here
                //This is just an example
                sf.tick();
                System.out.println("Tick!");
            }
        };

        
        
        timer.schedule(task, delay, delay);
    }
}
