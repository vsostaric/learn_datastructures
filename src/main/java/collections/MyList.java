package collections;

import iterators.MyListIterator;

import java.util.*;

public class MyList<T> implements List<T> {

    private static final int INITIAL_LIST_SIZE = 10;

    private int capacity;
    private T[] elements;
    private int size;

    public MyList() {
        elements = (T[]) new Object[INITIAL_LIST_SIZE];
        size = 0;
        capacity = INITIAL_LIST_SIZE;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(final Object o) {
        return Arrays.stream(elements)
                .filter(Objects::nonNull)
                .anyMatch(element -> element.equals(o));
    }

    @Override
    public Iterator<T> iterator() {
        return new MyListIterator<T>(elements);
    }

    @Override
    public Object[] toArray() {
        return elements;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T t) {
        if (size == capacity) {
            capacity = capacity + INITIAL_LIST_SIZE;
            T[] new_elements = (T[]) new Object[capacity];
            if (size >= 0) System.arraycopy(elements, 0, new_elements, 0, size);
            elements = new_elements;
        }

        elements[size++] = t;
        return true;
    }

    @Override
    public boolean remove(Object o) {

        var new_elements = (T[]) new Object[capacity];
        int new_size = size;
        int j = 0;
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(o)) {
                new_size--;
            } else {
                new_elements[j] = elements[i];
                j++;
            }
        }
        elements = new_elements;
        size = new_size;
        return true;
    }


    @Override
    public boolean containsAll(Collection<?> c) {
        return c.stream().allMatch(this::contains);
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        boolean result = true;
        for (var el : c) {
            result = add(el);
        }
        return result;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean result = true;
        for (var el : c) {
            result = remove(el);
        }
        return result;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public T get(int index) {
        return elements[index];
    }

    @Override
    public T set(int index, T element) {
        return null;
    }

    @Override
    public void add(int index, T element) {

    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }
}
