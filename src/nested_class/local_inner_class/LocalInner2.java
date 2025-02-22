package nested_class.local_inner_class;

public class LocalInner2 {
    public static void main(String[] args) {
        class Slojenie implements MathDo{

            @Override
            public int doOperation(int a, int b){
                return a+b;
            }
        }
    Slojenie s = new Slojenie();
        System.out.println(s.doOperation(5,3));
    }
}

interface MathDo{
    int doOperation(int a, int b);
}
