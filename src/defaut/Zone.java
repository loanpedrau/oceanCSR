package defaut;

public class Zone {

    private int x;
    private int y;
    private int nbSardines;
    private boolean sharkIsPresent;
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    
    public Zone(int x, int y) {
        this.nbSardines = 5;
        this.x = x;
        this.y = y;
    }
    
    public void setSharkPresent(boolean present) {
        this.sharkIsPresent = present;
    }
    public void SharkEat(){
        if(this.nbSardines > 0){
            this.nbSardines --;
        }
    }
    public synchronized void entrer(){
        while(sharkIsPresent){
            try {
                System.out.println("Le requin : "+Thread.currentThread().getName()+" attends dans la zone ("+this.x+" , "+this.y+")");
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.sharkIsPresent = true;
        this.notifyAll();
        System.out.println(" requin : "+Thread.currentThread().getName()+" est rentré dans la zone ("+this.x+" , "+this.y+")");
    }

    public synchronized void sortir(){
        this.sharkIsPresent = false;
        this.notifyAll();
        System.out.println(" requin : "+Thread.currentThread().getName()+" est sorti de la zone ("+this.x+" , "+this.y+")");

    }
}
