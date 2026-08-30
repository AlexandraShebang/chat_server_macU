import java.awt.Color;
import java.awt.Point;

public class Sunflower extends Flower{
    //int size;

    Sunflower(Point position, Window window) {
        super(position, window);
        this.position = position;

        //Check if very close to another plant. If so, immediately die.
        //TODO
    }

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
            children[i] = new Sunflower(newPoint, window);    //Will immediately go out of scope for now
        }
    }
}
