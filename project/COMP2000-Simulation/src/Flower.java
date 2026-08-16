import java.awt.Point;

public class Flower extends Plant {
    Flower(Point position) {
        this.position = position;
    }

    @Override
    Flower[] spread() {
        Radius radius = new Radius(position, spreadRadius);
        Flower[] children = new Flower[spreadNum];
        for(int i = 0; i < spreadNum; i++) {
            Point newPoint = radius.getRandomPoint();
            children[i] = new Flower(newPoint);
        }

        return children;
    }
}
