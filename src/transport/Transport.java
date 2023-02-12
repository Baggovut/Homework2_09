package transport;

import mechanic.Mechanic;

import java.util.List;

public abstract class Transport {
    private final String brand, model;
    private int engineCapacity;
    private List<Mechanic> mechanicList;
    private boolean technicalInspection;

    public Transport(String brand,
                     String model,
                     int engineCapacity,
                     List<Mechanic> mechanicsList) {
        if(brand == null || brand.isBlank()){
            this.brand = "default";
        }else{
            this.brand = brand;
        }
        if(model == null || model.isBlank()){
            this.model = "default";
        }else{
            this.model = model;
        }
        setMechanicList(mechanicsList);
        setEngineCapacity(engineCapacity);
        setTechnicalInspection(false);
    }

    public String getBrand() {
        return this.brand;
    }
    public String getModel() {
        return this.model;
    }

    public boolean isTechnicalInspection() {
        return technicalInspection;
    }

    protected void setTechnicalInspection(boolean technicalInspection) {
        this.technicalInspection = technicalInspection;
    }

    public int getEngineCapacity() {
        return this.engineCapacity;
    }
    public void setEngineCapacity(int engineCapacity) {
        int defaultValue = 100;
        if(engineCapacity <= 0){
            this.engineCapacity = defaultValue;
        }else{
            this.engineCapacity = engineCapacity;
        }
    }

    public List<Mechanic> getMechanicList() {
        return this.mechanicList;
    }

    public void setMechanicList(List<Mechanic> mechanicList) {
        this.mechanicList = mechanicList;
    }

    public void printMechanics(){
        if(this.mechanicList == null){
            System.out.println("К автомобилю не приписаны механики.\n");
        }else{
            System.out.println("Список механиков:");
            for(Mechanic mechanic : mechanicList){
                System.out.println(mechanic);
            }
            System.out.println();
        }
    }

    public void startMotion(){
        System.out.println("Start motion;");
    }
    public void stopMotion(){
        System.out.println("Stop motion;");
    }

    abstract public void printType();
    abstract public void passDiagnostics();
    abstract public void printDriver();
}
