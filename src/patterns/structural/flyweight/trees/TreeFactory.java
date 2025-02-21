package patterns.structural.flyweight.trees;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class TreeFactory {
    static Map<String, TreeType> treeTypes = new HashMap<>();

    public static TreeType getTreeType(String name, Color color, String otherTreeData) {
        return treeTypes.computeIfAbsent(name, newName -> new TreeType(newName, color, otherTreeData));

//        TreeType result = treeTypes.get(name);
//        if (result == null) {
//            result = new TreeType(name, color, otherTreeData);
//            treeTypes.put(name, result);
//        }
//        return result;

    }
}
