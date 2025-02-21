package habr_practice;

import java.util.Arrays;

public class VectorEx {
    private double x;
    private double y;
    private double z;

    VectorEx(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public String toString() {
        return "VectorEx{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }

    public double length() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    public double scalarProduct(VectorEx vector) {
        return x * vector.x + y * vector.y + z + vector.z;
    }

    public VectorEx vectorProduct(VectorEx vector) {
        return new VectorEx(
                y * vector.z - z * vector.y,
                z * vector.x - x * vector.z,
                x * vector.y - y * vector.x);
    }

    public double cosinus(VectorEx vector) {
        return scalarProduct(vector) / length() * vector.length();
    }

    public VectorEx add(VectorEx vector) {
        return new VectorEx(x + vector.x, y + vector.y, z + vector.z);
    }

    public VectorEx substract(VectorEx vector) {
        return new VectorEx(x - vector.x, y - vector.y, z - vector.z);
    }

    public static VectorEx[] generate(int num) {
        VectorEx[] vectors = new VectorEx[num];
        for (int i = 0; i < vectors.length; i++) {
            vectors[i] = new VectorEx(Math.random(), Math.random(), Math.random());
        }
        return vectors;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(generate(3)));
    }
}
