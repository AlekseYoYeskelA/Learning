package patterns.creational.abstract_factory.factories;

import patterns.creational.abstract_factory.buttons.Button;
import patterns.creational.abstract_factory.buttons.MacOSButton;
import patterns.creational.abstract_factory.checkboxes.Checkbox;
import patterns.creational.abstract_factory.checkboxes.MacOSCheckbox;

public class MacOSFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new MacOSButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacOSCheckbox();
    }
}
