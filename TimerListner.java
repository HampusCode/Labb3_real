import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TimerListner implements ActionListener {
    VehicleView view;
    ArrayList<Vehicle> cars = new ArrayList<>();

    public TimerListner(ArrayList<Vehicle> cars, VehicleView view){
        this.cars = cars;
        this.view = view;
    }
    public void actionPerformed(ActionEvent e) {

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
            view.drawPanel.moveit(x, y,name);
            view.drawPanel.repaint();
        }
    }
}