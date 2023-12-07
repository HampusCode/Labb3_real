import javax.swing.*;
import java.awt.event.ActionEvent;


public class CarButtons {
    ButtonFactory buttonFactory = new ButtonFactory();

    JButton gasButton = buttonFactory.createButton("Gas");
    JButton brakeButton = buttonFactory.createButton("Brake");
    JButton turboOnButton = buttonFactory.createButton("Saab Turbo on");
    JButton turboOffButton = buttonFactory.createButton("Saab Turbo off");
    JButton liftBedButton = buttonFactory.createButton("Scania Lift Bed");
    JButton lowerBedButton = buttonFactory.createButton("Lower Lift Bed");
    JButton startButton = buttonFactory.createButton("Start all cars");
    JButton stopButton = buttonFactory.createButton("Stop all cars");

}
