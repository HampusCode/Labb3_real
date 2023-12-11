public abstract class BedState {
    Truck truck;


    BedState(Truck truck){
        this.truck = truck;
    }

    public abstract double speedFactor();
    
}
