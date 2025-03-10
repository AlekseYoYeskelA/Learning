package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex5 {
    public static void main(String[] args) {
        //03/25 1234 5678 91213 4567 (987)
        String myString = "12345678912345670325987;" + "98765432165498750921654;" + "85274196345612381122333";
        Pattern pattern = Pattern.compile("(\\d{4})(\\d{4})(\\d{4})(\\d{4})(\\d{2})(\\d{2})(\\d{3})");

        Matcher matcher = pattern.matcher(myString);
//        String myNewString = matcher.replaceAll("$5/$6 $1 $2 $3 $4 ($7)");
//        System.out.println(myNewString);

        while (matcher.find()){
            System.out.println(matcher.group());
        }
    }
}
