import javax.swing.*;

public class Program extends JFrame {


    public static void main(String[] args) {
        // Instance of this class
        LogicPanel logicPanel = new LogicPanel("CarSim 1.0");

        logicPanel.cars.add(new Volvo240());
        Car saab = new Saab95();
        saab.setY(100.0);
        logicPanel.cars.add(saab);
        Truck scania = new Scania();
        scania.setY(200);
        logicPanel.cars.add(scania);

        // Start a new view and send a reference of self
        //logicPanel.frame = new LogicPanel("CarSim 1.0");

        // Start the timer
        logicPanel.timer.start();
    }


}
