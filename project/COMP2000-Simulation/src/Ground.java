import java.awt.Color;
import javax.swing.*;

public class Ground extends JLayeredPane{
    Ground() {
        this.setOpaque(true);
        this.setBackground(new Color(140,250,100));
        this.setBounds(0,Window.WIN_HEIGHT/4,Window.WIN_WIDTH,Window.WIN_HEIGHT);
    }
}
