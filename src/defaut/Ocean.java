package defaut;

import java.util.ArrayList;
import java.util.Collection;

public class Ocean {
    
    private Collection<Zone> zones;
    private static final int NB_ZONE = 4;
    
    public Ocean() {
        this.zones = new ArrayList<Zone>();
        for(int i=0; i<NB_ZONE; i++) {
            for(int y =0; y<NB_ZONE; y++) {
                Zone zone = new Zone(i,y);
                this.zones.add(zone);
            }
        }
    }
    
    
    /* Point d'entree du programme */
    public static void main(String[] args) {

        Ocean ocean = new Ocean();
    }
}
