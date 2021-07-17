package car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarService {

    private final List<Car> carList = new ArrayList<>();

    public void addCar(Car car) {
        carList.add(car);
    }

    public void removeCar(Car car) {
        carList.remove(car);
    }

    public List<Car> getListOfCars() {
        return carList;
    }

    public List<Car> getCarsWithV12Engine() {
        return carList.stream()
                .filter(car -> "V12".equals(car.getEngine()))
                .collect(Collectors.toList());
    }
}