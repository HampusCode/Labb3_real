import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WorkShop<T extends Car> {
    private int maxCars;
    private ArrayList<T> carsIn;

    WorkShop(int max){
        this.maxCars = max;
        this.carsIn = new ArrayList<T>();
    }

    public void acceptCar(T car){
        if(carsIn.size() < maxCars ){
            carsIn.add(car);
        }
    }

    public void removeCar(T car){
        if(carsIn.contains(car)){
            carsIn.remove(car);
        }else{
            System.out.println("Car is not in ");
        }
    }


}
