package ua.edu.ucu.iterator;

import ua.edu.ucu.function.IntPredicate;

import java.util.Iterator;


public class FilterIterator implements Iterable<Integer> {
    private Iterable<Integer> iter;
    private IntPredicate predicate;

    public FilterIterator(Iterable<Integer> iter, IntPredicate predicate) {
        this.iter = iter;
        this.predicate = predicate;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private int currentValue;
            private Iterator<Integer> iterator = iter.iterator();

            @Override
            public boolean hasNext() {
                while (iterator.hasNext()) {
                    currentValue = iterator.next();
                    if (predicate.test(currentValue)) {
                        return true;
                    }
                }

                return false;
            }

            @Override
            public Integer next() {
                return currentValue;
            }
        };
    }
}