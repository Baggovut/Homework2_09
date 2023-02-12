import driver.Driver;
import driver.DriverCategoryB;
import driver.DriverCategoryC;
import driver.DriverCategoryD;
import enums.BusTypes;
import enums.CarTypes;
import enums.TruckTypes;
import exceptions.TransportTypeException;
import mechanic.Mechanic;
import stations.ServiceStation;
import transport.Bus;
import transport.Car;
import transport.Transport;
import transport.Truck;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        DriverCategoryB driver1 = new DriverCategoryB("Горбунков Семён Семёнович",true,10);
        DriverCategoryC driver2 = new DriverCategoryC("Геннадий Козодоев",true,11);
        DriverCategoryD driver3 = new DriverCategoryD("Жорж Милославский",true,12);
        DriverCategoryD driver3copy = new DriverCategoryD("Жорж Милославский",true,12);

        Mechanic mechanic1 = new Mechanic("Иван","Иванов","Рога и Копыта");
        Mechanic mechanic2 = new Mechanic("Василий","Пупкин","Спец. Механика");
        Mechanic mechanic3 = new Mechanic("Джон","Константин","Оккультная механика");
        Mechanic mechanic4 = new Mechanic("Виталий","Колобков","ООО \"Тех.обслуживание\"");
        Mechanic mechanic5 = new Mechanic("","","");
        Mechanic mechanic6 = new Mechanic("","","");
        Mechanic mechanic7 = new Mechanic("","","");
        Mechanic mechanic8 = new Mechanic("","","");

        ServiceStation station1 = new ServiceStation();

        List<Mechanic> mechanicList1 = new ArrayList<>();
        List<Mechanic> mechanicList2 = new ArrayList<>();

        mechanicList1.add(mechanic1);
        mechanicList1.add(mechanic2);
        mechanicList1.add(mechanic3);
        mechanicList1.add(mechanic4);

        mechanicList2.add(mechanic5);
        mechanicList2.add(mechanic6);
        mechanicList2.add(mechanic7);
        mechanicList2.add(mechanic8);

        Car<DriverCategoryB> car1 = new Car<>("brand1","model1",0,null,null,null);
        Car<DriverCategoryB> car2 = new Car<>("brand2","model2",0,driver1, CarTypes.PICKUP, mechanicList1);
        Car<DriverCategoryB> car3 = new Car<>("brand3","model3",0,driver1, CarTypes.SEDAN,mechanicList1);
        Car<DriverCategoryB> car4 = new Car<>("brand4","model4",0,driver1, CarTypes.CROSSOVER,mechanicList1);
        Car<DriverCategoryB> car4Copy = new Car<>("brand4","model4",0,driver1, CarTypes.CROSSOVER,mechanicList1);

        Truck<DriverCategoryC> truck1 = new Truck<>("brand1","model1",0,driver2, TruckTypes.N1,mechanicList1);
        Truck<DriverCategoryC> truck2 = new Truck<>("brand2","model2",0,driver2, TruckTypes.N2,mechanicList1);
        Truck<DriverCategoryC> truck3 = new Truck<>("brand3","model3",0,driver2, TruckTypes.N3,mechanicList1);
        Truck<DriverCategoryC> truck4 = new Truck<>("brand4","model4",0,driver2, null,null);
        Truck<DriverCategoryC> truck4Copy = new Truck<>("brand4","model4",0,driver2, null,null);

        Bus<DriverCategoryD> bus1 = new Bus<>("brand1","model1",0,driver3,BusTypes.LARGE,mechanicList2);
        Bus<DriverCategoryD> bus2 = new Bus<>("brand2","model2",0,driver3,BusTypes.MEDIUM,mechanicList2);
        Bus<DriverCategoryD> bus3 = new Bus<>("brand3","model3",0,driver3,BusTypes.SMALL,mechanicList2);
        Bus<DriverCategoryD> bus4 = new Bus<>("brand4","model4",0,driver3,BusTypes.EXTRA_SMALL,mechanicList2);
        Bus<DriverCategoryD> bus4Copy = new Bus<>("brand4","model4",0,driver3,BusTypes.EXTRA_SMALL,mechanicList2);

        System.out.println(car1);
        System.out.println(car2);
        System.out.println(car3);
        System.out.println(car4);

        System.out.println();

        System.out.println(truck1);
        System.out.println(truck2);
        System.out.println(truck3);
        System.out.println(truck4);

        System.out.println();

        System.out.println(bus1);
        System.out.println(bus2);
        System.out.println(bus3);
        System.out.println(bus4);

        System.out.println();

        System.out.println(car1.homeworkTask());
        System.out.println(car2.homeworkTask());
        System.out.println(truck2.homeworkTask());
        System.out.println(bus3.homeworkTask());

        System.out.println();

        for (CarTypes ce : CarTypes.values()){
            System.out.println(ce);
        }
        System.out.println();

        for (TruckTypes te : TruckTypes.values()){
            System.out.println(te);
        }
        System.out.println();

        for (BusTypes be : BusTypes.values()){
            System.out.println(be);
        }
        System.out.println();

        car1.printType();
        car2.printType();
        System.out.println();

        truck1.printType();
        truck4.printType();
        System.out.println();

        bus1.printType();
        bus2.printType();

        System.out.println();

        car1.passDiagnostics();
        truck1.passDiagnostics();
        try{
            bus1.passDiagnostics();
        }catch (TransportTypeException e){
            e.printStackTrace();
        }

        System.out.println("Текст после возможного исключения.\n");

        car1.printMechanics();
        car2.printMechanics();
        bus3.printMechanics();

        car1.printDriver();
        car2.printDriver();

        System.out.println();

        station1.addCar(car1);
        station1.addCar(car2);
        station1.addCar(truck1);
        station1.addCar(truck2);
        station1.addCar(bus1);
        station1.addCar(bus2);

        station1.doTechnicalInspection();
        station1.doTechnicalInspection();
        station1.doTechnicalInspection();
        station1.doTechnicalInspection();
        station1.doTechnicalInspection();
        station1.doTechnicalInspection();
        station1.doTechnicalInspection();
        station1.doTechnicalInspection();

        System.out.println("\nВведение в коллекции. Map");

        Map<Transport,List<Mechanic>> map1 = new HashMap<>();
        map1.put(car1,car1.getMechanicList());
        map1.put(car2,car2.getMechanicList());
        map1.put(car3,car3.getMechanicList());
        map1.put(car4,car4.getMechanicList());
        map1.put(car4,car4.getMechanicList());
        map1.put(car4Copy,car4Copy.getMechanicList());

        map1.put(truck1,truck1.getMechanicList());
        map1.put(truck2,truck2.getMechanicList());
        map1.put(truck3,truck3.getMechanicList());
        map1.put(truck4,truck4.getMechanicList());
        map1.put(truck4,truck4.getMechanicList());
        map1.put(truck4Copy,truck4Copy.getMechanicList());

        map1.put(bus1,bus1.getMechanicList());
        map1.put(bus2,bus2.getMechanicList());
        map1.put(bus3,bus3.getMechanicList());
        map1.put(bus4,bus4.getMechanicList());
        map1.put(bus4,bus4.getMechanicList());
        map1.put(bus4Copy,bus4Copy.getMechanicList());

        for(Map.Entry<Transport,List<Mechanic>> me1 : map1.entrySet()){
            System.out.println("Key: "+me1.getKey()+" , Value: "+me1.getValue());
        }

        System.out.println("\nКоллекции. Set. Iterator");

        Set<Driver> driverSet = new HashSet<>();
        driverSet.add(driver1);
        driverSet.add(driver2);
        driverSet.add(driver3);
        driverSet.add(driver3copy);

        Iterator<Driver> driverIterator = driverSet.iterator();

        while (driverIterator.hasNext()){
            System.out.println(driverIterator.next());
        }

    }
}