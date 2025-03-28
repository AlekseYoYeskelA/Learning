package patterns.structural.bridge.remotes;

import patterns.structural.bridge.devices.Device;

public class AdvanceRemote extends BasicRemote {

    public AdvanceRemote(Device device) {
        super(device);
    }

    public void mute() {
        System.out.println("Remote: mute");
        device.setVolume(0);
    }
}
