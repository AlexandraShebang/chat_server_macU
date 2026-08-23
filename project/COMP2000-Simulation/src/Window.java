import javax.swing.JFrame;

public class Window extends JFrame{
    //Window of the application
    //Defines screenspace

    public static int WIN_WIDTH = 1600;
    public static int WIN_HEIGHT = 1200;

    Window() {
        Sky sky = new Sky();
        Ground ground = new Ground();

        this.setTitle("GAASK Plant Simulation COMP2000");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //Exit appliction when x pressed
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        this.add(sky);
        this.add(ground);
        
        this.pack();

        this.setVisible(true);
    }
}
