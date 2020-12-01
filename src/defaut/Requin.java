package defaut;

import java.util.ArrayList;
import java.util.Collection;

public class Requin extends Thread{
    
    private int nbCycleRestant;
    private Collection<Zone> zones;
    private Zone actualZone;
    
    public Requin(ArrayList<Zone> zones, Zone actualZone) {
        this.nbCycleRestant = 10;
        this.zones = zones;
        this.actualZone = actualZone;
    }

}
