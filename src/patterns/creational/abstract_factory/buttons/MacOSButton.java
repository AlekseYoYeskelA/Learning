package patterns.creational.abstract_factory.buttons;

/**
 * Все семейства продуктов имеют одинаковые вариации (MacOS/Windows)
 */
public class MacOSButton implements Button {
    @Override
    public void paint() {
        System.out.println("You have created MasOSButton.");
    }
}
