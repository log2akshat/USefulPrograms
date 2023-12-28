import strategy.DriveStrategy;

public class Vehicle {

    DriveStrategy driveStrategy;

    // Constructor Injection
    Vehicle(DriveStrategy driveStrategy) {
        this.driveStrategy = driveStrategy;
    }

    public void drive() {
        driveStrategy.drive();
    }
}
