import java.awt.*;


public abstract class Truck extends Vehicle implements Bed{

    
    public Truck(int doors, int ePower, int cSpeed,Color col, String name){
        super(doors,ePower,cSpeed,col,name);
        stopEngine();
    }

    @Override
    public void raiseBed() {
    }


    @Override
    public void lowerBed() {
    }
    

}
