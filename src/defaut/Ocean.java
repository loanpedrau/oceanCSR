package defaut;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class Ocean {
    
    private static Zone[][] zones;
    private ArrayList<Requin> requins;
    private static final int NB_ZONE = 4;
    
    public Ocean() {
        Random random = new Random();
        this.zones = new Zone[NB_ZONE][NB_ZONE];
        this.requins = new ArrayList<Requin>();
        for(int i=0; i<NB_ZONE; i++) {
            for(int y =0; y<NB_ZONE; y++) {
                Zone zone = new Zone(i,y);
                this.zones[i][y] = zone;
            }
        }
        for(int i=0; i<NB_ZONE; i++) {
            for(int y =0; y<NB_ZONE; y++) {
                if(random.nextBoolean()) {
                    int xRandom = (int)(Math.random() * NB_ZONE);
                    int yRandom = (int)(Math.random() * NB_ZONE);
                    Zone actualZone = this.zones[xRandom][yRandom];
                    this.requins.add(new Requin(this.zones, actualZone, NB_ZONE));
                    actualZone.setSharkPresent(true);
                }
            }
        }
        for(int i=0; i< this.requins.size(); i++) {
            this.requins.get(i).start();
        }
        
    }
    
    
    /* Point d'entree du programme */
    public static void main(String[] args) {

        Ocean ocean = new Ocean();
    }
}
