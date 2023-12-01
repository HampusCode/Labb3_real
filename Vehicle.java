import java.awt.*;


public abstract class Vehicle implements Movable{

    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name
    private double posX;
    private double posY;
    private double dir;


    public Vehicle(int door, double ePower, double cSpeed, Color col, String mName){
        this.nrDoors = door;
        this.enginePower = ePower;
        this.currentSpeed = cSpeed;
        this.color = col;
        this.modelName = mName;

        this.posX = 0;
        this.posY = 0;
        this.dir = 0;
    }

    
    public double getDir(){
        return this.dir;
    }

    public double getX(){
        return this.posX;
    }

    public double getY(){
        return this.posY;
    }

    public void setX(double x){
        this.posX = x;
    }

    public void setY(double y){
        this.posY = y;
    }

    public String getModelName(){
        return modelName;
    }
    public void incrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
        if(currentSpeed > enginePower){
            currentSpeed = enginePower;
        }
    }

    public void decrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() - speedFactor() * amount;
        if(currentSpeed < 0){
            currentSpeed = 0;
        }
    }

    public abstract double speedFactor();

    public void gas(double amount){
        if(amount >= 0 && amount <= 1){
            incrementSpeed(amount);
        }
    }

    public void brake(double amount){
        if(amount >= 0 && amount <= 1){
            decrementSpeed(amount);
        }
    }
    public int getNrDoors(){
        return nrDoors;
    }
    public double getEnginePower(){
        return enginePower;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color clr){
        color = clr;
    }

    public void startEngine(){
        currentSpeed = 0.1;
    }

    public void stopEngine(){
        currentSpeed = 0;
    }

    public void move(){
        double deltaX = currentSpeed * Math.cos(dir);
        double deltaY = currentSpeed * Math.sin(dir);
        posX += deltaX;
        posY += deltaY;
    }

    public void turnLeft(){
        dir -= 10;
    }

    public void turnRight(){
        dir += 10;
    }


}
