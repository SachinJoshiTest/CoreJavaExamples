import java.io.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.*;

// Interface
interface Vehicle {
    void drive();
}

// Abstract class
abstract class Car implements Vehicle {
    private String model;          // private access modifier
    int year;                      // default access modifier (package-private)
    protected String brand;        // protected access modifier
    public String type;            // public access modifier

    public Car(String model, int year, String brand, String type) {
        this.model = model;
        this.year = year;
        this.brand = brand;
        this.type = type;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public abstract void honk();
}

// Concrete class
class Sedan extends Car {
    public Sedan(String model, int year, String brand, String type) {
        super(model, year, brand, type);
    }

    @Override
    public void drive() {
        System.out.println(getModel() + " is driving.");
    }

    @Override
    public void honk() {
        System.out.println(getModel() + " is honking.");
    }
}

// Another concrete class
class SUV extends Car {
    public SUV(String model, int year, String brand, String type) {
        super(model, year, brand, type);
    }

    @Override
    public void drive() {
        System.out.println(getModel() + " is driving off-road.");
    }

    @Override
    public void honk() {
        System.out.println(getModel() + " is honking loudly.");
    }
}

// Generics example
class Garage<T extends Car> {
    private List<T> cars = new ArrayList<>();

    public void addCar(T car) {
        cars.add(car);
    }

    public void listCars() {
        cars.forEach(car -> System.out.println(car.getModel() + " from " + car.getYear()));
    }
}

// Exception handling example
class CarNotFoundException extends Exception {
    public CarNotFoundException(String message) {
        super(message);
    }
}

// Main class
public class CoreJavaConceptsRevision {
    public static void main(String[] args) {
        // Creating objects
        Sedan sedan = new Sedan("Toyota Camry", 2020, "Toyota", "Sedan");
        SUV suv = new SUV("Land Rover", 2019, "Land Rover", "SUV");

        // Using inheritance and polymorphism
        Car car1 = sedan;
        Car car2 = suv;

        car1.drive();
        car1.honk();
        car2.drive();
        car2.honk();

        // Using generics
        Garage<Car> garage = new Garage<>();
        garage.addCar(sedan);
        garage.addCar(suv);
        garage.listCars();

        // Using collections
        List<Car> carList = new ArrayList<>();
        carList.add(sedan);
        carList.add(suv);

        Set<String> carModels = carList.stream()
                .map(Car::getModel)
                .collect(Collectors.toSet());

        carModels.forEach(System.out::println);

        // Using lambda expressions
        carList.forEach(car -> System.out.println(car.getModel() + " is a car."));

        // Exception handling
        try {
            findCarByModel(carList, "Tesla Model S");
        } catch (CarNotFoundException e) {
            System.out.println(e.getMessage());
        }

        // Multi-threading
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.submit(() -> System.out.println("Thread 1: " + sedan.getModel()));
        executor.submit(() -> System.out.println("Thread 2: " + suv.getModel()));
        executor.shutdown();

        // I/O operations
        writeCarModelsToFile(carModels, "car_models.txt");

        // Accessing protected and public members
        System.out.println("Sedan brand: " + sedan.brand); // protected
        System.out.println("SUV type: " + suv.type); // public
    }

    // Method to demonstrate exception handling
    public static void findCarByModel(List<Car> cars, String model) throws CarNotFoundException {
        for (Car car : cars) {
            if (car.getModel().equals(model)) {
                System.out.println("Found: " + car.getModel());
                return;
            }
        }
        throw new CarNotFoundException("Car model " + model + " not found.");
    }

    // Method to demonstrate I/O operations
    public static void writeCarModelsToFile(Set<String> carModels, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (String model : carModels) {
                writer.write(model);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
