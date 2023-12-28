import strategy.SportsDriveStrategy;

public class GoodsVehicle extends Vehicle {

    GoodsVehicle() {
        super(new SportsDriveStrategy());
    }
    
}
