package coursera.datastructures.week1;

import java.io.*;
import java.util.StringTokenizer;

public class TreeHeight {

    public Report run(String inFilePath) throws IOException {
        TreeHeightInterface tree = new TreeHeightInterface();
        long start = System.currentTimeMillis();
        tree.read(new FastScanner(inFilePath));
        return new Report(tree.n, ((System.currentTimeMillis() - start)), tree.computeHeight());
    }
    public static class Report {

        private int size;
        private long time;
        private int result;

        public Report(int size, long time, int result) {
            this.size = size;
            this.time = time;
            this.result = result;
        }

        public int getSize() {
            return size;
        }

        public long getTime() {
            return time;
        }

        public int getResult() {
            return result;
        }
    }

    class FastScanner {
        StringTokenizer tok = new StringTokenizer("");
        BufferedReader in;

        FastScanner() {
            in = new BufferedReader(new InputStreamReader(System.in));
        }

        FastScanner(String inFilePath) {
            try {
                in = new BufferedReader(new InputStreamReader(new FileInputStream(inFilePath)));
            } catch (FileNotFoundException e) {
                System.out.printf("Error reading from the input file %s%n", inFilePath);
            }
        }

        String next() throws IOException {
            while (!tok.hasMoreElements())
                tok = new StringTokenizer(in.readLine());
            return tok.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }

    public class TreeHeightInterface {
        int n;
        int[] parent;
        int[] depth;

        void read(FastScanner in) throws IOException {
            n = in.nextInt();
            parent = new int[n];
            depth = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = in.nextInt();
            }
        }

        int computeHeight() {
            int[] depth = new int[n];
            int maxHeight = 0;
            for (int i = 0; i < n; i++) {
                int height = computeHeight(parent, depth, i);
                maxHeight = Math.max(height, maxHeight);
            }
            return maxHeight;
        }

        private int computeHeight(int[] parent, int[] depth, int idx) {
            if (parent[idx] == -1) {
                // root found
                depth[idx] = 1;
                return depth[idx];
            }
            // depth of parent unknown
            if (depth[parent[idx]] == 0) {
                computeHeight(parent, depth, parent[idx]);
            }
            depth[idx] = depth[parent[idx]] + 1;
            return depth[idx];
        }
    }
}
