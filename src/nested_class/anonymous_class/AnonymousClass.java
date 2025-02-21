package nested_class.anonymous_class;

public class AnonymousClass {
    private int x = 5;

    public static void main(String[] args) {
        MathDo md = new MathDo() {
            int c = 10;

            void abc() {
            }

            @Override
            public int doOperation(int a, int b) {
                AnonymousClass ac = new AnonymousClass();
                return a + b + ac.x;
            }
        };

        MathDo md2 = new MathDo() {
            @Override
            public int doOperation(int a, int b) {
                return a * b;
            }
        };
        System.out.println(md.doOperation(3, 6));
        System.out.println(md2.doOperation(3, 6));
    }
}

class MathDo {
    int doOperation(int a, int b) {
        return a / b;
    }
}