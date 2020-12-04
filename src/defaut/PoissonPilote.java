package defaut;

import java.util.ArrayList;
import java.util.Collection;

public class PoissonPilote extends Thread{

    private Zone[][] zones;
    private Zone actualZone;
    private Requin requin;
    private int nbCycleRestant;

    public PoissonPilote(Zone[][] zones, Zone actualZone) {
        this.zones = zones;
        this.actualZone = actualZone;
        this.nbCycleRestant = 10;
    }
}
