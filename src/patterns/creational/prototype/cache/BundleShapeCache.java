package patterns.creational.prototype.cache;

import patterns.creational.prototype.shapes.Circle;
import patterns.creational.prototype.shapes.Rectangle;
import patterns.creational.prototype.shapes.Shape;

import java.util.HashMap;
import java.util.Map;

public class BundleShapeCache {
    private Map<String, Shape> cache = new HashMap<>();

    public BundleShapeCache() {
        Circle circle = new Circle();
        circle.x = 5;
        circle.y = 7;
        circle.radius = 45;
        circle.color = "green";

        Rectangle rectangle = new Rectangle();
        rectangle.x = 6;
        rectangle.y = 9;
        rectangle.width = 10;
        rectangle.height = 20;
        rectangle.color = "blue";

        cache.put("Big green circle", circle);
        cache.put("Medium blue rectangle", rectangle);
    }

    public Shape put(String key, Shape shape) {
        cache.put(key, shape);
        return shape;
    }

    public Shape get(String key) {
        return cache.get(key).clone();
    }

}
