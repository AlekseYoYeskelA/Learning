package nested_class.local_inner_class;

public class LocalInner1 {
    public static void main(String[] args) {
        Math math = new Math();
        math.getResult(21,4);
    }
}

class Math {
    private int a = 10;
    public void getResult(final int delimoe, final int delitel) {



        //local inner class виден только внутри блока, в котором он находится, по аналогии с локальными переменными
        //local inner class не может быть static
        //local inner class может обращаться к элементам блока, в котором он написан, при условии, что они final или effectively final
        class Delenie {
//            private int delimoe;
//            private int delitel;

//            public int getDelimoe() {
//                return delimoe;
//            }
//
//            public void setDelimoe(int delimoe) {
//                this.delimoe = delimoe;
//            }
//
//            public int getDelitel() {
//                return delitel;
//            }
//
//            public void setDelitel(int delitel) {
//                this.delitel = delitel;
//            }

            public int getChastnoe() {
                return delimoe / delitel;
            }

            public int getOstatok() {
                System.out.println(a); //local inner class видит private переменные внешнего класса
                return delimoe % delitel;
            }
        }

        Delenie delenie = new Delenie();
//        delenie.setDelimoe(21);
//        delenie.setDelitel(4);
//        System.out.println("Delimoe = " + delenie.getDelimoe());
//        System.out.println("Delitel = " + delenie.getDelitel());
        System.out.println("Delimoe = " + delenie);
        System.out.println("Delitel = " + delenie);
        System.out.println("Chastnoe = " + delenie.getChastnoe());
        System.out.println("Ostatok = " + delenie.getOstatok());
    }
}
