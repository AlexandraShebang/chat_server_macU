package growables.plant;

import java.awt.*;

public class JuvenileState implements PlantState {
    public static final String NAME = "JUVENILE";

    private final Plant plant;

    public JuvenileState(Plant plant) {
        this.plant = plant;
    }

    @Override
    public void paintComponent(Graphics g) {
        plant.setBackground(new Color(1, 120, 5));
    }

    @Override
    public void checkChange(long lifespan) {
        plant.setFightingPower(4);
        if(lifespan > plant.getGrowthDelay() * 3) {
            plant.transitionTo(plant.getAdultState());
        }
    }

    @Override
    public String getName() {
        return NAME;
    }
}