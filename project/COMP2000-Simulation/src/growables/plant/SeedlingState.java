package growables.plant;

import java.awt.*;

public class SeedlingState implements PlantState {
    public static final String NAME = "SEEDLING";

    private final Plant plant;

    public SeedlingState(Plant plant) {
        this.plant = plant;
    }

    @Override
    public void paintComponent(Graphics g) {
        plant.setBackground(new Color(2, 184, 9));
        g.setColor(new Color(2, 184, 9));
        g.fillOval(0, 0, plant.getBounds().width, plant.getBounds().height);
    }

    @Override
    public void checkChange(long lifespan) {
        plant.setFightingPower(3);
        if (lifespan > plant.getGrowthDelay() * 2) {
            plant.transitionTo(plant.getJuvenileState());
        }
    }

    @Override
    public String getName() {
        return NAME;
    }
}