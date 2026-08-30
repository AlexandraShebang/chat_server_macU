import java.awt.*;

public class App {
    public static void main(String[] args) throws Exception {
        Window window = new Window();

        int delay = 50; //Refresh 20 times per second

        Sunflower sf = new Sunflower(new Point(200, 200), 80, window);
        //window.addToGround(sf, null);

        /* Moved timer into plant class for now, since its hard to iterate through
            all plants in a frame
        Timer timer = new Timer();
        TimerTask task = new TimerTask(){
            @Override
            public void run(){
                //Put methods to call each frame here
                //This is just an example
                //sf.tick();
                //System.out.println("Tick!");
            }
        };
        */
        
        //timer.schedule(task, delay, delay);
    }
}
