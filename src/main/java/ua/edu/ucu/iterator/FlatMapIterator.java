package ua.edu.ucu.iterator;


import ua.edu.ucu.function.IntToIntStreamFunction;
import ua.edu.ucu.stream.AsIntStream;

import java.util.Iterator;


public class FlatMapIterator implements Iterable<Integer> {
    private Iterable<Integer> iter;
    private IntToIntStreamFunction func;

    public FlatMapIterator(Iterable<Integer> iter, IntToIntStreamFunction func) {
        this.iter = iter;
        this.func = func;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private Iterator<Integer> iterator = iter.iterator();
            private Iterator<Integer> additionalIter;

            @Override
            public boolean hasNext() {
                if (additionalIter != null && additionalIter.hasNext()) {
                    return true;
                }
                if (iterator.hasNext()){
                    additionalIter = ((AsIntStream) func.applyAsIntStream(iterator.next())).getIter().iterator();
                    return true;
                }
                return false;
            }

            @Override
            public Integer next() {
                return additionalIter.next();
            }
        };
    }
}