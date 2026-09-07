
import java.awt.event.*;

//This class will control the major actions taken in the simulation

public class Controller {
    public ActionListener taskPerformer = new ActionListener() {
        public void actionPerformed(ActionEvent evt) {

        }
    };
    public int timer() { //thought this could be useful to keep track of time across the simulation
        int t = 24; //seperate value so it is easier when adjusting the rate at which time passes 
        int hours = 0;
        for (int i = 0; i < t; i++) {
            hours++;
        }
        return hours;
    }

    public boolean daytime() { //returns true if its day, false if not
        int gethours = timer();
        int dawn = 6; //adjust this if you need to alter the time at which the sun rises
        int dusk = 18; //adjust this if you need to alter the time at which the sun sets
        if (gethours <= dawn && gethours > dusk) {
        } else {
            return true;
        }
        return false;
    }
}
