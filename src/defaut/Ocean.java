package defaut;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class Ocean {
    
    private static Zone[][] zones;
    private ArrayList<Requin> requins;
    private ArrayList<PoissonPilote> poissonsPilotes;
    private static final int NB_ZONE = 4;
    
    public Ocean() {
        Random random = new Random();
        this.zones = new Zone[NB_ZONE][NB_ZONE];
        this.requins = new ArrayList<Requin>();
        this.poissonsPilotes = new ArrayList<PoissonPilote>();
        for(int i=0; i<NB_ZONE; i++) {
            for(int y =0; y<NB_ZONE; y++) {
                Zone zone = new Zone(i,y);
                this.zones[i][y] = zone;
            }
        }
        for(int i=0; i<NB_ZONE; i++) {
            for(int y =0; y<NB_ZONE; y++) {
                if(random.nextBoolean()) {
                    Zone actualZone = this.zones[i][y];
                    Requin requin =  new Requin(this.zones, actualZone, NB_ZONE);
                    this.requins.add(requin);
                    actualZone.setSharkPresent(true);
                    actualZone.setRequin(requin);
                }
            }
        }
        for(int i =0; i<5; i++) {
            
            PoissonPilote poissonPilote = new PoissonPilote(this.zones, this.zones[1][1]);
            poissonsPilotes.add(poissonPilote);
            
        }
        for(int i=0; i< this.poissonsPilotes.size(); i++) {
            this.poissonsPilotes.get(i).start();
        }
        for(int i=0; i< this.requins.size(); i++) {
            this.requins.get(i).start();
        }
        for(int i=0; i< this.poissonsPilotes.size(); i++) {
            try {
                this.poissonsPilotes.get(i).join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for(int i=0; i< this.requins.size(); i++) {
            try {
                this.requins.get(i).join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    
    /* Point d'entree du programme */
    public static void main(String[] args) {
        Ocean ocean = new Ocean();
    }
}
