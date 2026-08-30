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
    int size;
    Point position;

    int spreadNum;        //Max number of seeds a plant can produce
    int growthDelay;      //How long between growth states in milliseconds
    int spreadRadius;     //How far a plant can spread its seeds
    Window window;
    Timer timer;

    Plant(Point p, int size, Window window) {
        //These numbers are all arbitrary placeholders for now
        this.window = window;
        this.size = size;
        spreadNum = 2;
        spreadRadius = 100;
        growthDelay = 5000;
        timer = new Timer();
        TimerTask grow = new TimerTask() {
            @Override
            public void run() {
                grow();
            }
        };

        TimerTask tick = new TimerTask() {
            @Override
            public void run() {
                tick();
            }
        };

        timer.schedule(grow, growthDelay, growthDelay);
        timer.schedule(tick, 25, 25);

        this.position = p;

        this.setBounds(p.x-size/8, p.y-size/8, size/4, size/4);
        this.setBackground(Color.darkGray);
        window.addToGround(this, null);
    }

    //This is called every iteration of the main loop
    public void tick() {
        switch(growthState) {
            case SEED:
                this.setBackground(new Color(79, 46, 9));
                seedAction();
                break;
            case SEEDLING:
                this.setBackground(new Color(2, 184, 9));
                seedlingAction();
                break;
            case JUVENILE:
                this.setBounds(position.x-size/4, position.y-size/4, size/2, size/2);
                this.setBackground(new Color(1, 120, 5));
                juvenileAction();
                break;
            case ADULT:
                this.setBounds(position.x-size/2, position.y-size/2, size, size);
                this.setBackground(new Color(1, 71, 4));
                adultAction();
                break;
            case DEAD:
                this.setBackground(Color.BLACK);
                deadAction();
                break;
        }
    }

    //Progress the lifespan of the plant
    public void grow() {
        if (growthState < DEAD){
            growthState++;
        }
    }

    abstract void seedAction();
    abstract void seedlingAction();
    abstract void juvenileAction();
    abstract void adultAction();
    abstract void deadAction();

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