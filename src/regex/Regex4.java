package regex;

public class Regex4 {
    public static void main(String[] args) {
        String s1 = "Privet,     moy drug! Kak idet izuchenie     Java       ?";
        //s1 = s1.replace("Java", "SQL");
        //s1 = s1.replaceAll(" {2,}", " ");
        //s1 = s1.replaceAll("\\bi\\w+", "4444");
        s1 = s1.replaceFirst("\\bi\\w+", "4444");
        System.out.println(s1);
    }
}
