import java.awt.Color;
import java.awt.Point;

public class Sunflower extends Flower{
    //int size;

    Sunflower(Point position, int size, Window window) {
        super(position, size, window);
        this.size = size;
        this.position = position;
        this.setBackground(Color.yellow);
    }

    /*
    Sunflower(Point position, int spreadRadius, int lifespan) {
        this.position = position;
        this.spreadRadius = spreadRadius;
        this.lifespan = lifespan;
    }
    */

    @Override
    public void bloom() {
        this.setBackground(Color.YELLOW);
        if ((int) (Math.random() * 100) == 0) {
            spread();
        }
    }

    @Override
    public void seedAction() {

    }

    @Override
    public void seedlingAction() {

    }

    @Override
    public void juvenileAction() {

    }

    @Override
    public void deadAction() {

    }

    @Override
    public void spread() {
        Radius radius = new Radius(position, spreadRadius);
        Sunflower[] children = new Sunflower[spreadNum];
        for(int i = 0; i < spreadNum; i++) {
            Point newPoint = radius.getRandomPoint();
            children[i] = new Sunflower(newPoint, size, window);    //Will immediately go out of scope for now
        }
    }
}
