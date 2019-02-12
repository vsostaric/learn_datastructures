package iterators;

import java.util.ListIterator;

public class MyListIterator<T> implements ListIterator<T> {

    private T[] elements;
    private int index;
    private int size;

    public MyListIterator(T[] elements) {
        this.elements = elements;
        this.size = elements.length;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < size;
    }

    @Override
    public T next() {
        if (hasNext()) {
            return this.elements[index++];
        }
        return null;
    }

    @Override
    public boolean hasPrevious() {
        return index > 0;
    }

    @Override
    public T previous() {
        if (hasPrevious()) {
            return this.elements[index--];
        }
        return null;
    }

    @Override
    public int nextIndex() {
        return index + 1;
    }

    @Override
    public int previousIndex() {
        return index - 1;
    }

    @Override
    public void remove() {

    }

    @Override
    public void set(T t) {

    }

    @Override
    public void add(T t) {

    }
}
