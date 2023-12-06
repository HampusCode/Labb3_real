import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class LogicPanel extends JFrame{
    private static final int X = 800;
    private static final int Y = 800;
    int gasAmount = 0;
    private final int delay = 50;


    DisplayVehicles displayVehicles = new DisplayVehicles();
    ArrayList<Vehicle> cars =  displayVehicles.vehicles;
    CarButtons carB = new CarButtons();

    public Timer timer = new Timer(delay, new TimerListner(displayVehicles.vehicles,this));

    DrawPanel drawPanel = new DrawPanel(X, Y-240);
    JPanel controlPanel = new JPanel();
    JPanel gasPanel = new JPanel();
    JSpinner gasSpinner = new JSpinner();
    JLabel gasLabel = new JLabel("Amount of gas");

    public LogicPanel(String framename){
        initComponents(framename);
    }
    private void initComponents(String title) {

        this.setTitle(title);
        this.setPreferredSize(new Dimension(X,Y));
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
                gasAmount = (int) ((JSpinner)e.getSource()).getValue();
            }
        });

        gasPanel.setLayout(new BorderLayout());
        gasPanel.add(gasLabel, BorderLayout.PAGE_START);
        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);

        this.add(gasPanel);

        controlPanel.setLayout(new GridLayout(2,4));

        controlPanel.add(carB.gasButton, 0);
        controlPanel.add(carB.turboOnButton, 1);
        controlPanel.add(carB.liftBedButton, 2);
        controlPanel.add(carB.brakeButton, 3);
        controlPanel.add(carB.turboOffButton, 4);
        controlPanel.add(carB.lowerBedButton, 5);
        controlPanel.setPreferredSize(new Dimension((X/2)+4, 200));
        this.add(controlPanel);
        controlPanel.setBackground(Color.CYAN);


        carB.startButton.setBackground(Color.blue);
        carB.startButton.setForeground(Color.green);
        carB.startButton.setPreferredSize(new Dimension(X/5-15,200));
        this.add(carB.startButton);


        carB.stopButton.setBackground(Color.red);
        carB.stopButton.setForeground(Color.black);
        carB.stopButton.setPreferredSize(new Dimension(X/5-15,200));
        this.add(carB.stopButton);

        // This actionListener is for the gas button only
        // TODO: Create more for each component as necessary


        //DETTA NEDAN BÖR VARA I CARBUTTONS CLASESESN!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        //DETTA NEDAN BÖR VARA I CARBUTTONS CLASESESN!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        //DETTA NEDAN BÖR VARA I CARBUTTONS CLASESESN!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        //DETTA NEDAN BÖR VARA I CARBUTTONS CLASESESN!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        carB.gasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gas(gasAmount);
            }
        });

        carB.brakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                brake(gasAmount);
            }
        });

        carB.turboOnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setTurboOn();
            }
        });

        carB.turboOffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setTurboOff();
            }
        });

        carB.liftBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                liftBedButton();
            }
        });

        carB.lowerBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lowerBedButton();
            }
        });
        carB.startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gas(gasAmount);
            }
        });

        carB.stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stopButton();
            }
        });





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
    // Calls the gas method for each car once
    void gas(int amount) {
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
