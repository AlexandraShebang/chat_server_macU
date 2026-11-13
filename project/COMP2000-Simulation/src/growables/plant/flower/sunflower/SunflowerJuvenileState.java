package growables.plant.flower.sunflower;

import growables.plant.PlantState;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class SunflowerJuvenileState implements PlantState {
    public static final String NAME = "JUVENILE";
    private final Sunflower flower;

    public SunflowerJuvenileState(Sunflower flower) {
        this.flower = flower;
    }

    @Override
    public void paintComponent(Graphics g) {
        Point pos = flower.getPosition();
        flower.setBounds(pos.x - Sunflower.SIZE/4, pos.y - Sunflower.SIZE/4, Sunflower.SIZE/2, Sunflower.SIZE/2);
        g.setColor(new Color(2, 184, 9));
        g.fillOval(0, 0, flower.getBounds().width, flower.getBounds().height);
    }

    @Override
    public void checkChange(long lifespan) {
        flower.setFightingPower(4);
        if(lifespan > flower.getGrowthDelay() * 3) {
            flower.transitionTo(flower.getAdultState());
        }
    }

    @Override
    public String getName() {
        return NAME;
    }
}