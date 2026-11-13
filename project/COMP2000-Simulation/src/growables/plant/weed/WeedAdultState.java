package growables.plant.weed;

import growables.plant.PlantState;
import java.awt.Graphics;

public class WeedAdultState implements PlantState {
    public static final String NAME = "ADULT";
    private final Weed weed;

    public WeedAdultState(Weed weed) {
        this.weed = weed;
    }

    @Override
    public void checkChange(long lifespan) {
        weed.setFightingPower(5);
        weed.spread();
        // Uses the new getRandomMultiplier() to replace direct weed.random field access
        if (lifespan > 20000 + (weed.getRandomMultiplier() * 1000)) {
            weed.transitionTo(weed.getDeadState());
        }
    }

    @Override
    public void paintComponent(Graphics g) {
    }

    @Override
    public String getName() {
        return NAME;
    }
}