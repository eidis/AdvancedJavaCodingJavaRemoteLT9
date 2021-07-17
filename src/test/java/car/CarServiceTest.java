package car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CarServiceTest {

    private static final Car CAR_1 = new Car("V8", "RED", 1999);
    private static final Car CAR_2 = new Car("V12", "BLUE", 2018);
    private static final Car CAR_3 = new Car("V6", "YELLOW", 2001);

    private CarService carService;

    @BeforeEach
    void setUp() {
        carService = new CarService();
    }

    @Test
    void testAddCars() {
        assertEquals(0, carService.getListOfCars().size());

        carService.addCar(CAR_1);
        assertEquals(1, carService.getListOfCars().size());

        carService.addCar(CAR_2);
        carService.addCar(CAR_3);
        assertEquals(3, carService.getListOfCars().size());
    }

    @Test
    void testRemoveCars() {
        carService.addCar(CAR_1);
        carService.addCar(CAR_2);
        carService.addCar(CAR_3);
        assertEquals(3, carService.getListOfCars().size());

        carService.removeCar(CAR_2);
        assertEquals(2, carService.getListOfCars().size());
        assertEquals(-1, carService.getListOfCars().indexOf(CAR_2));
    }
}