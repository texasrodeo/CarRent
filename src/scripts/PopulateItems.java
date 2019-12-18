package scripts;

import com.sun.glass.ui.Size;
import domain.Car;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class PopulateItems {
    private static final int COUNT = 10;

    private static final List<String> brands = constructbrands();

    private static Random rnd = new Random();

    private static LinkedList<String> constructbrands(){
        LinkedList<String> res = new LinkedList<>();
        res.add("volvo");
        res.add("mercedes");
        res.add("jaguar");
        res.add("renault");
        res.add("toyota");
        res.add("bwm");
        res.add("lada");
        return res;
    }

    private static final List<String> infos = constructInfos();

    private static LinkedList<String> constructInfos(){
        LinkedList<String> res = new LinkedList<>();
        res.add("100 л.с");
        res.add("200 л.с");
        res.add("550 л.с");
        res.add("600 л.с");
        res.add("95 л.с");
        res.add("300 л.с");
        res.add("170 л.с");
        return res;
    }

    private static final List<Integer> prices = constructPrices();

    private static LinkedList<Integer> constructPrices(){
        LinkedList<Integer> res = new LinkedList<>();
        res.add(2000);
        res.add(2500);
        res.add(3000);
        res.add(10000);
        res.add(70000);
        res.add(6000);
        return res;
    }



    public static List<Car> populate(AtomicLong atomicLong){
        List<Car> cars = new ArrayList<>();
        for(int i=0;i<COUNT;i++){
            cars.add(new Car(atomicLong.getAndIncrement(), brands.get(rnd.nextInt(brands.size()-1)),
                    infos.get(rnd.nextInt(infos.size()-1)), prices.get(rnd.nextInt(prices.size()-1))));
        }
        return cars;
    }
}
