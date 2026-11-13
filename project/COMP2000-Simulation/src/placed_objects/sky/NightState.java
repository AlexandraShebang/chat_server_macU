package placed_objects.sky;

import java.awt.Color;
import java.awt.Graphics;
import supplementary.Window;

public class NightState implements SkyState {
    public static final String NAME = "NIGHT";
    private final Sky sky;

    public NightState(Sky sky) {
        this.sky = sky;
    }

    @Override
    public void paintComponent(Graphics g) {
        sky.setBackground(Color.BLACK);
        g.setColor(Color.WHITE);
        double p = (((double) sky.getHour()) / 12000) - 1;
        g.fillOval((int) (p * (double) Window.WIN_WIDTH) - 50, 0, 50, 50);
    }

    @Override
    public void checkChange() {
        if(sky.getHour() < 12000) {
            sky.transitionTo(sky.getSunnyState());
        }
    }

    @Override
    public String getName() {
        return NAME;
    }
}