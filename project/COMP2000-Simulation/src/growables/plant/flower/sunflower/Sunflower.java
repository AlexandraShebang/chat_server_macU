package growables.plant.flower.sunflower;

import exceptions.InvalidPositionException;
import exceptions.ObjectLimitExceededException;
import exceptions.OutOfPatchBoundsException;
import growables.plant.flower.Flower;
import java.awt.Point;
import placed_objects.Ground;
import placed_objects.Patch;
import placed_objects.sky.Sky;
import supplementary.Radius;

/**
 * Represents a Sunflower that relies on sunny weather to bloom and spread.
 */
public class Sunflower extends Flower {
    public static final int SIZE = 50;
    
    private int spreadNum = 1;
    private Patch<Sunflower> patch;
    private String environmentState;

    public Sunflower(Point position, Sky sky, Ground ground) {
        super(position, SIZE, sky, ground);
        
        setSeedState(new SunflowerSeedState(this));
        setJuvenileState(new SunflowerJuvenileState(this));
        setAdultState(new SunflowerAdultState(this));
        setBloomState(new SunflowerBloomState(this));

        transitionTo(getSeedState());
        this.environmentState = sky.getState();
    }

    public String getEnvironmentState() { return environmentState; }
    public Patch<Sunflower> getPatch() { return patch; }
    public void setPatch(Patch<Sunflower> patch) { this.patch = patch; }

    @Override
    public void prepareForRemoval() {
        if(patch != null) {
            patch.removeFromPatch(this);
        }
    }

    @Override
    public void bloom() {
        if ((int) (Math.random() * 150) == 0) {
            spread();
        }
    }

    @Override
    public void update(String timeState, int hour) {
        this.environmentState = timeState;
    }

    @Override
    public void increaseSpreadNum(double factor) {
        this.spreadNum = (int) factor * spreadNum;
    }

    @Override
    public void increaseLifespan(double factor) {
        setBloomTime((int)(getBloomTime() * factor));
    }

    @Override
    public void spread() {
        // Assume default spread radius is 100 as per your original design
        Radius radius = new Radius(getPosition(), 100); 
        for(int i = 0; i < spreadNum; i++) {
            Point newPoint = radius.getRandomPoint();
            try {
                Sunflower child = new Sunflower(newPoint, getSky(), getGround());
                getGround().addGrowable(child);
                if(patch != null) {
                    child.givePatch(patch);
                } else {
                    child.checkPatchCreate();
                }
            } catch(InvalidPositionException e) {
                System.out.println("Stopped OOB Sunflower");
            } catch(ObjectLimitExceededException e) {
                System.out.println("Too many objects, cannot add sunflower");
            }
        }
    }

    public void givePatch(Patch<Sunflower> p) {
        try {
            p.addToPatch(this);
            this.patch = p;
        } catch (OutOfPatchBoundsException e) {
            checkPatchCreate();
        }
    }

    public void checkPatchCreate() {
        System.out.println("Chancing");
        if(patch == null && (int) (Math.random() * 10) == 0) {
            System.out.println("Creating patch");
            patch = new Patch<>(100, getPosition());
            getGround().addPatch(patch);
            try {
                patch.addToPatch(this);
            } catch (OutOfPatchBoundsException e) {
                // Ignored if bounds fail immediately on creation
            }
        }
    }

    @Override
    public String toString() {
        return ("Pos: " + getPosition().x + ", " + getPosition().y);
    }
}