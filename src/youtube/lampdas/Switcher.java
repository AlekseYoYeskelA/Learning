package youtube.lampdas;

import java.util.List;
import java.util.ArrayList;

public class Switcher {
    private List<ElectricityConsumer> listeners = new ArrayList<>();

    public void addElectricityListener(ElectricityConsumer listener) {
        listeners.add(listener);
    }

    public void removeElectricityListener(ElectricityConsumer listener) {
        listeners.remove(listener);
    }

    public void switchOn() {
        System.out.println("Выключатель включен");
//        if (listeners != null) {
//            listeners.electricityOn();
        for (ElectricityConsumer c : listeners) {
            c.electricityOn(this);
        }
    }

}
