import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class DisplayVehicles {
    public ArrayList<Vehicle> vehicles = new ArrayList<>();
    public DisplayVehicles() {
        vehicles = new ArrayList<>();
    }

    public void removeVehicle(Vehicle vehicle){
        vehicles.remove(vehicle);
    }
    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }
}
