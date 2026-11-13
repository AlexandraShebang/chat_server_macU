package growables.plant;
import exceptions.InvalidPositionException;
import growables.Growable;
import java.awt.*;
import java.time.*;
import java.util.ArrayList;
import java.util.Objects;
import javax.swing.*;
import placed_objects.Ground;
import placed_objects.sky.Sky;
import placed_objects.sky.SkyObserver;
import supplementary.Window;

/**
 * Represents a basic plant entity in the ecosystem.
 */
public abstract class Plant extends JPanel implements Growable, SkyObserver {
    public static final int MAX_SIZE = 150;

    private PlantState seedState;
    private PlantState seedlingState;
    private PlantState juvenileState;
    private PlantState adultState;
    private PlantState deadState;

    private PlantState state;
    
    private final Instant startTime;
    private int size = 60;
    private Point position;
    private final Sky sky;
    private final Ground ground;

    private int growthDelay = 5000;
    private int spreadRadius;
    private int fightingPower = 5;
    private boolean fighting = false;

    public Plant(Point p, int size, Sky sky, Ground ground) {
        this.seedState = new SeedState(this);
        this.seedlingState = new SeedlingState(this);
        this.juvenileState = new JuvenileState(this);
        this.adultState = new AdultState(this);
        this.deadState = new DeadState(this);

        this.state = seedState;
        this.sky = sky;
        this.ground = ground;
        this.startTime = Instant.now();
        this.spreadRadius = 100;
        
        if (p == null) {
            throw new InvalidPositionException("Position is null");
        } else if (p.x > Window.WIN_WIDTH || p.x < 0 || p.y < 0 || p.y > Window.WIN_HEIGHT/4*3) {
            throw new InvalidPositionException("Position: " + p.x + ", " + p.y);
        }

        this.position = new Point(p);
        this.size = Math.min(Math.max(size, 0), MAX_SIZE);
        this.setBounds(position.x, position.y, this.size, this.size);
        this.setBackground(Color.darkGray);
        sky.registerObserver(this);
    }

    /**
     * Safely transitions the plant to a new state.
     * Made public to allow State classes in sub-packages to trigger transitions.
     * 
     * @param next the PlantState to transition to
     */
    public void transitionTo(PlantState next) {
        this.state = Objects.requireNonNull(next, "Target state cannot be null");
    }

    /**
     * Grows the plant by a specified delta, clamped to MAX_SIZE.
     * 
     * @param delta the amount to grow by
     */
    protected void grow(int delta) {
        this.size = Math.max(0, Math.min(this.size + delta, MAX_SIZE));
        this.setBounds(position.x, position.y, this.size, this.size);
    }

    @Override
    public Point getPosition() {
        return new Point(position);
    }

    public PlantState getSeedState() { return seedState; }
    protected void setSeedState(PlantState s) { this.seedState = s; }
    
    public PlantState getSeedlingState() { return seedlingState; }
    protected void setSeedlingState(PlantState s) { this.seedlingState = s; }
    
    public PlantState getJuvenileState() { return juvenileState; }
    protected void setJuvenileState(PlantState s) { this.juvenileState = s; }
    
    public PlantState getAdultState() { return adultState; }
    protected void setAdultState(PlantState s) { this.adultState = s; }
    
    public PlantState getDeadState() { return deadState; }
    protected void setDeadState(PlantState s) { this.deadState = s; }

    public int getGrowthDelay() { return growthDelay; }
    protected void setGrowthDelay(int delay) { this.growthDelay = delay; }
    
    public Sky getSky() { return sky; }
    public Ground getGround() { return ground; }

    @Override
    public int getFightingPower() { return fightingPower; }
    public void setFightingPower(int power) { this.fightingPower = power; }

    @Override
    public boolean getFighting() { return fighting; }
    
    @Override
    public void setFighting(boolean fighting) { this.fighting = fighting; }

    @Override
    public String getState() { return state.getName(); }

    @Override
    public Rectangle getHitbox() { return this.getBounds(); }

    @Override
    public Growable isColliding() {
        ArrayList<Growable> growables = ground.getGrowables();
        for(Growable g : growables) {
            if(g != this && this.getHitbox().intersects(g.getHitbox())) {
                return g;
            }
        }
        return null;
    }

    @Override
    public void prepareForRemoval() {}

    @Override
    public void fightAgainst(Growable opponent) {
        setFighting(true);
        opponent.setFighting(true);
        int opponentPower = opponent.getFightingPower();
        int outcome = getFightingPower() - opponentPower;
        double victoryChance = 0.5 + 0.1 * outcome;
        if(Math.random() <= victoryChance) {
            opponent.loseFight();
            setFighting(false);
        } else {
            loseFight();
            opponent.setFighting(false);
        }
    }

    @Override
    public void loseFight() {
        transitionTo(deadState);
    }

    public boolean isColliding(Growable g) {
        return this.getHitbox().intersects(g.getHitbox());
    }

    @Override
    public void tick() {
        Growable g = isColliding();
        if(g != null && !getFighting() && !g.getFighting()) {
          fightAgainst(g);  
        }

        Instant now = Instant.now();
        long lifespan = (Duration.between(startTime, now)).toMillis();

        state.checkChange(lifespan);
        revalidate();
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        state.paintComponent(g);
    }

    @Override
    public void increaseLifespan(double factor) {
        growthDelay *= factor;
    }

    public void delete() {
        ground.delete(this);
        ground.revalidate();
        ground.repaint();
    }

    @Override
    public String toString() { return "Plant at " + position.x + ", " + position.y; }
}