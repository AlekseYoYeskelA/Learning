package algorithms.prefix_tree;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class PrefixTreeEx {
    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("C:\\Users\\Алексей\\Desktop\\numbers.txt"));

        PrefixNode root = new PrefixNode(' ');
        for (String line : lines) {
            root.insert(line);
        }
        //System.out.println(root.containsString("18АО7321"));

        List<String> extractedFromTree = new ArrayList<>();
        //root.getAllNumbers("", extractedFromTree);

        PrefixNode.writeTreeToFile("C:\\Users\\Алексей\\IdeaProjects\\Learning\\src\\youtube\\prefix_tree\\tree.dat", root);

        PrefixNode fromFile = PrefixNode.readFromFile("C:\\Users\\Алексей\\IdeaProjects\\Learning\\src\\youtube\\prefix_tree\\tree.dat");
        fromFile.getAllNumbers("", extractedFromTree);
    }
}

