
import java.awt.event.*;

//This class will control the major actions taken in the simulation

public class Controller { //please clarify what this does - Allie
    public ActionListener taskPerformer = new ActionListener() {
        public void actionPerformed(ActionEvent evt) {

        }
    };

//counts out the number of seconds in a day
    public int timer() { //if you can figure out a better  way to do this please feel free to implement it
        int time = 0;
        for (int i = 0; i < 86400; i++) {
            time++;
        }
        return time;
    }

    public boolean daytime() { //returns true if its day, false if not
        int gethours = timer()/3600; //3600 seconds in an hour
        int dawn = 6; //adjust this if you need to alter the time at which the sun rises
        int dusk = 18; //adjust this if you need to alter the time at which the sun sets
        if (gethours <= dawn && gethours > dusk) {
        } else {
            return true;
        }
        return false;
    }

    public 
}
