import java.awt.Color;
import java.util.Stack;

public class CarTransport extends Truck{
    private Stack<Car> currentLoad;
    private boolean bedDown;
    
    public CarTransport(){
        super(2,250,0,Color.red,"Transport");
        stopEngine();
        this.currentLoad = new Stack<>();
    }
    public boolean getBedDown(){
        return this.bedDown;
    }
    public Stack<Car> getCurrentLoad(){
        return this.currentLoad;
    }
    public Car unloadCar(){
        if(bedDown){
            return currentLoad.pop();
        }else{
            System.out.println("Bed not down");
            return null;
        }
    }

    public void loadCar(Car car){
        if(this.bedDown && isClose(car)){
            currentLoad.add(car);
        }else{
            System.out.println("Bed is not down or car too far away");
        }
    }

    public boolean isClose(Car car){
        if(Math.abs(this.getX() - car.getX()) < 5  && Math.abs(this.getY() - car.getY()) < 5){
            return true;
        }
        return false;
    }

    public void raiseBed(){
        this.bedDown = false;
    }

    public void lowerBed(){
        if(getCurrentSpeed() == 0){
            this.bedDown = true;
        }
    }

    @Override
    public void move(){
        double deltaX = getCurrentSpeed()  * Math.cos(this.getDir());
        double deltaY = getCurrentSpeed()  * Math.sin(this.getDir());
        double xPos = this.getX() + deltaX;
        double yPos = this.getY() + deltaY;
        this.setX(xPos);
        this.setY(yPos);

        for(Car car:currentLoad){
            car.setX(xPos);
            car.setY(yPos);
        }
    }
    
    @Override
    public double speedFactor(){
        if(bedDown){
            return getEnginePower() * 0.01 * 1;
        }
        return 0;
    }
    

}
