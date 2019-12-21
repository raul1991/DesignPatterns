package arrays;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Just another implmentation of an ArrayList
 * @param <R>
 */
public class ResizeableArray<R> {
    private int size;
    private int capacity;
    private R[] array;

    public ResizeableArray() {
        this.capacity = 10;
        this.array = (R[]) new Object[capacity];
    }

    public boolean add(R item) {
        if (isThresholdReached()) {
            array = (R[]) resize();
        }
        array[size++] = item;
        return true;
    }

    public R remove(int index) throws IndexOutOfBoundsException {
        // find if the index is valid or not
        if (isValidIndex(index)) {
            // if valid, copy the shifted items back to this array
            R oldValue = array[index];
            int movedItems = size - index - 1;
            System.arraycopy(array, index + 1, array, index, movedItems);
            array[--size] = null;
            return oldValue;
        }
        else {
            throw new ArrayIndexOutOfBoundsException(String.format("Index out of bounds size: %d, index: %d", size, index));
        }
        // once shifting is done, make the last entry null to be gced
        // using index here is of no use since it would have been replaced with index + 1 value
    }

    private boolean isValidIndex(int index) {
        return index < size;
    }

    public boolean contains(R item) {
        return IntStream.range(0, size).anyMatch(idx -> array[idx].equals(item));
    }

    public R get(int index) {
        if (isValidIndex(index)) {
            return array[index];
        }
        else {
            throw new ArrayIndexOutOfBoundsException(String.format("Index out of bounds size: %d, index: %d", size, index));
        }
    }

    private Object[] resize() {
        R[] newArray = Arrays.copyOf(array, capacity * 2);
        Arrays.fill(array, null);
        return newArray;
    }

    private boolean isThresholdReached() {
        return capacity / 2 == size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        Arrays.fill(array, null);
        size = 0;
    }

    public int size() {
        return size;
    }
}
