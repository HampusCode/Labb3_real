import java.awt.*;

public class Saab95 extends Car{

    private boolean turboOn;

    
    public Saab95(){
        super(2,125,0,Color.red,"Saab95");
        stopEngine();
    }
    


    public void setTurboOn(){
	    turboOn = true;
    }

    public void setTurboOff(){
	    turboOn = false;
    }
    
    @Override
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) {turbo = 1.3;} //1.3
        System.out.println("TURBO IS ON ON ");
        return getEnginePower() * 0.01 * turbo;
    }


}