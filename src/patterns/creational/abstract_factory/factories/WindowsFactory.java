package patterns.creational.abstract_factory.factories;

import patterns.creational.abstract_factory.buttons.Button;
import patterns.creational.abstract_factory.buttons.WindowsButton;
import patterns.creational.abstract_factory.checkboxes.Checkbox;
import patterns.creational.abstract_factory.checkboxes.WindowsCheckbox;

public class WindowsFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}
