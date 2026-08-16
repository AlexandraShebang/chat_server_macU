import java.awt.Point;

public class Radius {
    double minX;
    double maxX;
    double minY;
    double maxY;

    Radius(Point center, double radius) {
        minX = center.getX() - radius;
        maxX = center.getX() + radius;

        minY = center.getY() - radius;
        maxY = center.getY() + radius;
    }

    //To be completed
    Point getRandomPoint() {
        return new Point(0, 0);
    }
}
