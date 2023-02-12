package transport;

import driver.DriverCategoryC;
import enums.TruckTypes;
import mechanic.Mechanic;

import java.util.List;
import java.util.Objects;

public class Truck<T extends DriverCategoryC> extends Transport implements Competing{
    private T driver;
    private TruckTypes truckType;
    public Truck(String brand,
                 String model,
                 int engineCapacity,
                 T driver,
                 TruckTypes truckType,
                 List<Mechanic> mechanicList) {
        super(brand,model,engineCapacity,mechanicList);
        this.driver = driver;
        this.truckType = truckType;
        setTechnicalInspection(true);
    }
    public T getDriver() {
        return driver;
    }

    @Override
    public void pitStop() {
        System.out.println("Truck Пит-стоп");
    }

    @Override
    public void bestLapTime() {
        System.out.println("Truck лучшее время круга");
    }

    @Override
    public void maxSpeed() {
        System.out.println("Truck максимальная скорость");
    }

    @Override
    public String toString() {
        return "Грузовой автомобиль={" +
                "Марка = '" + getBrand() + '\'' +
                ", модель = '" + getModel() + '\'' +
                ", объем двигателя = '" + getEngineCapacity() + '\'' +
                '}';
    }
    public String homeworkTask(){
        if(getDriver() == null){
            return "Автомобиль никуда не поедет без водителя.";
        }else{
            return "Водитель " + getDriver().getFullName() + " управляет грузовым автомобилем " + getBrand() + " " + getModel() +
                    " и будет участвовать в заезде.";
        }
    }

    public TruckTypes getTruckType() {
        return truckType;
    }

    public void setTruckType(TruckTypes truckType) {
        this.truckType = truckType;
    }

    @Override
    public void printType() {
        if(truckType == null){
            System.out.println("Данных по транспортному средству недостаточно.");
        }else{
            System.out.println(truckType.name());
        }
    }

    @Override
    public void passDiagnostics() {
        System.out.println("Грузовой автомобиль прохожит диагностику");
    }

    @Override
    public void printDriver() {
        if(getDriver()==null){
            System.out.println("У автомобиля нет водителя.");
        }else {
            System.out.println("Водитель данного грузового автомобиля: "+getDriver().getFullName());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Truck<?> truck = (Truck<?>) o;
        return Objects.equals(getBrand(), truck.getBrand())
                && Objects.equals(getModel(), truck.getModel())
                && Objects.equals(getEngineCapacity(), truck.getEngineCapacity())
                && Objects.equals(getDriver(), truck.getDriver())
                && Objects.equals(getMechanicList(), truck.getMechanicList())
                && getTruckType() == truck.getTruckType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBrand(),getModel(),getEngineCapacity(),getDriver(),getTruckType(),getMechanicList());
    }
}

