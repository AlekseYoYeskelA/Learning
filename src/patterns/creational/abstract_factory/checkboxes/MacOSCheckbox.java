package patterns.creational.abstract_factory.checkboxes;


/**
 * Все семейства продуктов имеют одинаковые вариации (MacOS/Windows)
 */
public class MacOSCheckbox implements Checkbox{
    @Override
    public void paint() {
        System.out.println("You have created MacOSCheckbox.");
    }
}
