package transport;

import driver.DriverCategoryD;
import enums.BusTypes;
import exceptions.TransportTypeException;
import mechanic.Mechanic;

import java.util.List;
import java.util.Objects;

public class Bus<T extends DriverCategoryD> extends Transport implements Competing{
    private T driver;
    private BusTypes busType;
    public Bus(String brand,
               String model,
               int engineCapacity,
               T driver,
               BusTypes busType,
               List<Mechanic> mechanicList) {
        super(brand, model, engineCapacity, mechanicList);
        this.driver = driver;
        this.busType = busType;
        setTechnicalInspection(false);
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
        return "Автобус={" +
                "Марка = '" + getBrand() + '\'' +
                ", модель = '" + getModel() + '\'' +
                ", объем двигателя = '" + getEngineCapacity() + '\'' +
                '}';
    }
    public String homeworkTask(){
        if(getDriver() == null){
            return "Автобус никуда не поедет без водителя.";
        }else{
            return "Водитель " + getDriver().getFullName() + " управляет автобусом " + getBrand() + " " + getModel() +
                    " и будет участвовать в заезде.";
        }
    }

    public BusTypes getBusType() {
        return busType;
    }

    public void setBusType(BusTypes busType) {
        this.busType = busType;
    }

    @Override
    public void printType() {
        if(busType == null){
            System.out.println("Данных по транспортному средству недостаточно.");
        }else{
            System.out.println(busType.name());
        }
    }

    @Override
    public void passDiagnostics(){
        throw new TransportTypeException("Автобусы диагностику проходить не должны");
    }

    @Override
    public void printDriver() {
        if(getDriver()==null){
            System.out.println("У автобуса нет водителя.");
        }else {
            System.out.println("Водитель данного автобуса: "+getDriver().getFullName());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bus<?> bus = (Bus<?>) o;
        return Objects.equals(getBrand(), bus.getBrand())
                && Objects.equals(getModel(), bus.getModel())
                && Objects.equals(getEngineCapacity(), bus.getEngineCapacity())
                && Objects.equals(getDriver(), bus.getDriver())
                && Objects.equals(getMechanicList(), bus.getMechanicList())
                && getBusType() == bus.getBusType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBrand(),getModel(),getEngineCapacity(),getDriver(),getBusType(),getMechanicList());
    }
}
