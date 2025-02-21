package patterns.creational.factory_method.factory;

import patterns.creational.factory_method.button.Button;

/**
 * Базовый класс фабрики. "Фабрика - дополнительная роль для класса, он уже имеет какую-то бизнес-логику"
 */
public abstract class Dialog {
    public void renderWindow() {
        //... код диалога ...

        Button okButton = createButton();
        okButton.render();
    }

    /**
     * Подклассы будут переопределять этот метод, для того, чтобы создавать конкретные объекты продуктов,
    разные для каждой фабрики.
     */
    public abstract Button createButton();
}
