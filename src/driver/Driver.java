package driver;

import java.util.Objects;

public abstract class Driver {
    private final String fullName;
    private final boolean driversLicense;
    private int drivingExperience;

    public Driver(String fullName, boolean driversLicense, int drivingExperience) {
        if(fullName == null || fullName.isBlank()){
            this.fullName = "default";
        }else{
            this.fullName = fullName;
        }
        this.driversLicense = driversLicense;
        if (drivingExperience < 0){
            this.drivingExperience = 0;
        }else{
            this.drivingExperience = drivingExperience;
        }
    }

    public String getFullName() {
        return this.fullName;
    }

    public boolean isDriversLicense() {
        return this.driversLicense;
    }

    public int getDrivingExperience() {
        return this.drivingExperience;
    }

    public void startMotion(){
        System.out.println("Start motion.");
    }

    public void stopMotion(){
        System.out.println("Stop motion.");
    }

    public void fillUpCar(){
        System.out.println("Fill up the car.");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driver driver = (Driver) o;
        return isDriversLicense() == driver.isDriversLicense()
                && getDrivingExperience() == driver.getDrivingExperience()
                && getFullName().equals(driver.getFullName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFullName(), isDriversLicense(), getDrivingExperience());
    }

    @Override
    public String toString() {
        return "Driver{" +
                "Имя='" + getFullName() + '\'' +
                ", опыт вождения=" + getDrivingExperience() +
                ", наличие прав=" + isDriversLicense() +
                '}';
    }
}
