import java.awt.*;

abstract class Flower extends Plant {
    Flower(Point p, int size) {
        super(p, size);
    }

    abstract void bloom();  //Display the flower blooming
}
