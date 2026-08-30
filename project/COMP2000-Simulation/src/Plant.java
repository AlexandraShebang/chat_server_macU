import java.awt.*;
import javax.swing.*;

abstract class Plant extends JPanel implements Growable {
    static final int SEED = 0;
    static final int SEEDLING = 1;
    static final int JUVENILE = 2;
    static final int ADULT = 3;
    static final int DEAD = 4;
    
    int growthState = SEED;
    Point position;

    int spreadNum;        //Max number of seeds a plant can produce
    int lifespan;         //How long a plant lives in seconds
    int spreadRadius;     //How far a plant can spread its seeds
    long startTime;       //When a plant was created

    Plant(Point p, int size) {
        //These numbers are all arbitrary placeholders for now
        spreadNum = 10;
        spreadRadius = 10;
        lifespan = 10;
        startTime = System.nanoTime();

        this.position = p;

        this.setBounds(p.x-size/2, p.y-size/2, size, size);
        this.setBackground(Color.darkGray);
    }

    //This is called every iteration of the main loop
    public void tick() {
        //grow();
        position.x+=10;
        this.setLocation(position.x, position.y);
    }

    //Progress the lifespan of the plant
    public void grow() {
        if (growthState < DEAD){
            growthState++;
        }
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