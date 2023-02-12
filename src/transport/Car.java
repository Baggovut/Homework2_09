package transport;

import driver.DriverCategoryB;
import enums.CarTypes;
import mechanic.Mechanic;

import java.util.List;
import java.util.Objects;

public class Car<T extends DriverCategoryB> extends Transport implements Competing{
    private T driver;
    private CarTypes carType;
    public Car(String brand,
               String model,
               int engineCapacity,
               T driver,
               CarTypes carType,
               List<Mechanic> mechanicList) {
        super(brand,model,engineCapacity,mechanicList);
        this.driver = driver;
        this.carType = carType;
        setTechnicalInspection(true);
    }

    @Override
    public void pitStop() {
        System.out.println("Car Пит-стоп");
    }

    @Override
    public void bestLapTime() {
        System.out.println("Car лучшее время круга");
    }

    @Override
    public void maxSpeed() {
        System.out.println("Car максимальная скорость");
    }

    public T getDriver() {
        return driver;
    }

    @Override
    public String toString() {
        return "Легковой автомобиль={" +
                "Марка = '" + getBrand() + '\'' +
                ", модель = '" + getModel() + '\'' +
                ", объем двигателя = '" + getEngineCapacity() + '\'' +
                '}';
    }

    public String homeworkTask(){
        if(getDriver() == null){
            return "Автомобиль никуда не поедет без водителя.";
        }else{
            return "Водитель " + getDriver().getFullName() + " управляет легковым автомобилем " + getBrand() + " " + getModel() +
                    " и будет участвовать в заезде.";
        }
    }

    public CarTypes getCarType() {
        return carType;
    }

    public void setCarType(CarTypes carType) {
        this.carType = carType;
    }

    @Override
    public void printType() {
        if(carType == null){
            System.out.println("Данных по транспортному средству недостаточно.");
        }else{
            System.out.println(carType.name());
        }
    }

    @Override
    public void passDiagnostics() {
        System.out.println("Легковой автомобиль прохожит диагностику");
    }

    @Override
    public void printDriver() {
        if(getDriver()==null){
            System.out.println("У автомобиля нет водителя.");
        }else {
            System.out.println("Водитель данного легкового автомобиля: "+getDriver().getFullName());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car<?> car = (Car<?>) o;
        return Objects.equals(getBrand(), car.getBrand())
                && Objects.equals(getModel(), car.getModel())
                && Objects.equals(getEngineCapacity(), car.getEngineCapacity())
                && Objects.equals(getDriver(), car.getDriver())
                && Objects.equals(getMechanicList(), car.getMechanicList())
                && getCarType() == car.getCarType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBrand(),getModel(),getEngineCapacity(),getDriver(),getCarType(),getMechanicList());
    }
}

