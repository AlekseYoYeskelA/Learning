package youtube.lampdas;

public class Program {
    public static void fire(Object sender) {
        System.out.println("Пожар!!!");
    }

    public static void main(String[] args) {
        Switcher sw = new Switcher();
        Lamp lamp = new Lamp();
        Radio radio = new Radio();

        // подписка на событие (event subscribe)
        sw.addElectricityListener(lamp);
        sw.addElectricityListener(radio);

        String message = "Пожар"; //переменная должна быть эффективно финализирована

        sw.addElectricityListener(new ElectricityConsumer() {
            @Override
            public void electricityOn(Object sender) {
                System.out.print(message);
                System.out.println("!!!");
            }
        });

        //Лямпда-выражение или использование объекта, как функцию.
        //Круглые скобки в параметрах можно опустить только при наличии 1 параметра"
        sw.addElectricityListener(sender -> System.out.println(message));

        //Указание на метод (ссылка на метод)
        //Сокращение возможно только если есть внешний метод, параметры которого совпадают с параметрами лямпда-выражения
        sw.addElectricityListener(Program::fire);

        sw.switchOn();
    }
}
