package stream_api;

import java.util.ArrayList;
import java.util.List;

public class ParallelStream {
    public static void main(String[] args) {
        List<Double> list = new ArrayList<>();
        list.add(10.0);
        list.add(5.0);
        list.add(1.0);
        list.add(0.25);

        double sumResult = list.parallelStream()
                .reduce((acc, el) -> acc+el)
                .get();
        System.out.println(sumResult);

        double divResult = list.stream() //использование parallelStream, где важен порядок элементов, возвратит некорректный результат
                .reduce((acc, el) -> acc/el)
                .get();
        System.out.println(divResult);

    }
}
