public class BedUpState extends BedState{
    Truck truck;
    BedUpState(Truck truck){
        
        super(truck);
        this.truck = truck;
    }

    @Override
    public double speedFactor(){
    return 0;
    }
}
