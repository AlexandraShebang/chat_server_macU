package growables.plant.flower.sunflower;

import growables.plant.PlantState;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class SunflowerAdultState implements PlantState {
    public static final String NAME = "ADULT";
    private final Sunflower flower;

    public SunflowerAdultState(Sunflower flower) {
        this.flower = flower;
    }

    @Override
    public void paintComponent(Graphics g) {
        g.setColor(new Color(1, 71, 4));
        g.fillOval(0, 0, Sunflower.SIZE, Sunflower.SIZE);
        Point pos = flower.getPosition();
        flower.setBounds(pos.x - Sunflower.SIZE/2, pos.y - Sunflower.SIZE/2, Sunflower.SIZE, Sunflower.SIZE);
    }

    @Override
    public void checkChange(long lifespan) {
        flower.setFightingPower(6);
        if(lifespan > flower.getGrowthDelay() * flower.getBloomTime()) {
            flower.transitionTo(flower.getDeadState());
        } else if("SUNNY".equals(flower.getEnvironmentState())) {
            flower.transitionTo(flower.getBloomState());
        }
    }

    @Override
    public String getName() {
        return NAME;
    }
}