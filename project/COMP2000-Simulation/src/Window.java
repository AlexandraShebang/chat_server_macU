import javax.swing.JFrame;

public class Window extends JFrame{
    //Window of the application
    //Defines screenspace

    Window() {
        this.setTitle("GAASK Plant Simulation COMP2000");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //Exit appliction when x pressed
        this.setResizable(false);
        this.setLayout(null);
        this.setSize(1600,1200);
        this.setVisible(true);
    }
}
