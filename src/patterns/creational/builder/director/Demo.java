package patterns.creational.builder.director;

import patterns.creational.builder.builders.CarBuilder;
import patterns.creational.builder.builders.CarManualBuilder;
import patterns.creational.builder.cars.Car;
import patterns.creational.builder.cars.Manual;


public class Demo {
    public static void main(String[] args) {
        Director director = new Director();

        CarBuilder builder = new CarBuilder();
        director.constructSportCar(builder);

        Car car = builder.getResult();
        System.out.println("Car built:\n" + car.getCarType());

        CarManualBuilder carManualBuilder = new CarManualBuilder();

        director.constructSportCar(carManualBuilder);
        Manual carManual = carManualBuilder.getResult();
        System.out.println("\nCAr manual built:\n" +  carManual.print());
    }
}
