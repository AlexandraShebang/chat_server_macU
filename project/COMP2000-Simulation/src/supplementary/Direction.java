package supplementary;

import java.util.Random;

/**
 * Represents a 2D vector direction used for entity movement/spreading.
 */
public class Direction {
    private final double x;
    private final double y;

    //These two create a unit vector
    private final double dx;
    private final double dy;

    public Direction(double x, double y) {
        // Bug fix: Math.clamp returns the clamped value, it does not mutate primitives in place.
        // Assuming Java 21+ as per your original code.
        this.x = Math.clamp(x, -20, 20);
        this.y = Math.clamp(y, -20, 20);

        double magnitude = Math.sqrt(this.x * this.x + this.y * this.y);
        
        // Defensive check to avoid division by zero
        if (magnitude == 0) {
            this.dx = 0;
            this.dy = 0;
        } else {
            this.dx = this.x / magnitude;
            this.dy = this.y / magnitude;
        }
    }

    public static Direction getRandomDirection() {
        Random rand = new Random();
        double newDx = 20 * rand.nextDouble();
        double newDy = 20 * rand.nextDouble();

        return new Direction(newDx, newDy);
    }

    public double getX() { return x; }
    public double getY() { return y; }
    public double getDx() { return dx; }
    public double getDy() { return dy; }
}