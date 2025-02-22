package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static String getName(String s) {
        int space1 = s.indexOf(" ");
        String surname = s.substring(0, space1);
        String initial1 = s.substring(space1 + 1, space1 + 2);
        int space2 = s.indexOf(" ", space1 + 1);
        String initial2 = s.substring(space2 + 1, space2 + 2);
        return surname + " " + initial1 + "." + initial2 + ".";
    }


    public static String getName2(String s) {
        String[] arr = null;
        try {
            arr = s.split(" ");
            String name = arr[1].charAt(0) + ".";
            String secondName = arr[2].charAt(0) + ".";
            arr[1] = name;
            arr[2] = secondName;
            return String.join(" ", arr);
        } catch (StringIndexOutOfBoundsException se) {
            System.out.println("Введены два пробела, удалите лишний пробел");
        }
        return "";
    }


    public static String getName3(String s) {
        String[] arr = s.split(" ");
        String surname = arr[1] + " ";
        String name = arr[1].substring(0, 1) + ".";
        String lastname = arr[2].substring(0, 1) + ".";
        return surname + name + lastname;
    }

    public static List<String> concatAppeal(List<String> names) {
        for (int i = 0; i < names.size(); i++) {
            names.set(i, (String.format("Уважаемый, %s!", names.get(i))));
        }
        return names;
    }
}

class Test1 {
    public static void main(String[] args) {
        String s = "Busarov  Alexey  Aleksandrovich";
        System.out.println(Test.getName2(s));

        List<String> names = new ArrayList<>();
        names.add("Иван");
        names.add("Алексей");
        names.add("Дмитрий");
        System.out.println(Test.concatAppeal(names));
    }
}

