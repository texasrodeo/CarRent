package persestance.old;

import domain.Car;
import scripts.PopulateItems;

import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

public class AutoPark {
    private AtomicLong currentId = new AtomicLong();

    public AtomicLong getCurrentId(){
        return currentId;
    }

    private static AutoPark instance;

    public static AutoPark getInstance(){
        if(instance == null) {
            instance = new AutoPark();
        }
        return instance;
    }

    private List<Car> cars = new ArrayList<>();

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public Car getCarBy(Car car){
        for(Car car1:cars){
            if(car1.equals(car))
                return car1;
        }
        return null;
    }

    public boolean addCar(Car car){
       return this.cars.add(car);
    }

    public boolean removeCar(Car car){
        return cars.remove(car);
    }

    public boolean updateCar(Car car){
        for(Car car1:cars){
            if(car1.equals(car)){
                cars.set(cars.indexOf(car1),car);
                return true;
            }
        }
        return false;
    }

    public AutoPark(){
        cars = PopulateItems.populate(currentId);
    }


}
