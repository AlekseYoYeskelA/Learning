package patterns.structural.bridge;

import patterns.structural.bridge.devices.Device;
import patterns.structural.bridge.devices.Radio;
import patterns.structural.bridge.devices.TV;
import patterns.structural.bridge.remotes.AdvanceRemote;
import patterns.structural.bridge.remotes.BasicRemote;

public class Demo {
    public static void main(String[] args) {
        testDevice(new TV());
        testDevice(new Radio());
    }

    public static void testDevice(Device device) {
        System.out.println("Tests with basic remote.");
        BasicRemote basicRemote = new BasicRemote(device);
        basicRemote.power();
        device.printStatus();

        System.out.println("Tests with advanced remote.");
        AdvanceRemote advanceRemote = new AdvanceRemote(device);
        advanceRemote.power();
        advanceRemote.mute();
        device.printStatus();
    }
}
