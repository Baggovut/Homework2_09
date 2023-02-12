package stations;

import transport.Transport;

import java.util.LinkedList;
import java.util.Queue;

public class ServiceStation{

    private Queue<Transport> transportQueue;

    public ServiceStation() {
        transportQueue = new LinkedList<>();
    }

    public void addCar(Transport transport){
        if(transport.isTechnicalInspection()){
            transportQueue.offer(transport);
        }else {
            System.out.println("Данный тип авто не должен проходить ТО");
        }
    }

    public void doTechnicalInspection(){
        Transport currentTransport = transportQueue.poll();
        if(currentTransport != null) {
            System.out.println("Проводится тех. осмотр для: " + currentTransport.getBrand() + " " + currentTransport.getModel());
        }else {
            System.out.println("Очередь на ТО пуста.");
        }
    }

}
