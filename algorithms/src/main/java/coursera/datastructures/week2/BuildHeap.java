package coursera.datastructures.week2;

import java.io.*;
import java.util.*;

public class BuildHeap {
    private int[] data;
    private List<Swap> swaps = new LinkedList<>();

    private FastScanner in;
    private PrintWriter out;
    private int size;

//    public static void main(String[] args) throws IOException {
//        new BuildHeap().solve();
//    }

    private void readData() throws IOException {
        int n = in.nextInt();
        this.size = n;
        data = new int[n];
        for (int i = 0; i < n; ++i) {
          data[i] = in.nextInt();
        }
    }

    private void writeResponse() {
        out.println(swaps.size());
        for (Swap swap : swaps) {
          out.println(swap.index1 + " " + swap.index2);
        }
    }
    private boolean hasParent(int currIdx)
    {
        return parentIndex(currIdx) >= 0;
    }
    private boolean hasLeftChild(int currIdx)
    {
        return leftChildIndex(currIdx) < size && leftChild(currIdx) < size;
    }
    private boolean hasRightChild(int currIdx) { return rightChildIndex(currIdx) < size && rightChild(currIdx) < size; }

    private int leftChild(int currIdx)
    {
        return data[leftChildIndex(currIdx)];
    }
    private int rightChild(int currIdx)
    {
        return data[rightChildIndex(currIdx)];
    }
    private int parent(int currIdx) {return data[parentIndex(currIdx)];}

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

    private void buildHeap(int root) {
        while(hasLeftChild(root)) {
            int smallerChildIndex = leftChildIndex(root);
            if (hasRightChild(root) && rightChild(root) < leftChild(root)) {
                smallerChildIndex = rightChildIndex(root);
            }
            if (data[root] < data[smallerChildIndex]) break;
            else {
                int temp = data[root];
                data[root] = data[smallerChildIndex];
                data[smallerChildIndex] = temp;
                swaps.add(new Swap(root, smallerChildIndex));
            }
            root = smallerChildIndex;
        }
    }

    private void generateSwaps() {
        for (int i = (data.length / 2) - 1; i >= 0; i--) {
            buildHeap(i);
        }
    }

    public void solve(FastScanner fastScanner) throws IOException {
        in = fastScanner;
        out = new PrintWriter(new BufferedOutputStream(System.out));
        readData();
        generateSwaps();
        writeResponse();
        out.close();
    }

    static class Swap {
        int index1;
        int index2;

        public Swap(int index1, int index2) {
            this.index1 = index1;
            this.index2 = index2;
        }
    }

    static class FastScanner {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public FastScanner() {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = null;
        }

        public FastScanner(InputStreamReader inputStreamReader) {
            reader = new BufferedReader(inputStreamReader);
            tokenizer = null;
        }

        public String next() throws IOException {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}
