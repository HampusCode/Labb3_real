import javax.swing.*;

public class Program extends JFrame {
    LogicPanel fram = new LogicPanel();

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
        //cc.timer.start();
    }


}
