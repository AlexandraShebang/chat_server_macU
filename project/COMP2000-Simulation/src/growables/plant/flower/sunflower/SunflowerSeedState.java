package growables.plant.flower.sunflower;

import growables.plant.PlantState;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class SunflowerSeedState implements PlantState {
    public static final String NAME = "SEED";
    private final Sunflower flower;

    public SunflowerSeedState(Sunflower flower) {
        this.flower = flower;
    }

    @Override
    public void paintComponent(Graphics g) {
        flower.setOpaque(false);
        g.setColor(new Color(79, 46, 9));
        g.fillOval(0, 0, flower.getBounds().width, flower.getBounds().height);
        
        Point pos = flower.getPosition();
        flower.setBounds(pos.x - Sunflower.SIZE/4, pos.y - Sunflower.SIZE/4, Sunflower.SIZE/4, Sunflower.SIZE/4);
    }

    @Override
    public void checkChange(long lifespan) {
        flower.setFightingPower(2);
        if(lifespan > flower.getGrowthDelay()) {
            flower.transitionTo(flower.getSeedlingState());
        }
    }

    @Override
    public String getName() {
        return NAME;
    }
}