package sample.exercise12;

import java.util.List;
import java.util.Stack;

public class MyStack<E> extends Stack<E> {
    public MyStack() {
    }

    public MyStack(List<E> list) {
        addElement(list);
    }

    protected synchronized void addElement(List<E> list) {
        list.forEach(this::push);
    }
}
