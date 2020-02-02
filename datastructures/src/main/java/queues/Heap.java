package queues;

import java.util.Arrays;

public class Heap
{
    private int[] minHeap;
    private int capacity; // to get the initial size
    private int size;

    public Heap(int initalCapacity)
    {
        this.capacity = initalCapacity;
        minHeap = new int[capacity];
    }

    private void ensureCapacity()
    {
        if ((size == capacity))
        {
            minHeap = Arrays.copyOf(minHeap, minHeap.length * 2);
            capacity = capacity * 2;
        }
    }

    private boolean hasParent(int currIdx)
    {
        return parentIndex(currIdx) >= 0;
    }
    private boolean hasLeftChild(int currIdx)
    {
        return leftChild(currIdx) < size;
    }
    private boolean hasRightChild(int currIdx) { return rightChild(currIdx) < size; }

    private int leftChild(int currIdx)
    {
        return minHeap[leftChildIndex(currIdx)];
    }
    private int rightChild(int currIdx)
    {
        return minHeap[rightChildIndex(currIdx)];
    }
    private int parent(int currIdx) {return minHeap[parentIndex(currIdx)];}

    private int leftChildIndex(int currIdx)
    {
        return currIdx * 2 + 1;
    }
    private int rightChildIndex(int currIdx)
    {
        return currIdx * 2 + 2;
    }
    private int parentIndex(int currIdx)
    {
        return (currIdx - 1) / 2;
    }

    private void heapifyUp()
    {
        int leafIndex = size - 1;
        while(hasParent(leafIndex) && parent(leafIndex) > minHeap[leafIndex])
        {
            swap(parentIndex(leafIndex), leafIndex);
            leafIndex = parentIndex(leafIndex);
        }
    }

    private void swap(int first, int second)
    {
        int temp = minHeap[first];
        minHeap[first] = minHeap[second];
        minHeap[second] = temp;
    }

    private void heapifyDown()
    {
        int nextRoot = 0;
        while (hasLeftChild(nextRoot))
        {
            int smallerChildIndex = leftChildIndex(nextRoot);
            if (hasRightChild(nextRoot) && rightChild(nextRoot) < leftChild(nextRoot))
            {
                smallerChildIndex = rightChildIndex(nextRoot);
            }
            if (minHeap[nextRoot] < minHeap[smallerChildIndex]) break;
            else {
                swap(nextRoot, smallerChildIndex);
            }
            nextRoot = smallerChildIndex;
        }

    }

    private void insert(int element)
    {
        // expand if necessary
        ensureCapacity();
        // append to the array
        minHeap[size] = element;
        // increment the size of the array
        ++size;
        // bubble up
        heapifyUp();
        printArray();
    }

    // removes the min element
    private int poll()
    {
        if (size == 0) throw new IllegalStateException();
        int el = minHeap[0];
        minHeap[0] = minHeap[size - 1];
        size --;
        heapifyDown();
        return el;
    }

    // gets the min element
    private int peek()
    {
        if (size == 0) throw new IllegalStateException();
        return minHeap[0];
    }

    public static void main(String[] args)
    {
        Heap heap = new Heap(10);
        heap.insert(20);
        heap.insert(15);
        heap.insert(10);
        heap.printArray();
        heap.insert(17);
        heap.insert(8);
//        System.out.println("Element removed - " + heap.poll());
//        System.out.println("New minimum element - " + heap.peek());
    }

    private void printArray()
    {
        for (int i = 0; i < size; i++)
        {
            System.out.printf("%d - ", minHeap[i]);
        }
        System.out.println();
    }
}
