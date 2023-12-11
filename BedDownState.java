public class BedDownState extends BedState{
    Truck truck;

    BedDownState(Truck truck){
        super(truck);
        this.truck = truck;
        
    }

    @Override 
    public double speedFactor(){
        return truck.getEnginePower() * 0.01 * 1;
        
    }
}
