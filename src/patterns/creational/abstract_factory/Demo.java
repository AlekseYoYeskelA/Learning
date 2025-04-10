package patterns.creational.abstract_factory;

import patterns.creational.abstract_factory.app.Application;
import patterns.creational.abstract_factory.factories.GUIFactory;
import patterns.creational.abstract_factory.factories.MacOSFactory;
import patterns.creational.abstract_factory.factories.WindowsFactory;

public class Demo {

    /**
     * Приложение выбирает тип и создает конкретные фабрики динамически, исходя из конфигурации или окружения.
     */
    private static Application configureApplication() {
        Application app;
        GUIFactory factory;
        String osName = System.getProperty("os.name").toLowerCase();
        if (osName.contains("mac")) {
            factory = new MacOSFactory();
        } else {
            factory = new WindowsFactory();
        }
        app = new Application(factory);
        return app;
    }

    public static void main(String[] args) {
        Application app = configureApplication();
        app.paint();
    }
}
