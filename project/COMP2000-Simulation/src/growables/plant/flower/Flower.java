package growables.plant.flower;

import growables.plant.*;
import java.awt.*;
import placed_objects.Ground;
import placed_objects.sky.Sky;


public abstract class Flower extends Plant {
    private PlantState bloomState;
    private int bloomTime = 6;

    public Flower(Point p, int size, Sky sky, Ground ground) {
        super(p, size, sky, ground);
        this.bloomState = new BloomState(this);
    }

    public PlantState getBloomState() { return bloomState; }
    protected void setBloomState(PlantState bloomState) { this.bloomState = bloomState; }
    
    public int getBloomTime() { return bloomTime; }
    public void setBloomTime(int bloomTime) { this.bloomTime = bloomTime; }

    public void bloom() {
        this.setBackground(Color.RED);
        if ((int) (Math.random() * 100) == 0) {
            spread();
        }
    }
}