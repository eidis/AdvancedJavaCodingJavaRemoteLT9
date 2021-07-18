package car;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparingDouble;

public class CarService {

    private final List<Car> carList = new ArrayList<>();

    public void addCar(Car car) {
        carList.add(car);
    }

    public void removeCar(Car car) {
        carList.remove(car);
    }

    public boolean isCarOnTheList(Car car) {
        return carList.contains(car);
    }

    public List<Car> getListOfCars() {
        return carList;
    }

    public List<Car> getListOfCars(Sort sort) {
        Comparator<Car> comparator = Comparator
                .comparing(Car::getModel, String.CASE_INSENSITIVE_ORDER)
                .thenComparing(Car::getYear);

        if (sort == Sort.DESC) {
            comparator = comparator.reversed();
        }

        return carList.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }

    public List<Car> getCarsWithV12Engine() {
        return carList.stream()
                .filter(car -> "V12".equals(car.getEngine()))
                .collect(Collectors.toList());
    }

    public List<Car> getCarsProducedBefore1999() {
        return carList.stream()
                .filter(car -> car.getYear() < 1999)
                .collect(Collectors.toList());
    }

    public Car findMostExpensiveCar() {
        return carList.stream()
                .max(comparingDouble(Car::getPrice))
                .orElse(null);
    }

    public Car findCheapestCar() {
        return carList.stream()
                .min(comparingDouble(Car::getPrice))
                .orElse(null);
    }

    public Set<Manufacturer> findManufacturersWithAtLeast3Cars() {
        return carList.stream()
                .collect(Collectors.groupingBy(Car::getManufacturer)).entrySet().stream()
                .filter(entry -> entry.getValue().size() >= 3)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
    }

    public List<Car> findCarsByManufacturer(Manufacturer manufacturer) {
        return carList.stream()
                .filter(car -> manufacturer.equals(car.getManufacturer()))
                .collect(Collectors.toList());
    }

    public List<Car> findCarsByManufacturerEstablishedBefore(int yearOfEstablishment) {
        return carList.stream()
                .filter(car -> car.getManufacturer().getYearEstablished() < yearOfEstablishment)
                .collect(Collectors.toList());
    }
}