package growables.plant;

import java.awt.*;

public class AdultState implements PlantState {
    public static final String NAME = "ADULT";

    private final Plant plant;

    public AdultState(Plant plant) {
        this.plant = plant;
    }

    @Override
    public void paintComponent(Graphics g) {
        plant.setBackground(new Color(1, 71, 4));
    }

    @Override
    public void checkChange(long lifespan) {
        if(lifespan > plant.getGrowthDelay() * 4) {
            plant.transitionTo(plant.getDeadState());
        }
    }

    @Override
    public String getName() {
        return NAME;
    }
}