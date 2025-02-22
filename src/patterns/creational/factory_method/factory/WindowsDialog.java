package patterns.creational.factory_method.factory;

import patterns.creational.factory_method.button.Button;
import patterns.creational.factory_method.button.WindowsButton;

public class WindowsDialog extends Dialog {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }
}
