package growables.plant.weed;
import exceptions.InvalidPositionException;
import exceptions.ObjectLimitExceededException;
import growables.plant.Plant;
import java.awt.*;


public class Weeds extends Plant{
    int size;

    Weeds(Point position, Window window){
        super(position, window);
        this.position = position;
        this.setBackground(Color.darkGray);
    }

    @Override

    public void spread(){
        Radius radius = new Radius(position, spreadRadius); //Typo in spread, fixed it - Allie

        for(int i = 0; i < spreadNum; i++){ //your r key might be broken, Sri. Might want to take a look at that. Also int i, not int o - Allie
            Point newPoint = radius.getRandomPoint();
            @SuppressWarnings("unused") //size is an int type that you are trying to call as a Window type. I don't know what this does, so for now I'm supressing this. - Allie
            Weeds child = new Weeds(newPoint, size); //See above, remove line 20 when you've fixed this. 
        }
    }

    @Override 
    public void update(String timeState, int hour){
        environmentState = timeState;
    }

    @Override
    public void increaseSpreadNum(double factor) {
        spreadNum = (int) factor * spreadNum;
    }

    @Override
    public void spread() {
        if(spent) {
            return;
        }

        for(int i = 0; i < spreadNum; i++) {
            double newX = position.x + direction.dx * random.nextInt(15, 20);
            double newY = position.y + direction.dy * random.nextInt(15, 20);
            try {
                Point newPoint = new Point((int) newX, (int) newY);
                Weed child1 = new Weed(newPoint, direction, sky, ground);
                ground.addGrowable(child1);
                //Small chance to create an offshoot vine
                if(random.nextInt(0, 5) == 0) {
                    //Create new weed with random direction
                    Direction newDir = new Direction(random.nextInt(-20, 20), random.nextInt(-20, 20));
                    double startX = position.x + newDir.dx * random.nextInt(15, 20);
                    double startY = position.y + newDir.dy * random.nextInt(15, 20);
                    Point startPoint = new Point((int) startX, (int) startY);
                    Weed child2 = new Weed(startPoint, newDir, sky, ground);
                    ground.addGrowable(child2);
                }
                spent = true;
            } catch(InvalidPositionException p) {
                System.out.println("Stopped OOB Weed");
            } catch(ObjectLimitExceededException e) {
                System.out.println("Too many objects, cannot create weed");
            }
        }
    }

    public String toString() {
        return  ("Pos: " + position.x + ", " + position.y);
    }
}