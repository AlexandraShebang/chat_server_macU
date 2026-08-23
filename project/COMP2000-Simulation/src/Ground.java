import java.awt.*;
import javax.swing.*;

public class Ground extends JPanel{
    Ground() {

        //Currently the Ground is the whole size of the window and the sky goes over it
        this.setPreferredSize(new Dimension(Window.WIN_WIDTH, Window.WIN_HEIGHT/4*3));
        //this.setBounds(0, Window.WIN_WIDTH/4, Window.WIN_WIDTH, Window.WIN_HEIGHT/4*3);
        this.setBackground(Color.green);
    }
}
