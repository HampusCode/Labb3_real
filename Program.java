import javax.swing.*;

public class Program extends JFrame {


    public static void main(String[] args) {
        // Instance of this class
        LogicPanel controller = new LogicPanel(new DisplayVehicles(), new VehicleView("Car Sim"));

        controller.cars.add(new Volvo240());
        Car saab = new Saab95();
        saab.setY(100.0);
        controller.cars.add(saab);
        Truck scania = new Scania();
        scania.setY(200);
        controller.cars.add(scania);

        // Start a new view and send a reference of self
        //logicPanel.frame = new LogicPanel("CarSim 1.0");

        // Start the timer
        controller.timer.start();
    }


}
