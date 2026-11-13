package growables.plant;

import java.awt.*;

public class SeedState implements PlantState {
    public static final String NAME = "SEED";

    private final Plant plant;

    public SeedState(Plant plant) {
        this.plant = plant;
    }

    @Override
    public void paintComponent(Graphics g) {
        plant.setBackground(new Color(79, 46, 9));
    }

    @Override
    public void checkChange(long lifespan) {
        plant.setFightingPower(2);
        if(lifespan > plant.getGrowthDelay()) {
            plant.transitionTo(plant.getSeedlingState());
        }
    }

    @Override
    public String getName() {
        return NAME;
    }
}