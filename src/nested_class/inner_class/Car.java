package nested_class.inner_class;

import java.io.FilterOutputStream;

public class Car {
    String color;
    int doorCount;
    Engine engine;

    public Car(String color, int doorCount) {
        Engine e = new Engine(200);//можем создать как обычный объект только внутри внешнего класса
        System.out.println(e.horsePower);
        this.color = color;
        this.doorCount = doorCount;
        //this.engine = this.new Engine(horsePower); //объект внутреннего класса всегда связан/создаётся с объектом внешнего класса
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }


    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", doorCount=" + doorCount +
                ", engine=" + engine +
                '}';
    }

    //inner class может содержать только non-static элементы, может обращаться к private переменным во внешнем классе
    public class Engine {
        private int horsePower;

        public Engine(int horsePower) {
            this.horsePower = horsePower;
        }

        @Override
        public String toString() {
            return "Engine{" +
                    "horsePower=" + horsePower +
                    '}';
        }
    }
}

class Test {
    public static void main(String[] args) {
        Car car = new Car("black", 4);
        Car.Engine engine = car.new Engine(333);
        car.setEngine(engine);
        System.out.println(engine);
        System.out.println(car);

        Car.Engine engine1 = new Car("red", 3).new Engine(200);
    }
}
