package ua.edu.ucu.iterator;

import java.util.Iterator;


public class DefaultIterator implements Iterable<Integer> {
    private int[] array;

    public DefaultIterator(int[] array) {
        this.array = array;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < array.length;
            }

            @Override
            public Integer next() {
                int value = array[currentIndex];
                currentIndex += 1;
                return value;
            }
        };
    }
}