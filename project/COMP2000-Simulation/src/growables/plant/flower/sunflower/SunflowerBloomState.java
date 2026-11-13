package growables.plant.flower.sunflower;

import growables.plant.PlantState;
import java.awt.Color;
import java.awt.Graphics;

public class SunflowerBloomState implements PlantState {
    public static final String NAME = "BLOOMING";
    private final Sunflower flower;

    public SunflowerBloomState(Sunflower flower) {
        this.flower = flower;
    }

    @Override
    public void paintComponent(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillOval(0, 0, flower.getBounds().width, flower.getBounds().height);
        g.setColor(new Color(79, 46, 9));
        g.fillOval(flower.getBounds().width/4, flower.getBounds().height/4, flower.getBounds().width/2, flower.getBounds().height/2);
    }

    @Override
    public void checkChange(long lifespan) {
        flower.setFightingPower(5);
        if(lifespan > flower.getGrowthDelay() * flower.getBloomTime()) {
            flower.transitionTo(flower.getDeadState());
        } else if("SUNNY".equals(flower.getEnvironmentState())) {
            flower.bloom();
        } else {
            flower.transitionTo(flower.getAdultState());
        }
    }

    @Override
    public String getName() {
        return NAME;
    }
}