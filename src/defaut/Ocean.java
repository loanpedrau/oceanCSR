package defaut;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class Ocean {
    
    private ArrayList<Zone> zones;
    private ArrayList<Requin> requins;
    private static final int NB_ZONE = 4;
    
    public Ocean() {
        Random random = new Random();
        this.zones = new ArrayList<Zone>();
        this.requins = new ArrayList<Requin>();
        for(int i=0; i<NB_ZONE; i++) {
            for(int y =0; y<NB_ZONE; y++) {
                Zone zone = new Zone(i,y);
                this.zones.add(zone);
            }
        }
        for(int i=0; i<NB_ZONE; i++) {
            for(int y =0; y<NB_ZONE; y++) {
                if(random.nextBoolean()) {
                    int randomZone = (int)(Math.random() * (NB_ZONE*NB_ZONE));
                    Zone actualZone = this.zones.get(randomZone);
                    this.requins.add(new Requin(this.zones, actualZone));
                    actualZone.setSharkPresent(true);
                }
            }
        }
    }
    
    
    /* Point d'entree du programme */
    public static void main(String[] args) {

        Ocean ocean = new Ocean();
    }
}
