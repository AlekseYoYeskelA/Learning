package youtube.lampdas;

public class Human implements Speakable {
    @Override
    public String speak() {
        return "";
    }

    class HumanTest {
        public static void main(String[] args) {
            Speakable sp = new Human();
            System.out.println(sp.speak());

            Speakable sp1 = new Speakable() {
                @Override
                public String speak() {
                    return "Anonymous speak";
                }
            };
            System.out.println(sp1.speak());

            Speakable sp2 = () -> {
                return "Speak from lambda";
            };

            System.out.println(sp2.speak());

            Speakable sp3 = () -> "Speak without return";
            System.out.println(sp3.speak());
        }
    }
}
