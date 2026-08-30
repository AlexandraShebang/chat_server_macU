import java.awt.*;


public class Weeds extends Plant{
    int size;

    Weeds(Point position, int size){
        super(position, size);
        this.size = size;
        this.position = position;
        this.setBackground(Color.darkGray);
    }

    @Override

    public void spread(){
        Radius radius = new Radius(position, speadRadius);

        for(int i = 0; o < speadNum; i++){
            Point newPoint = radius.getRandomPoint();
            Weeds child = new Weeds(newPoint, size);
        }
    }

    
}
