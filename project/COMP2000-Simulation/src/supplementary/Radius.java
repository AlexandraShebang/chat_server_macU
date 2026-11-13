package supplementary;
import java.awt.*;

/**
 * Defines a localized bounding box for spatial spreading.
 */
public class Radius {
    private final int minX;
    private final int maxX;
    private final int minY;
    private final int maxY;

    public Radius(Point center, int radius) {
        minX = (int) center.getX() - radius;
        maxX = (int) center.getX() + radius;

        minY = (int) center.getY() - radius;
        maxY = (int) center.getY() + radius;
    }

    //To be completed
    public Point getRandomPoint() {
        int x = (int) ((Math.random() * (maxX - minX)) + minX);
        int y = (int) ((Math.random() * (maxY - minY)) + minY);
        
        return new Point(x, y);
    }

    public boolean isPointInRadius(Point p) {
        return(p.x >= minX && p.x <= maxX && p.y >= minY && p.y <= maxY);
    }

    public int getMinX() { return minX; }
    public int getMaxX() { return maxX; }
    public int getMinY() { return minY; }
    public int getMaxY() { return maxY; }
}