import javax.swing.JFrame;

public class Window extends JFrame{
    //Window of the application
    //Defines screenspace

    public static int WIN_WIDTH = 1600;
    public static int WIN_HEIGHT = 1200;

    Window() {
        this.setTitle("GAASK Plant Simulation COMP2000");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //Exit appliction when x pressed
        this.setResizable(false);
        this.setLayout(null);
        this.setSize(WIN_WIDTH,WIN_HEIGHT);
        this.setVisible(true);
    }
}
