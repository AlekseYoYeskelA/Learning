package algorithms.prefix_tree;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class PrefixNode {
    char value;
    List<PrefixNode> children;

    public PrefixNode(char value) {
        this.value = value;
    }


    public void insert(String data) {
        if (data.length() == 0) {
            return;
        }
        if (children == null) {
            children = new ArrayList<>();
        }
        char character = data.charAt(0);
        PrefixNode child = findNodeByChar(character);
        if (child == null) {
            child = new PrefixNode(character);
            children.add(child);
        }
        child.insert(data.substring(1)); //возвращаем строку без первого символа
    }


    public PrefixNode findNodeByChar(char character) {
        if (children != null) {
            for (PrefixNode node : children) {
                if (node.value == character) {
                    return node;
                }
            }
        }
        return null;
    }


    public boolean containsString(String str) {
        PrefixNode current = this;
        for (int i = 0; i < str.length(); i++) {
            current = current.findNodeByChar(str.charAt(i));
            if (current == null) {
                return false;
            }
        }
        return true;
    }

    public void getAllNumbers(String path, List<String> result) {
        if (value != ' ') {
            path = path + value;
        }
        if (children != null) {
            for (PrefixNode node : children) {
                node.getAllNumbers(path, result);
            }
        } else {
            result.add(path);
        }
    }


    public void writeToFile(PrintWriter writer) {
        writer.write(value);
        if (children != null) {
            for (PrefixNode node : children) {
                node.writeToFile(writer);
            }
        }
        writer.write(']');
    }

    public static void writeTreeToFile(String path, PrefixNode root) {
        try (PrintWriter out = new PrintWriter(path)) {
            root.writeToFile(out);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void readFromFile(FileReader reader) throws IOException {
        char ch;
        while ((ch = (char) reader.read()) != ']') {
            PrefixNode prefixNode = new PrefixNode(ch);
            prefixNode.readFromFile(reader);
            if (children == null) {
                children = new ArrayList<>();
            }
            children.add(prefixNode);
        }
    }

    public static PrefixNode readFromFile(String path) {
        PrefixNode root = new PrefixNode(' ');
        try (FileReader reader = new FileReader(path)) {
            reader.read();
            root.readFromFile(reader);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return root;
    }
}
