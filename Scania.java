import java.awt.Color;

public class Scania extends Truck{

    public float angle;

    public Scania(){
        super(2,250,0,Color.white,"Scania");
        this.angle = 0;
        this.changeState(new BedDownState(this));
        stopEngine();
    }

    @Override
    public void lowerBed(){
        if(this.angle < 5){
            this.angle = 0;
            this.changeState(new BedDownState(this));
        }else{
            this.angle -= 5;
        }
    }

    @Override
    public void raiseBed(){
        if(getCurrentSpeed() == 0){
        if(this.angle > 65){
            this.angle = 70;
        }else{
            this.angle += 5;
        }
        }
        this.changeState(new BedUpState(this));
    }

    public float getAngle(){
        return this.angle;
    }

    @Override
    public double speedFactor(){
        return bedState.speedFactor();
    }
    
}
