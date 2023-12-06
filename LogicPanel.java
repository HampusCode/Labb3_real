import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LogicPanel extends JFrame{
    private static final int X = 800;
    private static final int Y = 800;

    // The controller member
    DisplayVehicles displayVehicles = new DisplayVehicles();

    DrawPanel drawPanel = new DrawPanel(X, Y-240);

    JPanel controlPanel = new JPanel();

    JPanel gasPanel = new JPanel();
    JSpinner gasSpinner = new JSpinner();
    int gasAmount = 0;
    JLabel gasLabel = new JLabel("Amount of gas");
    private final int delay = 50;
    private Timer timer = new Timer(delay, new TimerListner(displayVehicles.vehicles,this));

}
