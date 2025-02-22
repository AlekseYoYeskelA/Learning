package patterns.creational.abstract_factory.buttons;

/**
 * Паттерн предполагает, что у нас есть несколько семейств продуктов,
 * находящихся в отдельных иерархиях классов (Button/Checkbox).
 * Продукты одного семейства должны иметь общий интерфейс.
 */
public interface Button {
    void paint();
}
