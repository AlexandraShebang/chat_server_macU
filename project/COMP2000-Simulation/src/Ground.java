import java.awt.*;
import javax.swing.*;

public class Ground extends JPanel{
    Ground() {
        this.setPreferredSize(new Dimension(Window.WIN_WIDTH, Window.WIN_HEIGHT/4*3));
        this.setBackground(Color.green);
        this.setLayout(null);   //Freeform layout
    }
}
