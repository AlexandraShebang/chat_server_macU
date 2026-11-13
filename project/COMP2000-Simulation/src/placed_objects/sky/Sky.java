package placed_objects.sky;

import java.awt.*;
import java.time.*;
import java.util.ArrayList;
import javax.swing.JPanel;
import supplementary.Window;


public class Sky extends JPanel implements SkySubject {
    private final SkyState sunnyState;
    private final SkyState nightState;
    private SkyState state;

    private final Instant startTime;
    private long dayTime;
    private int hour;    

    private final ArrayList<SkyObserver> observers;

    public Sky() {
        this.sunnyState = new SunnyState(this);
        this.nightState = new NightState(this);
        this.state = sunnyState;

        this.observers = new ArrayList<>();
        this.startTime = Instant.now();
        this.setPreferredSize(new Dimension(Window.WIN_WIDTH, Window.WIN_HEIGHT/4));
    }

    public void tick() {
        dayTime = Duration.between(startTime, Instant.now()).toMillis();
        hour = (int) ((dayTime % 24000));
        state.checkChange();
        revalidate();
        repaint();
    }

    void transitionTo(SkyState next) {
        this.state = next;
        notifyObservers();
    }

    public int getHour() { return hour; }
    public SkyState getSunnyState() { return sunnyState; }
    public SkyState getNightState() { return nightState; }

    public String getState() {
        return state.getName();
    }

    @Override
    public void registerObserver(SkyObserver o) { observers.add(o); }

    @Override
    public void removeObserver(SkyObserver o) { observers.remove(o); }

    @Override
    public void notifyObservers() {
        for(SkyObserver o : observers) {
            o.update(state.getName(), hour);
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        state.paintComponent(g);
    }
}