import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    // Just a single image, TODO: Generalize
    BufferedImage volvoImage;
    BufferedImage scaniaImage;
    BufferedImage saabImage;
    // To keep track of a singel cars position
    Point volvoPoint = new Point();

    Point saabPoint = new Point(0,100);
    
    Point scaniaPoint = new Point(0,200);

    HashMap<String,Point> vehicles = new HashMap<>();
    ArrayList<Vehicle> v = new ArrayList<>();

    // TODO: Make this genereal for all cars
    // void moveit(int x, int y, String vehicle){


    void moveit(int x, int y, ArrayList<Vehicle> vehicles, int index){
        v = vehicles;
    }

    void tempMove(Vehicle v, int offset){
        int x = (int)v.getX();
        int y = (int)v.getY();

        Point vehicleP = new Point(x,y);
        
        vehicleP.x = x;
        vehicleP.y = y*offset;

    }

    public BufferedImage findPic(Vehicle v){
            if(v.getModelName().equals("Saab95")){
                return saabImage;
            }else if(v.getModelName().equals("Volvo240")){
                return volvoImage;
            }else if(v.getModelName().equals("Scania")){
                return scaniaImage;
            }
            BufferedImage i = new BufferedImage(WIDTH, HEIGHT, ABORT);
            return i;
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        // Print an error message in case file is not found with a try/catch block
        try {
            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // volvoImage = ImageIO.read(new File("Volvo240.jpg"));

            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.
            volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
            saabImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg"));
            scaniaImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg"));

        } catch (IOException ex)
        {
            ex.printStackTrace();
        }

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Vehicle car : v) {
            BufferedImage pic = findPic(car);
            Point p = new Point((int) car.getX(), (int) car.getY());
            g.drawImage(pic, p.x, p.y, null);
        }
        repaint();
    }
}
