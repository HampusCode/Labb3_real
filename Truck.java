import java.awt.*;


public abstract class Truck extends Vehicle implements Bed{

    BedState bedState;
    
    public Truck(int doors, int ePower, int cSpeed,Color col, String name){
        super(doors,ePower,cSpeed,col,name);
        stopEngine();
    }

    public void changeState(BedState state){
        this.bedState = state;
    }

    @Override
    public void raiseBed() {
    }


    @Override
    public void lowerBed() {
    }
    

}
