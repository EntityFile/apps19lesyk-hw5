package ua.edu.ucu.stream;

import ua.edu.ucu.function.*;
import ua.edu.ucu.iterator.DefaultIterator;
import ua.edu.ucu.iterator.FilterIterator;
import ua.edu.ucu.iterator.FlatMapIterator;
import ua.edu.ucu.iterator.MapIterator;

public class AsIntStream implements IntStream {
    private Iterable<Integer> iter;


    private AsIntStream(Iterable<Integer> iter) {
        this.iter = iter;
    }

    public static IntStream of(int... values) {
        return new AsIntStream(new DefaultIterator(values));
    }

    public Iterable<Integer> getIter() {
        return iter;
    }

    @Override
    public Double average() {
        double average = 0;
        int number = 0;

        for (int value : iter) {
            average += value;
            number += 1;
        }
        if (number == 0) {
            return null;
        }
        average = average/number;

        return average;
    }

    @Override
    public Integer max() {
        int max = Integer.MIN_VALUE;

        if (count() == 0) {
            return null;
        }

        for (int value : iter) {
            if (value > max) {
                max = value;
            }
        }

        return max;
    }

    @Override
    public Integer min() {
        int min = Integer.MAX_VALUE;

        if (count() == 0) {
            return null;
        }

        for (int value : iter) {
            if (value < min) {
                min = value;
            }
        }

        return min;
    }

    @Override
    public long count() {
        long number = 0;

        for (int value : iter) {
            number += 1;
        }

        return number;
    }

    @Override
    public Integer sum() {
        int sum = 0;

        for (int value : iter) {
            sum += value;
        }

        return sum;
    }

    @Override
    public IntStream filter(IntPredicate predicate) {
        return new AsIntStream(new FilterIterator(iter, predicate));
    }

    @Override
    public void forEach(IntConsumer action) {
        for (int value : iter) {
            action.accept(value);
        }
    }

    @Override
    public IntStream map(IntUnaryOperator mapper) {
        return new AsIntStream(new MapIterator(iter, mapper));
    }

    @Override
    public IntStream flatMap(IntToIntStreamFunction func) {
        return new AsIntStream(new FlatMapIterator(iter, func));
    }

    @Override
    public int reduce(int identity, IntBinaryOperator op) {
        int result = identity;

        for (int value : iter) {
            result = op.apply(result, value);
        }

        return result;
    }

    @Override
    public int[] toArray() {
        long length = count();
        int[] array = new int[(int) length];
        int index = 0;

        for (int value : iter) {
            array[index] = value;
            index += 1;
        }

        return array;
    }
}
