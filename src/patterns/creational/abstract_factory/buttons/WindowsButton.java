package patterns.creational.abstract_factory.buttons;

/**
 * Все семейства продуктов имеют одинаковые вариации (MacOS/Windows)
 */
public class WindowsButton implements Button {
    @Override
    public void paint() {
        System.out.println("You have created WindowsButton");
    }
}
