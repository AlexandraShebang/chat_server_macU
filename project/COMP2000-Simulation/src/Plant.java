import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;
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
    int growthDelay;         //How long between growth states in milliseconds
    int spreadRadius;     //How far a plant can spread its seeds
    Timer timer;


    Plant(Point p, int size) {
        //These numbers are all arbitrary placeholders for now
        spreadNum = 10;
        spreadRadius = 10;
        growthDelay = 5000;
        timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                grow();
            }
        };

        timer.schedule(task, growthDelay, growthDelay);

        this.position = p;

        this.setBounds(p.x-size/2, p.y-size/2, size, size);
        this.setBackground(Color.darkGray);
    }

    //This is called every iteration of the main loop
    public void tick() {
        switch(growthState) {
            case SEED:
                this.setBackground(new Color(79, 46, 9));
                break;
            case SEEDLING:
                this.setBackground(new Color(2, 184, 9));
                break;
            case JUVENILE:
                this.setBackground(new Color(1, 120, 5));
                break;
            case ADULT:
                this.setBackground(new Color(1, 71, 4));
                break;
            case DEAD:
                this.setBackground(Color.BLACK);
                break;
        }
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