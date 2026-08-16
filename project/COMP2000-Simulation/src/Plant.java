import java.awt.Point;

abstract class Plant {
    static final int SEED = 0;
    static final int SEEDLING = 1;
    static final int JUVENILE = 2;
    static final int ADULT = 3;
    static final int BLOOMING = 4;
    static final int DEAD = 5;

    int spreadRadius;        //How far a plant can spread it's seeds
    int spreadNum;              //Max number of seeds a plant can produce
    int growthState;
    Point position;

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

    //Disperse seeds around this plant
    abstract Plant[] spread();

    Point getPosition() {
        return position;
    }

    public String toString() {
        return "Replace this function";
    }
}