package car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class CarServiceTest {

    private static final Manufacturer M_BMW = new Manufacturer("BMW", 1916);
    private static final Manufacturer M_AUDI = new Manufacturer("Audi", 1909);
    private static final Manufacturer M_TESLA = new Manufacturer("Tesla", 2003);
    private static final Manufacturer M_TOYOTA = new Manufacturer("Toyota", 1937);

    private static final Car CAR_0 = new Car(M_TOYOTA, "Prius", "v1", Color.WHITE, 2001, 10000);
    private static final Car CAR_1 = new Car(M_BMW, "i3", "V8", Color.BLACK, 1985, 15000);
    private static final Car CAR_2 = new Car(M_BMW, "i8", "V8", Color.BLACK, 2001, 22000);
    private static final Car CAR_3 = new Car(M_BMW, "M5", "V12", Color.RED, 1993, 25000);
    private static final Car CAR_4 = new Car(M_BMW, "M5", "V12", Color.RED, 2001, 22000);
    private static final Car CAR_5 = new Car(M_AUDI, "TT", "V6", Color.BLACK, 1999, 12000);
    private static final Car CAR_6 = new Car(M_AUDI, "Q5", "V6", Color.YELLOW, 1998, 7500);
    private static final Car CAR_7 = new Car(M_AUDI, "A7", "V6", Color.GREEN, 1998, 8500);
    private static final Car CAR_8 = new Car(M_TESLA, "S", "12V", Color.WHITE, 2010, 18000);

    private CarService carService;
    private int sizeBefore;

    @BeforeEach
    void setUp() {
        carService = new CarService();
        carService.addCar(CAR_0);
        carService.addCar(CAR_1);
        carService.addCar(CAR_2);
        carService.addCar(CAR_3);
        carService.addCar(CAR_4);
        carService.addCar(CAR_5);
        carService.addCar(CAR_6);
        carService.addCar(CAR_7);
        carService.addCar(CAR_8);
        sizeBefore = carService.getListOfCars().size();
    }

    @Test
    void testAddCars() {
        carService.addCar(CAR_1);
        assertThat(carService.getListOfCars()).hasSize(sizeBefore + 1);

        carService.addCar(CAR_2);
        carService.addCar(CAR_3);
        assertThat(carService.getListOfCars()).hasSize(sizeBefore + 3);
    }

    @Test
    void testRemoveCars() {
        carService.removeCar(CAR_2);
        assertThat(carService.getListOfCars())
                .hasSize(sizeBefore - 1)
                .doesNotContain(CAR_2);
    }

    @Test
    void testFindCarsWithV12Engine() {
        List<Car> v12Cars = carService.getCarsWithV12Engine();
        assertThat(v12Cars).containsExactlyInAnyOrder(CAR_3, CAR_4);
    }

    @Test
    void testFindCarsProducedBefore1999() {
        List<Car> carsProducedBefore1999 = carService.getCarsProducedBefore1999();
        assertThat(carsProducedBefore1999).containsExactlyInAnyOrder(CAR_1, CAR_3, CAR_6, CAR_7);
    }

    @Test
    void testFindMostExpensiveCar() {
        assertThat(carService.findMostExpensiveCar()).isEqualTo(CAR_3);
    }

    @Test
    void testFindCheapestCar() {
        assertThat(carService.findCheapestCar()).isEqualTo(CAR_6);
    }

    @Test
    void testManufacturersWithAtLeast3Cars() {
        Set<Manufacturer> manufacturers = carService.findManufacturersWithAtLeast3Cars();
        assertThat(manufacturers).containsExactlyInAnyOrder(M_BMW, M_AUDI);
    }

    @Test
    void testGetCarsSortedAscending() {
        List<Car> cars = carService.getListOfCars(Sort.ASC);
        assertThat(cars).containsExactly(
                CAR_7, CAR_1, CAR_2, CAR_3, CAR_4, CAR_0, CAR_6, CAR_8, CAR_5);
    }

    @Test
    void testGetCarsSortedDescending() {
        List<Car> cars = carService.getListOfCars(Sort.DESC);
        assertThat(cars).containsExactly(
                CAR_5, CAR_8, CAR_6, CAR_0, CAR_4, CAR_3, CAR_2, CAR_1, CAR_7);
    }

    @Test
    void testIsCarOnTheList() {
        assertThat(carService.isCarOnTheList(CAR_3)).isTrue();
        assertThat(carService.isCarOnTheList(new Car(
                M_TESLA, "X", "48v", Color.BLACK, 2020, 67000
        ))).isFalse();
    }

    @Test
    void testFindCarsByManufacturer() {
        assertThat(carService.findCarsByManufacturer(M_TOYOTA))
                .containsExactlyInAnyOrder(CAR_0);
        assertThat(carService.findCarsByManufacturer(M_BMW))
                .containsExactlyInAnyOrder(CAR_1, CAR_2, CAR_3, CAR_4);
        assertThat(carService.findCarsByManufacturer(M_AUDI))
                .containsExactlyInAnyOrder(CAR_5, CAR_6, CAR_7);
        assertThat(carService.findCarsByManufacturer(M_TESLA))
                .containsExactlyInAnyOrder(CAR_8);
    }

    @Test
    void testFindCarsByManufacturerEstablishedBefore() {
        assertThat(carService.findCarsByManufacturerEstablishedBefore(1920))
                .containsExactlyInAnyOrder(CAR_1, CAR_2, CAR_3, CAR_4, CAR_5, CAR_6, CAR_7);
    }
}