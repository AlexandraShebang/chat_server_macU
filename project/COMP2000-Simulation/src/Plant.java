import java.awt.Point;

abstract class Plant {
    private static final int SEED = 0;
    private static final int SEEDLING = 1;
    private static final int JUVENILE = 2;
    private static final int ADULT = 3;
    private static final int BLOOMING = 4;
    private static final int DEAD = 5;

    private double spreadRadius;        //How far a plant can spread it's seeds
    private int spreadNum;              //Max number of seeds a plant can produce
    private int growthState;
    private Point position;

    //Progress the lifespan of the plant
    void grow() {
        growthState++;
    }

    //Kill the this plant
    void die() {
        growthState = DEAD;
    }

    public boolean isDead() {
        return growthState == DEAD;
    }

    //To be completed
    //Disperse seeds around this plant
    void spread() {
        Radius range = new Radius(position, spreadRadius);
        Math.random();
    }

    Point getPosition() {
        return position;
    }

    public String toString() {
        return "Replace this function";
    }
}