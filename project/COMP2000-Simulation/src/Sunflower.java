import java.awt.Point;

public class Sunflower extends Flower{

    Sunflower(Point position) {
        this.position = position;
    }

    Sunflower(Point position, int spreadRadius, int lifespan) {
        this.position = position;
        this.spreadRadius = spreadRadius;
        this.lifespan = lifespan;
    }

    @Override
    public void bloom() {

    }

    @Override
    public void spread() {
        Radius radius = new Radius(position, spreadRadius);
        Sunflower[] children = new Sunflower[spreadNum];
        for(int i = 0; i < spreadNum; i++) {
            Point newPoint = radius.getRandomPoint();
            children[i] = new Sunflower(newPoint);    //Will immediately go out of scope for now
        }
    }
}
