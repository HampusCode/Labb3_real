import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class LogicPanel{

    int gasAmount = 0;
    private final int delay = 50;
    private VehicleView view;
    DisplayVehicles model;


    DisplayVehicles displayVehicles = new DisplayVehicles();
    ArrayList<Vehicle> cars =  displayVehicles.vehicles;
    public Timer timer;



    public LogicPanel(DisplayVehicles model, VehicleView view) {
        this.model = model;
        this.view = view;
        timer = new Timer(delay, new TimerListner(displayVehicles.vehicles,view));



        view.getGasButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int gasAmount = view.getGasAmount();
                gas(gasAmount);
            }
        });


        //timer.start();


        // This actionListener is for the gas button only
        // TODO: Create more for each component as necessary



        view.getGasButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gas(gasAmount);
            }
        });

        view.getBreakButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                brake(gasAmount);
            }
        });

        view.getTurboOnButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setTurboOn();
            }
        });

        view.getTurboOffButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setTurboOff();
            }
        });

        view.getLiftBedButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                liftBedButton();
            }
        });

        view.getLowerBedButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lowerBedButton();
            }
        });
        view.getStartButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startButton(gasAmount);
            }
        });

        view.getStopButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stopButton();
            }
        });


    }




    // Calls the gas method for each car once
    public void gas(int amount) {
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
