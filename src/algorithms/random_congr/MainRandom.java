package algorithms.random_congr;

public class MainRandom {
    public static void main(String[] args) {
        Random random = new Random(14, 31, 71, 256);
        for (int i = 0; i < 100; i++) {
            System.out.print(random.get() + " ");
        }
    }

    public static class Random {
        private int lastNumber;
        private final int A;
        private final int C;
        private final int M;

        public Random(int seed, int a, int c, int m) {
            this.lastNumber = seed;
            this.A = a;
            this.C = c;
            this.M = m;
        }

        public int get() {
            lastNumber = (A * lastNumber + C) % M;
            return lastNumber;
        }
    }
}
