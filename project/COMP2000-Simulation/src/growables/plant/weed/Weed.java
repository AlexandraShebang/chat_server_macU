package growables.plant.weed;

import exceptions.InvalidPositionException;
import exceptions.ObjectLimitExceededException;
import growables.plant.Plant;
import java.awt.Color;
import java.awt.Point;
import java.util.Random;
import javax.swing.BorderFactory;
import placed_objects.Ground;
import placed_objects.sky.Sky;
import supplementary.Direction;
import supplementary.Window;

/**
 * Represents an aggressive weed that spreads quickly.
 */
public class Weed extends Plant {
    private static final int GROWTH_DELAY = 1000;
    private static final int WEED_SIZE = 10;
    
    private int spreadNum = 1;
    private String environmentState;
    private boolean spent = false;
    private Direction direction;
    private final Random random;

    public Weed(Point position, Sky sky, Ground ground) {
        super(position, WEED_SIZE, sky, ground);
        setAdultState(new WeedAdultState(this));
        setGrowthDelay(GROWTH_DELAY);

        this.environmentState = sky.getState();
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.random = new Random();
        this.direction = new Direction(random.nextInt(-20, 20), random.nextInt(-20, 20));
    }

    Weed(Point position, Direction direction, Sky sky, Ground ground) {
        this(position, sky, ground);
        if(position.x > Window.WIN_WIDTH || position.x < 0 || position.y < 0 || position.y > Window.WIN_HEIGHT/4*3) {
            throw new InvalidPositionException("Position: " + position.x + ", " + position.y);
        }
        this.direction = direction;
    }

    /** 
     * Supplies a random multiplier specifically used by Weed states to dictate lifecycle variants.
     */
    public int getRandomMultiplier() {
        return random.nextInt(0, 20);
    }

    @Override 
    public void update(String timeState, int hour){
        this.environmentState = timeState;
    }

    @Override
    public void increaseSpreadNum(double factor) {
        this.spreadNum = (int) factor * spreadNum;
    }

    @Override
    public void spread() {
        if(spent) {
            return;
        }

        Point pos = getPosition();
        for(int i = 0; i < spreadNum; i++) {
            // Replaced direct field access (.dx/.dy) with getter methods (.getDx()/.getDy())
            double newX = pos.x + direction.getDx() * random.nextInt(15, 20);
            double newY = pos.y + direction.getDy() * random.nextInt(15, 20);
            try {
                Point newPoint = new Point((int) newX, (int) newY);
                Weed child1 = new Weed(newPoint, direction, getSky(), getGround());
                getGround().addGrowable(child1);
                
                if(random.nextInt(0, 5) == 0) {
                    Direction newDir = new Direction(random.nextInt(-20, 20), random.nextInt(-20, 20));
                    // Replaced direct field access here as well
                    double startX = pos.x + newDir.getDx() * random.nextInt(15, 20);
                    double startY = pos.y + newDir.getDy() * random.nextInt(15, 20);
                    Weed child2 = new Weed(new Point((int) startX, (int) startY), newDir, getSky(), getGround());
                    getGround().addGrowable(child2);
                }
                spent = true;
            } catch(InvalidPositionException p) {
                System.out.println("Stopped OOB Weed");
            } catch(ObjectLimitExceededException e) {
                System.out.println("Too many objects, cannot create weed");
            }
        }
    }
    
    @Override
    public String toString() {
        return ("Pos: " + getPosition().x + ", " + getPosition().y);
    }
}