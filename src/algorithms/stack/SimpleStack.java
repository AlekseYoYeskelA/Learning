package algorithms.stack;

import java.util.ArrayList;

public class SimpleStack<T> implements Stack<T> {
    private ArrayList<T> list = new ArrayList<>();

    @Override
    public void push(T item) {
        list.add(item);
    }

    @Override
    public T pop() {
        return list.removeLast();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
}

