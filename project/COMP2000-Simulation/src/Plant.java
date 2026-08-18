import java.awt.Point;

abstract class Plant implements Growable {
    static final int SEED = 0;
    static final int SEEDLING = 1;
    static final int JUVENILE = 2;
    static final int ADULT = 3;
    static final int DEAD = 4;
    
    int growthState;
    Point position;

    int spreadNum;        //Max number of seeds a plant can produce
    int lifespan;
    int spreadRadius;     //How far a plant can spread its seeds

    Plant() {
        //These numbers are all arbitrary placeholders for now
        spreadNum = 10;
        spreadRadius = 10;
        lifespan = 10;
    }

    //Progress the lifespan of the plant
    public void grow() {
        growthState++;
        Math.clamp(growthState, SEED, DEAD);
    }

    //Kill the this plant
    public void die() {
        growthState = DEAD;
    }

    public boolean isDead() {
        return growthState == DEAD;
    }

    Point getPosition() {
        return position;
    }

    public String toString() {
        return "Replace this function";
    }
}