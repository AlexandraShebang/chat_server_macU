//Could reuse this interface to add mushrooms, for example

public interface Growable {
    abstract void spread();     //Different things spread in different ways, e.g. wind, bees, spores
    abstract void grow();
    abstract void die();
}
