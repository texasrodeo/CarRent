package service;

import domain.Car;
import persestance.DBInterface;
import persestance.DBAutoPark;

import java.util.List;

public class AutoparkService {
    private DBAutoPark autoPark = new DBAutoPark();

    public List<Car> getCars()  {
        return autoPark.getAll(Car.class);
    }

    public boolean removeCarByID(long carId){
        Car item = new Car(carId);
        return autoPark.removeCar(item);
    }

    public boolean addCar(String brand, String info, Integer price){
//        Car car = new Car(autoPark.getCurrentId().getAndIncrement(), brand, info, price);
        return autoPark.addCar(new Car(brand, info, price));

    }

    public boolean updateCar(Long id, String brand, String info, Integer price){
        return autoPark.alterCar(new Car(id, brand, info, price));

    }
}
