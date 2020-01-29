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
        rangeCheckForAdd(index);
        // find if the index is valid or not
        // if valid, copy the shifted items back to this array
        R oldValue = array[index];
        int movedItems = size - index - 1;
        System.arraycopy(array, index + 1, array, index, movedItems);
        array[--size] = null;
        return oldValue;

        // once shifting is done, make the last entry null to be gced
        // using index here is of no use since it would have been replaced with index + 1 value
    }

    private void rangeCheck(int index) {
        if (index >= size)
            throw new ArrayIndexOutOfBoundsException(String.format("Index out of bounds size: %d, index: %d", size, index));
    }

    /**
     * A version of rangeCheck used by add and addAll.
     */
    private void rangeCheckForAdd(int index) {
        if (index > size || index < 0)
            throw new ArrayIndexOutOfBoundsException(String.format("Index out of bounds size: %d, index: %d", size, index));
    }

    public boolean contains(R item) {
        return IntStream.range(0, size).anyMatch(idx -> array[idx].equals(item));
    }

    public R get(int index) {
        rangeCheck(index);
        return array[index];
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

    public boolean add(R item, int index) {
        rangeCheckForAdd(index);
        int movedItems = size - index - 1;
        System.arraycopy(array, index, array, index + 1, movedItems);
        array[index] = item;
        ++size;
        return true;
    }

    // inserts item at position 0
    public void prepend(R item) {
        if (size == 0) {
            array[0] = item;
            return;
        }
        add(item, 0);
    }


    public R remove(R item) {
        int pos = -1;
        if (item == null) {
            for (int i = 0; i < size; i++) {
                if (array[i] == null) {
                    pos = i;
                    break;
                }
            }
        }
        else {
            for (int i = 0; i < size; i++) {
                if (array[i].equals(item)) {
                    pos = i;
                    break;
                }
            }

        }
        int movedItems = size - pos - 1;
        System.arraycopy(array, pos + 1, array, pos, movedItems);
        array[--size] = null; // deleted item to be gc'ed
        return pos == -1 ? null : array[pos];
    }
}
