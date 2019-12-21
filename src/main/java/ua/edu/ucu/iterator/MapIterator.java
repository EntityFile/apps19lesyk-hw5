package ua.edu.ucu.iterator;

import ua.edu.ucu.function.IntUnaryOperator;

import java.util.Iterator;


public class MapIterator implements Iterable<Integer> {
    private Iterable<Integer> iter;
    private IntUnaryOperator mapper;

    public MapIterator(Iterable<Integer> iter, IntUnaryOperator mapper) {
        this.iter = iter;
        this.mapper = mapper;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private int currentValue;
            private Iterator<Integer> iterator = iter.iterator();


            @Override
            public boolean hasNext() {
                if (iterator.hasNext()) {
                    currentValue = iterator.next();
                    return true;
                }

                return false;
            }

            @Override
            public Integer next() {
                return mapper.apply(currentValue);
            }
        };
    }
}