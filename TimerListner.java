import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TimerListner implements ActionListener {
    LogicPanel frame;
    ArrayList<Vehicle> cars = new ArrayList<>();
    public TimerListner(ArrayList<Vehicle> cars, LogicPanel frame){
        this.cars = cars;
        this.frame = frame;
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
            frame.drawPanel.moveit(x, y,name);
            frame.drawPanel.repaint();
        }
    }
}