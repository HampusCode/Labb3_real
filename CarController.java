import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<Vehicle> cars = new ArrayList<>();

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        cc.cars.add(new Volvo240());
        Car saab = new Saab95();
        saab.setY(100.0);
        cc.cars.add(saab);
        Truck scania = new Scania();
        scania.setY(200);
        cc.cars.add(scania);

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }



    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int i = 0;
            for (Vehicle car : cars) {
                int x = (int) Math.round(car.getX());
                int y = (int) Math.round(car.getY());
                if (800 <= x + 100) {
                    car.setDir(Math.toRadians(180));
                }else if(0 >= x){
                    car.setDir(Math.toRadians(0));
                }
                car.move();
                String name = car.getModelName();
                frame.drawPanel.moveit(x, y,cars,i);
                frame.drawPanel.repaint();
                i += 1;
            }
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle car : cars
                ) {
            car.gas(gas);
        }
    }

    void brake(int amount) {
        double b = ((double) amount) / 100;
        for (Vehicle car : cars
                ) {
            car.brake(b);
        }
    }

    void setTurboOn(){
        for(Vehicle car : cars){
            if(car.getModelName().equals("Saab95")){
                ((Saab95)car).setTurboOn();
            }
        }
    }

    void setTurboOff(){
        for(Vehicle car : cars){
            if(car.getModelName().equals("Saab95")){
                ((Saab95)car).setTurboOff();
            }
        }
    }
    void liftBedButton(){
        for(Vehicle car : cars){
            if(car.getModelName().equals("Scania")){
                ((Scania)car).raiseBed();
            }
        }
    }
    void lowerBedButton(){
        for(Vehicle car : cars){
            if(car.getModelName().equals("Scania")){
                ((Scania)car).lowerBed();
            }
        }
    }
    void startButton(int amount){
        double gas = ((double) amount) / 100;
        for (Vehicle car : cars
                ) {
            car.gas(gas);
        }
    }
    void stopButton(){
        for (Vehicle car : cars
                ) {
            car.stopEngine();
        }
    }
}
