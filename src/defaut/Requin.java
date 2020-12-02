package defaut;

import java.util.ArrayList;
import java.util.Collection;


public class Requin extends Thread{
    
    private int nbCycleRestant;
    private Zone[][] zones;
    private Zone actualZone;
    private int nbZone;
    
    public Requin(Zone[][] zones, Zone actualZone, int nbZone) {
        this.nbCycleRestant = 10;
        this.zones = zones;
        this.actualZone = actualZone;
        this.nbZone = nbZone;
    }
    
    public void run() {
        while(nbCycleRestant > 0) {
            actualZone.sortir();
            Zone nextZone = null;
            int random = (int)(Math.random() * nbZone);
            switch(random) {
            case 0:
                nextZone = leftZone(actualZone);
            case 1 :
                nextZone = rightZone(actualZone);
            case 2:
                nextZone = upperZone(actualZone);
            case 3 :
                nextZone = underZone(actualZone);
            }
            this.actualZone = nextZone;
            this.actualZone.entrer();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.actualZone.sharkEat();;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }            
            nbCycleRestant--;
        }
    }

    private Zone leftZone(Zone zone){
        int x = zone.getX();
        int y = zone.getY();
        if(y == 0) {
            return this.zones[x][nbZone-1];
        }else {
            return this.zones[x][y-1];
        }
    }
    
    private Zone rightZone(Zone zone){
        int x = zone.getX();
        int y = zone.getY();
        if(y == nbZone-1) {
            return this.zones[x][0];
        }else {
            return this.zones[x][y+1];
        }
    }
    
    private Zone upperZone(Zone zone){
        int x = zone.getX();
        int y = zone.getY();
        if(x == 0) {
            return this.zones[nbZone-1][y];
        }else {
            return this.zones[x-1][y];
        }
    }
    
    private Zone underZone(Zone zone){
        int x = zone.getX();
        int y = zone.getY();
        if(x == nbZone-1) {
            return this.zones[0][y];
        }else {
            return this.zones[x-1][y];
        }
    }
}
