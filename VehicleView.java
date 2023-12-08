import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.util.ArrayList;

public class VehicleView extends JFrame{
    private static final int X = 800;
    private static final int Y = 800;
    public DrawPanel drawPanel = new DrawPanel(X, Y-240);
    public CarButtons carB = new CarButtons();
    JPanel controlPanel = new JPanel();
    JPanel gasPanel = new JPanel();
    JSpinner gasSpinner = new JSpinner();
    JLabel gasLabel = new JLabel("Amount of gas");
    int gasAmount = 0;

    public VehicleView(String title){
        initComponents(title);
    }

    private void initComponents(String title) {

        this.setTitle(title);
        this.setPreferredSize(new Dimension(X, Y));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        this.add(drawPanel);


        SpinnerModel spinnerModel =
                new SpinnerNumberModel(0, //initial value
                        0, //min
                        100, //max
                        1);//step
        gasSpinner = new JSpinner(spinnerModel);
        gasSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                gasAmount = (int) ((JSpinner) e.getSource()).getValue();
            }
        });

        gasPanel.setLayout(new BorderLayout());
        gasPanel.add(gasLabel, BorderLayout.PAGE_START);
        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);

        this.add(gasPanel);

        controlPanel.setLayout(new GridLayout(2, 4));

        controlPanel.add(carB.gasButton, 0);
        controlPanel.add(carB.turboOnButton, 1);
        controlPanel.add(carB.liftBedButton, 2);
        controlPanel.add(carB.brakeButton, 3);
        controlPanel.add(carB.turboOffButton, 4);
        controlPanel.add(carB.lowerBedButton, 5);
        controlPanel.add(carB.addCar);
        controlPanel.add(carB.removeCar);
        controlPanel.setPreferredSize(new Dimension((X / 2) + 4, 200));
        this.add(controlPanel);
        controlPanel.setBackground(Color.CYAN);


        carB.startButton.setBackground(Color.blue);
        carB.startButton.setForeground(Color.green);
        carB.startButton.setPreferredSize(new Dimension(X / 5 - 15, 200));
        this.add(carB.startButton);


        carB.stopButton.setBackground(Color.red);
        carB.stopButton.setForeground(Color.black);
        carB.stopButton.setPreferredSize(new Dimension(X / 5 - 15, 200));
        this.add(carB.stopButton);
        // Make the frame pack all it's components by respecting the sizes if possible.
        this.pack();

        // Get the computer screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Center the frame
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        // Make the frame visible
        this.setVisible(true);
        // Make sure the frame exits when "x" is pressed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }



    public JButton getRemoveCarButton(){
        return carB.removeCar;
    }
    public JButton getAddCarButton(){
        return carB.addCar;
    }
    public JButton getGasButton(){
        return carB.gasButton;
    }
    public JButton getBreakButton(){
        return carB.brakeButton;
    }
    public JButton getTurboOnButton(){
        return carB.turboOnButton;
    }
    public JButton getTurboOffButton(){
        return carB.turboOffButton;
    }
    public JButton getLiftBedButton(){
        return carB.liftBedButton;
    }
    public JButton getLowerBedButton(){
        return carB.lowerBedButton;
    }
    public JButton getStartButton(){
        return carB.startButton;
    }
    public JButton getStopButton(){
        return carB.stopButton;
    }
    public int getGasAmount(){
        return gasAmount;
    }

}
